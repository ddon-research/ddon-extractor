package org.sehkah.ddon.tools.extractor.lib.logic.deserialization;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.ArchiveS;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.ResourceInfoS;

import java.math.BigInteger;
import java.util.List;

/**
 * An ARCS file is simply a collection of 8-byte long IDs to reference already loaded resources.
 * During runtime this ID is used to look up the resource via lookup table (see sResource::findTable).
 * The ID is made up of the DTI ID & a null-terminated file path (see sResource::makeID):
 * <code>
 * mID = dti->mID;
 * str = path + '\0'
 * (mID << 32) | MtCRC::getCRC(str, 0xFFFFFFFF);
 * </code>
 */
public class ReferenceArchiveDeserializer extends ClientResourceFileDeserializer {
    public ReferenceArchiveDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ResourceInfoS readResourceInfoS(FileReader fileReader) {
        BigInteger referenceId = fileReader.readUnsignedLong();
        return new ResourceInfoS(referenceId, referenceId.shiftRight(32).longValue());
    }

    @Override
    protected ArchiveS parseClientResourceFile(FileReader fileReader) {
        List<ResourceInfoS> resourceReferenceIds = fileReader.readArray(FileReader::readUnsignedShort, ReferenceArchiveDeserializer::readResourceInfoS);

        return new ArchiveS(
                resourceReferenceIds.size(),
                resourceReferenceIds
        );
    }
}
