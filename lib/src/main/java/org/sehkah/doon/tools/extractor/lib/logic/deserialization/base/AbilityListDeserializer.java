package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.*;

import java.util.ArrayList;
import java.util.List;

public class AbilityListDeserializer extends FileDeserializer<AbilityList> {
    public AbilityListDeserializer() {
        super(ClientResourceFile.rAbilityList);
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

    private static AbilityList readEntity(FileReader fileReader) {
        int UnknownByte1 = fileReader.readUnsignedByte();
        int UnknownByte2 = fileReader.readUnsignedByte();
        int UnknownShort = fileReader.readUnsignedShort();
        long DataListNum = fileReader.readUnsignedInteger();
        List<AbilityData> DataList = new ArrayList<>((int) DataListNum);
        for (int i = 0; i < DataListNum; i++) {
            DataList.add(readAbilityData(fileReader, i));
        }
        return new AbilityList(
                UnknownByte1,
                UnknownByte2,
                UnknownShort,
                DataList
        );
    }

    @Override
    protected AbilityList readObject(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
