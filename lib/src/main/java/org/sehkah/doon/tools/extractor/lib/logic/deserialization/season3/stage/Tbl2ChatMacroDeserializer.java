package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.stage;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.Tbl2ChatMacro;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.Tbl2ChatMacroList;

public class Tbl2ChatMacroDeserializer extends ClientResourceFileDeserializer {
    public Tbl2ChatMacroDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static Tbl2ChatMacro readTbl2ChatMacro(FileReader fileReader) {
        return new Tbl2ChatMacro(
                fileReader.readMtString(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected Tbl2ChatMacroList parseClientResourceFile(FileReader fileReader) {
        return new Tbl2ChatMacroList(fileReader.readArray(Tbl2ChatMacroDeserializer::readTbl2ChatMacro));
    }
}
