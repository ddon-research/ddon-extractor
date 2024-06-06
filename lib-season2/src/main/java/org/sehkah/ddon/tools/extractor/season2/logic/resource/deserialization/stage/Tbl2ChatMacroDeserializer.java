package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.Tbl2ChatMacro;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.Tbl2ChatMacroList;

public class Tbl2ChatMacroDeserializer extends ClientResourceFileDeserializer {


    private static Tbl2ChatMacro readTbl2ChatMacro(BufferReader bufferReader) {
        return new Tbl2ChatMacro(
                bufferReader.readMtString(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected Tbl2ChatMacroList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new Tbl2ChatMacroList(bufferReader.readArray(Tbl2ChatMacroDeserializer::readTbl2ChatMacro));
    }
}
