package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileHeader;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.PlPartsInfoHeader;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.PlPartsInfoList;

import java.util.ArrayList;
import java.util.List;

public class PlPartsInfoDeserializer extends FileDeserializer<PlPartsInfoList> {
    public PlPartsInfoDeserializer() {
        super(ClientResourceFile.rPlPartsInfo);
    }

    private static PlPartsInfoList readEntity(FileReader fileReader, long magic, long version) {
        PlPartsInfoHeader header = new PlPartsInfoHeader(
                magic,
                version,
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
    protected PlPartsInfoList readObject(FileReader fileReader) {
        return readEntity(fileReader, FileHeader.magicNumber(clientResourceFile.fileHeader.magicString), clientResourceFile.fileHeader.versionNumber);
    }
}
