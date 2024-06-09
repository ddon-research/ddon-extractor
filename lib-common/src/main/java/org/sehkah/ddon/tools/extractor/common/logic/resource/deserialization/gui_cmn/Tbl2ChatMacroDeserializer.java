package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.Tbl2ChatMacro;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.Tbl2ChatMacroList;

import java.nio.file.Path;

public class Tbl2ChatMacroDeserializer extends ClientResourceFileDeserializer<Tbl2ChatMacroList> {
    private static Tbl2ChatMacro readTbl2ChatMacro(BufferReader bufferReader) {
        return new Tbl2ChatMacro(
                bufferReader.readMtString(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected Tbl2ChatMacroList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new Tbl2ChatMacroList(bufferReader.readArray(Tbl2ChatMacroDeserializer::readTbl2ChatMacro));
    }
}
