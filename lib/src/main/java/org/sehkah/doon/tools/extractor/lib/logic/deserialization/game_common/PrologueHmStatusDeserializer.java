package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.PrologueHmStatus;

import java.util.List;

public class PrologueHmStatusDeserializer extends FileDeserializer<List<PrologueHmStatus>> {
    public PrologueHmStatusDeserializer() {
        super(ClientResourceFile.rPrologueHmStatus);
    }

    private static PrologueHmStatus readEntity(FileReader fileReader) {
        return new PrologueHmStatus(
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected List<PrologueHmStatus> readObject(FileReader fileReader) {
        return fileReader.readArray(PrologueHmStatusDeserializer::readEntity);
    }
}
