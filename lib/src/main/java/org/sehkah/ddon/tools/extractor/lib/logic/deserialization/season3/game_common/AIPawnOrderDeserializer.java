package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.AIPawnOrder;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.AIPawnOrderParam;

public class AIPawnOrderDeserializer extends ClientResourceFileDeserializer {
    public AIPawnOrderDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AIPawnOrderParam readAIPawnOrderParam(FileReader fileReader) {
        return new AIPawnOrderParam(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readArray(FileReader::readUnsignedInteger),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected AIPawnOrder parseClientResourceFile(FileReader fileReader) {
        return new AIPawnOrder(fileReader.readArray(AIPawnOrderDeserializer::readAIPawnOrderParam));
    }
}
