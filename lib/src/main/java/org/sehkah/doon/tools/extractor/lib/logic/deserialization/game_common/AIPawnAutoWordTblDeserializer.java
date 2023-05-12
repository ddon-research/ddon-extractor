package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.AIPawnAutoWordNode;

import java.util.List;

public class AIPawnAutoWordTblDeserializer extends FileDeserializer<List<AIPawnAutoWordNode>> {
    public AIPawnAutoWordTblDeserializer() {
        super(ClientResourceFile.rAIPawnAutoWordTbl);
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
    protected List<AIPawnAutoWordNode> readObject(FileReader fileReader) {
        return fileReader.readArray(AIPawnAutoWordTblDeserializer::readEntity);
    }
}
