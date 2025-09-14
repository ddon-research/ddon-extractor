package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization;

import org.sehkah.ddon.tools.extractor.api.crypto.BlowFishUtil;
import org.sehkah.ddon.tools.extractor.api.crypto.ZipUtil;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.Archive;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ResourceInfo;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncryptedArchiveDeserializer extends ClientResourceFileDeserializer<Archive> {

    private static final int ORG_SIZE_MASK = (1 << 29) - 1;
    private static final int QUALITY_MASK = (1 << 3) - 1;
    private static final int DATA_OFFSET = 0x8000;

    private static ResourceInfo readResourceInfo(BufferReader bufferReader) {
        BufferReader temporaryReader = new BinaryReader(BlowFishUtil.decrypt(bufferReader.readSignedByte(80)));

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
    protected Archive parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        List<ResourceInfo> resourceInfos = bufferReader.readArray(BufferReader::readUnsignedShort, EncryptedArchiveDeserializer::readResourceInfo);

        Map<String, byte[]> resourceFileMap = HashMap.newHashMap(resourceInfos.size());
        for (ResourceInfo resourceInfo : resourceInfos) {
            byte[] compressedEncryptedData = bufferReader.copySignedByte((int) resourceInfo.getDataSize(), (int) resourceInfo.getOffset());
            byte[] decryptedData = BlowFishUtil.decrypt(compressedEncryptedData);
            byte[] decompressedData = ZipUtil.decompress(decryptedData, (int) resourceInfo.getOriginalSize());
            if (decompressedData.length != (int) resourceInfo.getOriginalSize()) {
                throw new TechnicalException("Decompressed resource file size '%s' does not match original size '%s'!".formatted(decompressedData.length, resourceInfo.getOriginalSize()));
            }
            bufferReader.setPosition((int) (resourceInfo.getDataSize() + resourceInfo.getOffset()));
            resourceFileMap.put(resourceInfo.getPath() + FrameworkResourcesUtil.getFileExtension(resourceInfo.getTypeName()), decompressedData);
        }

        return new Archive(
                resourceInfos.size(),
                resourceInfos,
                resourceFileMap
        );
    }
}
