package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.AIPawnEmNode;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.AIPawnEmParam;

// Works for both v15 (season 2) & v17 (season 3)
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
