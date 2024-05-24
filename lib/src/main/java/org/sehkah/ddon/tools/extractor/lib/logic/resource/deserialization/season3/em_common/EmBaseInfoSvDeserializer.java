package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
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

    private static EmBaseInfoSv readEmBaseInfoSv(BufferReader bufferReader, int num) {
        return new EmBaseInfoSv(
                num,
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected EmBaseInfoSvList parseClientResourceFile(BufferReader bufferReader) {
        long length = bufferReader.readUnsignedInteger();
        List<EmBaseInfoSv> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readEmBaseInfoSv(bufferReader, i));
        }
        return new EmBaseInfoSvList(entities);
    }
}
