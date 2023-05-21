package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.PrologueHmStatus;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.PrologueHmStatusList;

public class PrologueHmStatusDeserializer extends ClientResourceFileDeserializer {
    public PrologueHmStatusDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PrologueHmStatus readPrologueHmStatus(FileReader fileReader) {
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
    protected PrologueHmStatusList parseClientResourceFile(FileReader fileReader) {
        return new PrologueHmStatusList(fileReader.readArray(PrologueHmStatusDeserializer::readPrologueHmStatus));
    }
}
