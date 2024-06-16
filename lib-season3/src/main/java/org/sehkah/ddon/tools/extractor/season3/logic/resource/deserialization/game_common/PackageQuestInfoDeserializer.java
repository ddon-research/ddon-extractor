package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.PackageQuestInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.PackageQuestInfoList;

import java.nio.file.Path;

public class PackageQuestInfoDeserializer extends ClientResourceFileDeserializer<PackageQuestInfoList> {
    private static PackageQuestInfo readPackageQuestInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long PackageNo = bufferReader.readUnsignedInteger();
        long ContentInfoIdx = bufferReader.readUnsignedInteger();
        long GatherNpcId = bufferReader.readUnsignedInteger();
        Translation GatherNpcName = null;
        if (lookupUtil != null) {
            GatherNpcName = lookupUtil.getNpcName(GatherNpcId);
        }
        long GatherStartPos = bufferReader.readUnsignedInteger();
        long ContentNameIdx = bufferReader.readUnsignedInteger();

        return new PackageQuestInfo(PackageNo, ContentInfoIdx, GatherNpcId, GatherNpcName, GatherStartPos, ContentNameIdx);
    }

    @Override
    protected PackageQuestInfoList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new PackageQuestInfoList(bufferReader.readArray(PackageQuestInfoDeserializer::readPackageQuestInfo, lookupUtil));
    }
}
