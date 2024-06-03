package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.PartnerPawnTalk;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.PartnerPawnTalkInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.PartnerPawnTalkInfoData;

public class PartnerPawnTalkDeserializer extends ClientResourceFileDeserializer {

    public PartnerPawnTalkDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PartnerPawnTalkInfoData readPartnerPawnTalkInfoData(BufferReader bufferReader) {
        return new PartnerPawnTalkInfoData(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort()
        );
    }

    private static PartnerPawnTalkInfo readPartnerPawnTalkInfo(BufferReader bufferReader) {
        return new PartnerPawnTalkInfo(bufferReader.readArray(PartnerPawnTalkDeserializer::readPartnerPawnTalkInfoData));
    }

    @Override
    protected PartnerPawnTalk parseClientResourceFile(BufferReader bufferReader) {
        final long PartnerPawnTalkNum = bufferReader.readUnsignedInteger();
        final long BufferSize = bufferReader.readUnsignedInteger();
        return new PartnerPawnTalk(
                PartnerPawnTalkNum,
                BufferSize,
                bufferReader.readFixedLengthArray(PartnerPawnTalkNum, PartnerPawnTalkDeserializer::readPartnerPawnTalkInfo)
        );

    }
}
