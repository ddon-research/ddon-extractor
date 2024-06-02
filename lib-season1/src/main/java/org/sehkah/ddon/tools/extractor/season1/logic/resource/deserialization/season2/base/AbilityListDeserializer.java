package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season2.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.base.AbilityData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.base.AbilityList;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.base.AbilityParam;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.base.AbilityParamData;

import java.util.ArrayList;
import java.util.List;

public class AbilityListDeserializer extends ClientResourceFileDeserializer {

    public AbilityListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AbilityParamData readAbilityParamData(BufferReader bufferReader) {
        return new AbilityParamData(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger()
        );
    }

    private static AbilityParam readAbilityParam(BufferReader bufferReader) {
        return new AbilityParam(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readArray(AbilityListDeserializer::readAbilityParamData)
        );
    }

    private static AbilityData readAbilityData(BufferReader bufferReader, int num) {
        List<AbilityParam> ParamArray = bufferReader.readArray(AbilityListDeserializer::readAbilityParam);
        return new AbilityData(
                num,
                ParamArray
        );
    }

    @Override
    protected AbilityList parseClientResourceFile(BufferReader bufferReader) {
        long BufferSize = bufferReader.readUnsignedInteger();
        long DataListNum = bufferReader.readUnsignedInteger();
        List<AbilityData> DataList = new ArrayList<>((int) DataListNum);
        for (int i = 0; i < DataListNum; i++) {
            DataList.add(readAbilityData(bufferReader, i));
        }
        return new AbilityList(
                BufferSize,
                DataListNum,
                DataList
        );
    }
}
