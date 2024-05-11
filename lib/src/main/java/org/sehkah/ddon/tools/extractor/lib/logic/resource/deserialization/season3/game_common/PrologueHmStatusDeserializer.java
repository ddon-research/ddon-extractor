package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.PrologueHmStatus;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.PrologueHmStatusList;

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
