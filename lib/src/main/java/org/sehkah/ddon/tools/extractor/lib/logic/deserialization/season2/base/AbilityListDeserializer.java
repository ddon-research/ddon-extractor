package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base.AbilityData;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base.AbilityList;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base.AbilityParam;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base.AbilityParamData;

import java.util.ArrayList;
import java.util.List;

public class AbilityListDeserializer extends ClientResourceFileDeserializer {

    public AbilityListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
        return new AbilityData(
                num,
                ParamArray
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
