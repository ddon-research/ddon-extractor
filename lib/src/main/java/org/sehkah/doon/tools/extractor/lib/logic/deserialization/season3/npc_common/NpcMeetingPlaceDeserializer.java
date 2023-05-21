package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.npc_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.npc_common.NpcMeetingPlace;

import java.util.List;

public class NpcMeetingPlaceDeserializer extends ClientResourceFileDeserializer<List<NpcMeetingPlace>> {
    public NpcMeetingPlaceDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NpcMeetingPlace readEntity(FileReader fileReader) {
        return new NpcMeetingPlace(
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<NpcMeetingPlace> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(NpcMeetingPlaceDeserializer::readEntity);
    }
}