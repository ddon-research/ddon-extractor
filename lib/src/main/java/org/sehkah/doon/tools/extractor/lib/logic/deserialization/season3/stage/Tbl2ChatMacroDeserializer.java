package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.stage;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.Tbl2ChatMacro;

import java.util.List;

public class Tbl2ChatMacroDeserializer extends ClientResourceFileDeserializer<List<Tbl2ChatMacro>> {
    public Tbl2ChatMacroDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static Tbl2ChatMacro readEntity(FileReader fileReader) {
        return new Tbl2ChatMacro(
                fileReader.readMtString(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<Tbl2ChatMacro> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(Tbl2ChatMacroDeserializer::readEntity);
    }
}
