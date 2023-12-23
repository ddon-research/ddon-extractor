package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.pawn;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.pawn.AIPawnActNoSwitch;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.pawn.AIPawnActNoSwitchTbl;

public class AIPawnActNoSwitchTblDeserializer extends ClientResourceFileDeserializer {
    public AIPawnActNoSwitchTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AIPawnActNoSwitch readAIPawnActNoSwitch(FileReader fileReader) {
        return new AIPawnActNoSwitch(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readArray(FileReader::readUnsignedInteger)
        );
    }

    @Override
    protected AIPawnActNoSwitchTbl parseClientResourceFile(FileReader fileReader) {
        return new AIPawnActNoSwitchTbl(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(AIPawnActNoSwitchTblDeserializer::readAIPawnActNoSwitch));
    }
}
