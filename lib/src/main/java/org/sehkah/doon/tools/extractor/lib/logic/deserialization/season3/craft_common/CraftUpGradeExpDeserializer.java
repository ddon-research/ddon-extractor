package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common.CraftUpGradeExpData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common.CraftUpGradeExpList;

import java.util.ArrayList;
import java.util.List;

public class CraftUpGradeExpDeserializer extends ClientResourceFileDeserializer {
    public CraftUpGradeExpDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftUpGradeExpData readCraftUpGradeExpData(FileReader fileReader, int level) {
        return new CraftUpGradeExpData(
                level,
                fileReader.readUnsignedLong()
        );
    }

    @Override
    protected CraftUpGradeExpList parseClientResourceFile(FileReader fileReader) {
        long length = fileReader.readUnsignedInteger();
        List<CraftUpGradeExpData> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readCraftUpGradeExpData(fileReader, i));
        }
        return new CraftUpGradeExpList(entities);
    }
}
