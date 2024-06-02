package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.pawn;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.pawn.AIPawnActNoSwitch;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.pawn.AIPawnActNoSwitchTbl;

public class AIPawnActNoSwitchTblDeserializer extends ClientResourceFileDeserializer {
    public AIPawnActNoSwitchTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AIPawnActNoSwitch readAIPawnActNoSwitch(BufferReader bufferReader) {
        return new AIPawnActNoSwitch(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(BufferReader::readUnsignedInteger)
        );
    }

    @Override
    protected AIPawnActNoSwitchTbl parseClientResourceFile(BufferReader bufferReader) {
        return new AIPawnActNoSwitchTbl(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(AIPawnActNoSwitchTblDeserializer::readAIPawnActNoSwitch));
    }
}
