package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.MyRoom.PartnerReactParam;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.MyRoom.PartnerReactParamTbl;

import java.util.List;

public class PartnerReactParamTblDeserializer extends ClientResourceFileDeserializer {

    public PartnerReactParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PartnerReactParam readPartnerReactParam(FileReader fileReader) {
        return new PartnerReactParam(
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort()
        );
    }

    @Override
    protected PartnerReactParamTbl parseClientResourceFile(FileReader fileReader) {
        List<PartnerReactParam> partnerReactParams = fileReader.readArray(PartnerReactParamTblDeserializer::readPartnerReactParam);
        PartnerReactParamTbl partnerReactParamTbl = new PartnerReactParamTbl(partnerReactParams);
        return partnerReactParamTbl;
    }
}
