package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.character_edit_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common.CharacterEditColorDef;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common.CharacterEditColorDefTable;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common.CharacterEditPaletteBase;

import java.nio.file.Path;

public class CharacterEditColorDefTableDeserializer extends ClientResourceFileDeserializer<CharacterEditColorDefTable> {
    private static CharacterEditPaletteBase readCharacterEditPaletteBase(BufferReader bufferReader) {
        return new CharacterEditPaletteBase(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static CharacterEditColorDef readCharacterEditColorDef(BufferReader bufferReader) {
        return new CharacterEditColorDef(
                readCharacterEditPaletteBase(bufferReader),
                bufferReader.readBoolean(),
                bufferReader.readVector4f(),
                bufferReader.readColor4l()
        );
    }

    @Override
    protected CharacterEditColorDefTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CharacterEditColorDefTable(bufferReader.readArray(CharacterEditColorDefTableDeserializer::readCharacterEditColorDef));
    }
}
