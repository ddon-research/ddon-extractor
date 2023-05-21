package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.AIPawnAutoWordNode;

import java.util.List;

public class AIPawnAutoWordTblDeserializer extends ClientResourceFileDeserializer<List<AIPawnAutoWordNode>> {
    public AIPawnAutoWordTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AIPawnAutoWordNode readEntity(FileReader fileReader) {
        return new AIPawnAutoWordNode(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(9),
                fileReader.readUnsignedInteger(9)
        );
    }

    @Override
    protected List<AIPawnAutoWordNode> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(AIPawnAutoWordTblDeserializer::readEntity);
    }
}
