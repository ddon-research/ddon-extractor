package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.gui_cmn.Tbl2ChatMacro;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.gui_cmn.Tbl2ChatMacroList;

public class Tbl2ChatMacroDeserializer extends ClientResourceFileDeserializer {
    public Tbl2ChatMacroDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static Tbl2ChatMacro readTbl2ChatMacro(BufferReader bufferReader) {
        return new Tbl2ChatMacro(
                bufferReader.readMtString(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected Tbl2ChatMacroList parseClientResourceFile(BufferReader bufferReader) {
        return new Tbl2ChatMacroList(bufferReader.readArray(Tbl2ChatMacroDeserializer::readTbl2ChatMacro));
    }
}
