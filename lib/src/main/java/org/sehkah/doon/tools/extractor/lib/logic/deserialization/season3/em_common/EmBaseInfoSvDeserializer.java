package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.em_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.em_common.EmBaseInfoSv;

import java.util.ArrayList;
import java.util.List;

public class EmBaseInfoSvDeserializer extends ClientResourceFileDeserializer<List<EmBaseInfoSv>> {
    public EmBaseInfoSvDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<EmBaseInfoSv> parseClientResourceFile(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
