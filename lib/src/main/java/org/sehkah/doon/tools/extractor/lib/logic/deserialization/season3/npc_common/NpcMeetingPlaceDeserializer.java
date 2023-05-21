package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.npc_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.npc_common.NpcMeetingPlace;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.npc_common.NpcMeetingPlaceList;

public class NpcMeetingPlaceDeserializer extends ClientResourceFileDeserializer {
    public NpcMeetingPlaceDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NpcMeetingPlace readNpcMeetingPlace(FileReader fileReader) {
        return new NpcMeetingPlace(
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected NpcMeetingPlaceList parseClientResourceFile(FileReader fileReader) {
        return new NpcMeetingPlaceList(fileReader.readArray(NpcMeetingPlaceDeserializer::readNpcMeetingPlace));
    }
}
