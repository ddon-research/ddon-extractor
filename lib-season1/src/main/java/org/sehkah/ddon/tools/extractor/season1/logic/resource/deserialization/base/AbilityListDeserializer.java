package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.AbilityData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.AbilityList;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.AbilityParam;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.AbilityParamData;

import java.util.ArrayList;
import java.util.List;

public class AbilityListDeserializer extends ClientResourceFileDeserializer<AbilityList> {
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
    protected AbilityList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
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
