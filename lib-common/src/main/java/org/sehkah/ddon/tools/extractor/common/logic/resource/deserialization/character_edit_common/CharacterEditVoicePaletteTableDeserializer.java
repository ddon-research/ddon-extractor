package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.character_edit_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common.CharacterEditPaletteBase;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common.CharacterEditVoicePalette;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common.CharacterEditVoicePaletteTable;

import java.nio.file.Path;

public class CharacterEditVoicePaletteTableDeserializer extends ClientResourceFileDeserializer<CharacterEditVoicePaletteTable> {
    private static CharacterEditPaletteBase readCharacterEditPaletteBase(BufferReader bufferReader) {
        return new CharacterEditPaletteBase(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static CharacterEditVoicePalette readCharacterEditVoicePalette(BufferReader bufferReader) {
        return new CharacterEditVoicePalette(
                readCharacterEditPaletteBase(bufferReader),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort()
        );
    }

    @Override
    protected CharacterEditVoicePaletteTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CharacterEditVoicePaletteTable(bufferReader.readArray(CharacterEditVoicePaletteTableDeserializer::readCharacterEditVoicePalette));
    }
}
