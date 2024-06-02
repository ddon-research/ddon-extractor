package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base.*;

import java.util.ArrayList;
import java.util.List;

public class AbilityListDeserializer extends ClientResourceFileDeserializer {

    public AbilityListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AdditionalAbilityParamData readAdditionalAbilityParamData(BufferReader bufferReader) {
        return new AdditionalAbilityParamData(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger()
        );
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
        boolean HasExSkill = bufferReader.readBoolean();
        AdditionalAbilityParamData additionalAbilityParamData = null;
        if (HasExSkill) {
            additionalAbilityParamData = readAdditionalAbilityParamData(bufferReader);
        }
        return new AbilityData(
                num,
                ParamArray,
                HasExSkill,
                additionalAbilityParamData
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
