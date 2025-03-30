package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.PackageQuestClientInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.PackageQuestInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.PackageQuestInfoList;

import java.nio.file.Path;

public class PackageQuestInfoDeserializer extends ClientResourceFileDeserializer<PackageQuestInfoList> {
    private static PackageQuestClientInfo readPackageQuestClientInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long NpcId = bufferReader.readUnsignedInteger();
        Translation NpcName = null;
        if (lookupUtil != null) {
            NpcName = lookupUtil.getNpcName(NpcId);
        }
        long ClientMessageIdx = bufferReader.readUnsignedInteger();

        return new PackageQuestClientInfo(NpcId, NpcName, ClientMessageIdx);
    }

    private static PackageQuestInfo readPackageQuestInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long PackageId = bufferReader.readUnsignedInteger();
        long ContentInfoIdx = bufferReader.readUnsignedInteger();
        PackageQuestClientInfo ClientInfo = readPackageQuestClientInfo(bufferReader, lookupUtil);
        long HistoryMessageIdx = bufferReader.readUnsignedInteger();

        return new PackageQuestInfo(PackageId, ContentInfoIdx, ClientInfo, HistoryMessageIdx);
    }

    @Override
    protected PackageQuestInfoList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new PackageQuestInfoList(bufferReader.readArray(PackageQuestInfoDeserializer::readPackageQuestInfo, lookupUtil));
    }
}
