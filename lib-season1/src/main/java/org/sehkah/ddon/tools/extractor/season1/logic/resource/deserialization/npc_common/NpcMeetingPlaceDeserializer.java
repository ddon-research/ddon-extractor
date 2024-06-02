package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common.NpcMeetingPlace;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common.NpcMeetingPlaceList;

public class NpcMeetingPlaceDeserializer extends ClientResourceFileDeserializer {
    public NpcMeetingPlaceDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NpcMeetingPlace readNpcMeetingPlace(BufferReader bufferReader) {
        return new NpcMeetingPlace(
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected NpcMeetingPlaceList parseClientResourceFile(BufferReader bufferReader) {
        return new NpcMeetingPlaceList(bufferReader.readArray(NpcMeetingPlaceDeserializer::readNpcMeetingPlace));
    }
}
