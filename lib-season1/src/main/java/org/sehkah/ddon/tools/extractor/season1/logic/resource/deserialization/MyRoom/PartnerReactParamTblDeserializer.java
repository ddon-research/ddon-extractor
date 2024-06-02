package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.MyRoom.PartnerReactParam;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.MyRoom.PartnerReactParamTbl;

import java.util.List;

public class PartnerReactParamTblDeserializer extends ClientResourceFileDeserializer {

    public PartnerReactParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PartnerReactParam readPartnerReactParam(BufferReader bufferReader) {
        return new PartnerReactParam(
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort()
        );
    }

    @Override
    protected PartnerReactParamTbl parseClientResourceFile(BufferReader bufferReader) {
        List<PartnerReactParam> partnerReactParams = bufferReader.readArray(PartnerReactParamTblDeserializer::readPartnerReactParam);
        PartnerReactParamTbl partnerReactParamTbl = new PartnerReactParamTbl(partnerReactParams);
        return partnerReactParamTbl;
    }
}
