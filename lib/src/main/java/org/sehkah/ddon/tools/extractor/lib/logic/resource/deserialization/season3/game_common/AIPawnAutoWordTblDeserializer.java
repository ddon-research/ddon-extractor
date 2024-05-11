package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.AIPawnAutoWordNode;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.AIPawnAutoWordTbl;

public class AIPawnAutoWordTblDeserializer extends ClientResourceFileDeserializer {
    public AIPawnAutoWordTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AIPawnAutoWordNode readAIPawnAutoWordNode(FileReader fileReader) {
        return new AIPawnAutoWordNode(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFixedLengthArray(9, FileReader::readUnsignedInteger),
                fileReader.readFixedLengthArray(9, FileReader::readUnsignedInteger)
        );
    }

    @Override
    protected AIPawnAutoWordTbl parseClientResourceFile(FileReader fileReader) {
        return new AIPawnAutoWordTbl(fileReader.readArray(AIPawnAutoWordTblDeserializer::readAIPawnAutoWordNode));
    }
}
