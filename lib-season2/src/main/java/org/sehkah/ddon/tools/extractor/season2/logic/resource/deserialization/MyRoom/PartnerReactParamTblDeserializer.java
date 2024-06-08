package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.MyRoom;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom.PartnerReactParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom.PartnerReactParamTbl;

import java.util.List;

public class PartnerReactParamTblDeserializer extends ClientResourceFileDeserializer<PartnerReactParamTbl> {


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
    protected PartnerReactParamTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        List<PartnerReactParam> partnerReactParams = bufferReader.readArray(PartnerReactParamTblDeserializer::readPartnerReactParam);
        PartnerReactParamTbl partnerReactParamTbl = new PartnerReactParamTbl(partnerReactParams);
        return partnerReactParamTbl;
    }
}
