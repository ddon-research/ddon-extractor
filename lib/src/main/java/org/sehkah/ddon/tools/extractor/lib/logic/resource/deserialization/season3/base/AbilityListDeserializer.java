package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.*;

import java.util.ArrayList;
import java.util.List;

public class AbilityListDeserializer extends ClientResourceFileDeserializer {

    public AbilityListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AdditionalAbilityParamData readAdditionalAbilityParamData(FileReader fileReader) {
        return new AdditionalAbilityParamData(
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    private static AbilityParamData readAbilityParamData(FileReader fileReader) {
        return new AbilityParamData(
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    private static AbilityParam readAbilityParam(FileReader fileReader) {
        return new AbilityParam(
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readArray(AbilityListDeserializer::readAbilityParamData)
        );
    }

    private static AbilityData readAbilityData(FileReader fileReader, int num) {
        List<AbilityParam> ParamArray = fileReader.readArray(AbilityListDeserializer::readAbilityParam);
        boolean HasExSkill = fileReader.readBoolean();
        AdditionalAbilityParamData additionalAbilityParamData = null;
        if (HasExSkill) {
            additionalAbilityParamData = readAdditionalAbilityParamData(fileReader);
        }
        return new AbilityData(
                num,
                ParamArray,
                HasExSkill,
                additionalAbilityParamData
        );
    }

    @Override
    protected AbilityList parseClientResourceFile(FileReader fileReader) {
        long BufferSize = fileReader.readUnsignedInteger();
        long DataListNum = fileReader.readUnsignedInteger();
        List<AbilityData> DataList = new ArrayList<>((int) DataListNum);
        for (int i = 0; i < DataListNum; i++) {
            DataList.add(readAbilityData(fileReader, i));
        }
        return new AbilityList(
                BufferSize,
                DataListNum,
                DataList
        );
    }
}
