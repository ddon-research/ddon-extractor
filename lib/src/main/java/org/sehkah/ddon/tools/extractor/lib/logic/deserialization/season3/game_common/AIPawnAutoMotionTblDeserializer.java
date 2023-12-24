package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.AIPawnAutoMotionNode;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.AIPawnAutoMotionTbl;

public class AIPawnAutoMotionTblDeserializer extends ClientResourceFileDeserializer {
    public AIPawnAutoMotionTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AIPawnAutoMotionNode readAIPawnAutoMotionNode(FileReader fileReader) {
        return new AIPawnAutoMotionNode(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readArray(FileReader::readUnsignedInteger),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected AIPawnAutoMotionTbl parseClientResourceFile(FileReader fileReader) {
        return new AIPawnAutoMotionTbl(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(AIPawnAutoMotionTblDeserializer::readAIPawnAutoMotionNode));
    }
}
