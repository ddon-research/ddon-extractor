package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn.Tbl2ChatMacro;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn.Tbl2ChatMacroList;

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
