package org.sehkah.doon.tools.extractor.lib.logic.deserialization.em_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.em_common.EmBaseInfoSv;

import java.util.ArrayList;
import java.util.List;

public class EmBaseInfoSvDeserializer extends FileDeserializer<List<EmBaseInfoSv>> {
    public EmBaseInfoSvDeserializer() {
        super(ClientResourceFile.rEmBaseInfoSv);
    }

    private static List<EmBaseInfoSv> readEntity(FileReader fileReader) {
        long length = fileReader.readUnsignedInteger();
        List<EmBaseInfoSv> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(new EmBaseInfoSv(
                    i,
                    fileReader.readUnsignedInteger(),
                    fileReader.readUnsignedInteger()
            ));
        }
        return entities;
    }

    @Override
    protected List<EmBaseInfoSv> readObject(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
