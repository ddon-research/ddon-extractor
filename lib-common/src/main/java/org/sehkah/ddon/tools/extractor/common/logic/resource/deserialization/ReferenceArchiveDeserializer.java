package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ArchiveS;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ResourceInfoS;

import java.math.BigInteger;
import java.nio.file.Path;
import java.util.List;

/**
 * An ARCS file is simply a collection of 8-byte long IDs to reference already loaded resources.
 * During runtime this ID is used to look up the resource via lookup table (see sResource::findTable).
 * The ID is made up of the DTI ID & a null-terminated file path (see sResource::makeID):
 * <code>
 * mID = dti->mID;
 * str = path + '\0'
 * (mID << 32) | getCRC(str, 0xFFFFFFFF);
 * </code>
 * This is used for *_mod.arc, *_fedt_jntpreset.arc, *_dds.arc, armor\ac_*.arc, armor\np*.arc, wp\wp*.arc.
 * For example, the ARCS file "eye0_fedt_jntpreset.arc" represents a reference to resource "eye0.fedt_jntpreset".
 */
public class ReferenceArchiveDeserializer extends ClientResourceFileDeserializer<ArchiveS> {
    public static ResourceInfoS readResourceInfoS(BufferReader bufferReader) {
        BigInteger ResourceID = bufferReader.readUnsignedLong();
        long Type = FrameworkResourcesUtil.convertResourceIdToTagId(ResourceID);
        String TypeName = FrameworkResourcesUtil.getFrameworkResourceClassNameByCrc(Type);
        long PathCRC = FrameworkResourcesUtil.convertResourceIdToPathId(ResourceID);

        return new ResourceInfoS(ResourceID, Type, TypeName, PathCRC);
    }

    @Override
    protected ArchiveS parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        List<ResourceInfoS> resourceReferenceIds = bufferReader.readArray(BufferReader::readUnsignedShort, ReferenceArchiveDeserializer::readResourceInfoS);

        return new ArchiveS(
                resourceReferenceIds.size(),
                resourceReferenceIds
        );
    }
}
