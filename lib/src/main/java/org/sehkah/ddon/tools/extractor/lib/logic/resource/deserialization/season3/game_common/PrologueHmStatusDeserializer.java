package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.PrologueHmStatus;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.PrologueHmStatusList;

public class PrologueHmStatusDeserializer extends ClientResourceFileDeserializer {
    public PrologueHmStatusDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PrologueHmStatus readPrologueHmStatus(BufferReader bufferReader) {
        return new PrologueHmStatus(
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected PrologueHmStatusList parseClientResourceFile(BufferReader bufferReader) {
        return new PrologueHmStatusList(bufferReader.readArray(PrologueHmStatusDeserializer::readPrologueHmStatus));
    }
}
