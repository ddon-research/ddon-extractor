package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.PlPartsInfoHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.PlPartsInfoList;

import java.util.ArrayList;
import java.util.List;

public class PlPartsInfoDeserializer extends ClientResourceFileDeserializer {
    public PlPartsInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PlPartsInfoList readEntity(FileReader fileReader) {
        PlPartsInfoHeader header = new PlPartsInfoHeader(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );

        long length = header.PartsNum();
        List<List<Short>> parts = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            parts.add(new ArrayList<>());
        }
        for (int i = 0; i < length; ) {
            short part = fileReader.readSignedShort();
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
    protected PlPartsInfoList parseClientResourceFile(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
