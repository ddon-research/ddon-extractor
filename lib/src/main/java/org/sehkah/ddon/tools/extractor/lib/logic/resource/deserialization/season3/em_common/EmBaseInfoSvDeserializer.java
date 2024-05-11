package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common.EmBaseInfoSv;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common.EmBaseInfoSvList;

import java.util.ArrayList;
import java.util.List;

public class EmBaseInfoSvDeserializer extends ClientResourceFileDeserializer {
    public EmBaseInfoSvDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmBaseInfoSv readEmBaseInfoSv(FileReader fileReader, int num) {
        return new EmBaseInfoSv(
                num,
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected EmBaseInfoSvList parseClientResourceFile(FileReader fileReader) {
        long length = fileReader.readUnsignedInteger();
        List<EmBaseInfoSv> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readEmBaseInfoSv(fileReader, i));
        }
        return new EmBaseInfoSvList(entities);
    }
}
