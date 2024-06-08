package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.NpcMeetingPlace;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.NpcMeetingPlaceList;

import java.nio.file.Path;

public class NpcMeetingPlaceDeserializer extends ClientResourceFileDeserializer<NpcMeetingPlaceList> {


    private static NpcMeetingPlace readNpcMeetingPlace(BufferReader bufferReader) {
        return new NpcMeetingPlace(
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected NpcMeetingPlaceList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NpcMeetingPlaceList(bufferReader.readArray(NpcMeetingPlaceDeserializer::readNpcMeetingPlace));
    }
}
