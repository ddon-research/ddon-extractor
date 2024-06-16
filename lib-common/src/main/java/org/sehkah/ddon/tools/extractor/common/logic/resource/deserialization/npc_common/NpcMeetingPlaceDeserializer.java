package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcMeetingPlace;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcMeetingPlaceList;

import java.nio.file.Path;

public class NpcMeetingPlaceDeserializer extends ClientResourceFileDeserializer<NpcMeetingPlaceList> {
    private static NpcMeetingPlace readNpcMeetingPlace(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long NpcId = bufferReader.readUnsignedInteger();
        Translation NpcName = null;
        if (lookupUtil != null) {
            NpcName = lookupUtil.getNpcName(NpcId);
        }
        int StageNo = bufferReader.readSignedInteger();
        long StartPosNo = bufferReader.readUnsignedInteger();

        return new NpcMeetingPlace(NpcId, NpcName, StageNo, StartPosNo);
    }

    @Override
    protected NpcMeetingPlaceList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NpcMeetingPlaceList(bufferReader.readArray(NpcMeetingPlaceDeserializer::readNpcMeetingPlace, lookupUtil));
    }
}
