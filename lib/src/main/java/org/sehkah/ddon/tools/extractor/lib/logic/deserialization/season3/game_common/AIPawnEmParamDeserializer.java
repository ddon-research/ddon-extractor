package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.AIPawnEmNode;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.AIPawnEmParam;

public class AIPawnEmParamDeserializer extends ClientResourceFileDeserializer {
    public AIPawnEmParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AIPawnEmNode readAIPawnEmNode(FileReader fileReader) {
        return new AIPawnEmNode(
                fileReader.readSignedInteger(),
                fileReader.readArray(FileReader::readUnsignedInteger),
                fileReader.readArray(FileReader::readUnsignedInteger),
                fileReader.readArray(FileReader::readUnsignedInteger),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readArray(FileReader::readUnsignedInteger),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    @Override
    protected AIPawnEmParam parseClientResourceFile(FileReader fileReader) {
        return new AIPawnEmParam(
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readArray(AIPawnEmParamDeserializer::readAIPawnEmNode));
    }
}
