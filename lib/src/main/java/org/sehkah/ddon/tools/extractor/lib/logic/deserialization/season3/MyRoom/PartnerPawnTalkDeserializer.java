package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.MyRoom.PartnerPawnTalk;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.MyRoom.PartnerPawnTalkInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.MyRoom.PartnerPawnTalkInfoData;

public class PartnerPawnTalkDeserializer extends ClientResourceFileDeserializer {

    public PartnerPawnTalkDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PartnerPawnTalkInfoData readPartnerPawnTalkInfoData(FileReader fileReader) {
        return new PartnerPawnTalkInfoData(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort()
        );
    }

    private static PartnerPawnTalkInfo readPartnerPawnTalkInfo(FileReader fileReader) {
        return new PartnerPawnTalkInfo(fileReader.readArray(PartnerPawnTalkDeserializer::readPartnerPawnTalkInfoData));
    }

    @Override
    protected PartnerPawnTalk parseClientResourceFile(FileReader fileReader) {
        final long PartnerPawnTalkNum = fileReader.readUnsignedInteger();
        final long BufferSize = fileReader.readUnsignedInteger();
        return new PartnerPawnTalk(
                PartnerPawnTalkNum,
                BufferSize,
                fileReader.readFixedLengthArray(PartnerPawnTalkNum, PartnerPawnTalkDeserializer::readPartnerPawnTalkInfo)
        );

    }
}
