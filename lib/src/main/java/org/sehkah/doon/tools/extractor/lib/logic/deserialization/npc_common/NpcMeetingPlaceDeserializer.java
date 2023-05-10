package org.sehkah.doon.tools.extractor.lib.logic.deserialization.npc_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.npc_common.NpcMeetingPlace;

import java.util.List;

public class NpcMeetingPlaceDeserializer extends FileDeserializer<List<NpcMeetingPlace>> {
    public NpcMeetingPlaceDeserializer() {
        super(ClientResourceFile.rNpcMeetingPlace);
    }

    private static NpcMeetingPlace readEntity(FileReader fileReader) {
        return new NpcMeetingPlace(
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<NpcMeetingPlace> readObject(FileReader fileReader) {
        return fileReader.readArray(NpcMeetingPlaceDeserializer::readEntity);
    }
}
