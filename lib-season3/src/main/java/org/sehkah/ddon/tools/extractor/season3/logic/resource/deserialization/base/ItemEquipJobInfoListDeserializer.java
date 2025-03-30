package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.JobType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.ItemEquipJobInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.ItemEquipJobInfoList;

import java.nio.file.Path;
import java.util.Set;

public class ItemEquipJobInfoListDeserializer extends ClientResourceFileDeserializer<ItemEquipJobInfoList> {
    private static ItemEquipJobInfo readItemEquipJobInfo(BufferReader bufferReader) {
        long IsUseJob = bufferReader.readUnsignedInteger();
        Set<JobType> IsUseJobList = BitUtil.extractBitSetUnsignedIntegerFlag(JobType::of, IsUseJob);

        return new ItemEquipJobInfo(IsUseJob, IsUseJobList);
    }

    @Override
    protected ItemEquipJobInfoList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new ItemEquipJobInfoList(bufferReader.readArray(ItemEquipJobInfoListDeserializer::readItemEquipJobInfo));
    }
}
