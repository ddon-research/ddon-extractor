package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.character_edit_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common.CharacterEditPaletteBase;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common.CharacterEditTexturePalette;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common.CharacterEditTexturePaletteTable;

import java.nio.file.Path;

public class CharacterEditTexturePaletteTableDeserializer extends ClientResourceFileDeserializer<CharacterEditTexturePaletteTable> {
    private static CharacterEditPaletteBase readCharacterEditPaletteBase(BufferReader bufferReader) {
        return new CharacterEditPaletteBase(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static CharacterEditTexturePalette readCharacterEditTexturePalette(BufferReader bufferReader) {
        return new CharacterEditTexturePalette(
                readCharacterEditPaletteBase(bufferReader),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected CharacterEditTexturePaletteTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CharacterEditTexturePaletteTable(bufferReader.readArray(CharacterEditTexturePaletteTableDeserializer::readCharacterEditTexturePalette));
    }
}
