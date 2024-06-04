package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.PlPartsInfoHeader;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.PlPartsInfoList;

import java.util.ArrayList;
import java.util.List;

public class PlPartsInfoDeserializer extends ClientResourceFileDeserializer {
    public PlPartsInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PlPartsInfoList readEntity(BufferReader bufferReader) {
        PlPartsInfoHeader header = new PlPartsInfoHeader(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );

        long length = header.getPartsNum();
        List<List<Short>> parts = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            parts.add(new ArrayList<>());
        }
        for (int i = 0; i < length; ) {
            short part = bufferReader.readSignedShort();
            if (part == -1) {
                i++;
            } else {
                parts.get(i).add(part);
            }
        }

        return new PlPartsInfoList(
                header,
                parts
        );
    }

    @Override
    protected PlPartsInfoList parseClientResourceFile(BufferReader bufferReader) {
        return readEntity(bufferReader);
    }
}
