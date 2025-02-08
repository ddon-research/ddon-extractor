package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.sound;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound.SoundOptData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound.SoundOptDataTable;

import java.nio.file.Path;

public class SoundOptDataTableDeserializer extends ClientResourceFileDeserializer<SoundOptDataTable> {
    private static SoundOptData readSoundOptData(BufferReader bufferReader) {
        return new SoundOptData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFixedLengthArray(6, BufferReader::readSignedInteger)
        );
    }

    @Override
    protected SoundOptDataTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new SoundOptDataTable(bufferReader.readArray(SoundOptDataTableDeserializer::readSoundOptData));
    }
}
