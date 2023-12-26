package org.sehkah.ddon.tools.extractor.lib.logic.deserialization;

import org.sehkah.ddon.tools.extractor.lib.common.crypto.BlowFishUtil;
import org.sehkah.ddon.tools.extractor.lib.common.crypto.ZipUtil;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileReader;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.Archive;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.ResourceInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncryptedArchiveDeserializer extends ClientResourceFileDeserializer {

    private static final int ORG_SIZE_MASK = (1 << 29) - 1;
    private static final int QUALITY_MASK = (1 << 3) - 1;
    private static final int DATA_OFFSET = 0x8000;

    public EncryptedArchiveDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ResourceInfo readResourceInfo(FileReader fileReader) {
        FileReader temporaryReader = new BinaryFileReader(BlowFishUtil.decrypt(fileReader.readSignedByte(80)));

        String Path = temporaryReader.readString(64).replace("\0", "");
        long Type = temporaryReader.readUnsignedInteger();
        long DataSize = temporaryReader.readUnsignedInteger();
        long Flags = temporaryReader.readUnsignedInteger();
        long Offset = temporaryReader.readUnsignedInteger();

        return new ResourceInfo(
                Path,
                Type,
                DataSize,
                Flags & ORG_SIZE_MASK,
                (Flags >> 29) & QUALITY_MASK,
                Offset
        );
    }

    @Override
    protected Archive parseClientResourceFile(FileReader fileReader) {
        List<ResourceInfo> resourceInfos = fileReader.readArray(FileReader::readUnsignedShort, EncryptedArchiveDeserializer::readResourceInfo);

        Map<String, byte[]> resourceFileMap = HashMap.newHashMap(resourceInfos.size());
        for (ResourceInfo resourceInfo : resourceInfos) {
            byte[] compressedEncryptedData = fileReader.copySignedByte((int) resourceInfo.DataSize(), (int) resourceInfo.Offset());
            byte[] decompressedData = ZipUtil.decompress(BlowFishUtil.decrypt(compressedEncryptedData), (int) resourceInfo.OriginalSize());
            if (decompressedData.length != (int) resourceInfo.OriginalSize()) {
                throw new TechnicalException("Decompressed resource file size '%s' does not match original size '%s'!".formatted(decompressedData.length, resourceInfo.OriginalSize()));
            }
            fileReader.setPosition((int) (resourceInfo.DataSize() + resourceInfo.Offset()));
            resourceFileMap.put(resourceInfo.Path() + FrameworkResourcesUtil.getFileExtension(resourceInfo.TypeName()), decompressedData);
        }

        return new Archive(
                resourceInfos.size(),
                resourceInfos,
                resourceFileMap
        );
    }
}
