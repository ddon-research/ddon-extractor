package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.MyRoom;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom.PartnerPawnTalk;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom.PartnerPawnTalkInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom.PartnerPawnTalkInfoData;

import java.nio.file.Path;

public class PartnerPawnTalkDeserializer extends ClientResourceFileDeserializer<PartnerPawnTalk> {


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
    protected PartnerPawnTalk parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        final long PartnerPawnTalkNum = bufferReader.readUnsignedInteger();
        final long BufferSize = bufferReader.readUnsignedInteger();
        return new PartnerPawnTalk(
                PartnerPawnTalkNum,
                BufferSize,
                bufferReader.readFixedLengthArray(PartnerPawnTalkNum, PartnerPawnTalkDeserializer::readPartnerPawnTalkInfo)
        );

    }
}
