package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.PartsCtrlData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.PartsCtrlTable;

public class PartsCtrlTableDeserializer extends ClientResourceFileDeserializer {
    public PartsCtrlTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PartsCtrlData readPartsCtrlData(FileReader fileReader) {
        return new PartsCtrlData(
                fileReader.readSignedInteger(),
                fileReader.readFixedLengthArray(16, FileReader::readUnsignedInteger)
        );
    }

    @Override
    protected PartsCtrlTable parseClientResourceFile(FileReader fileReader) {
        return new PartsCtrlTable(fileReader.readArray(PartsCtrlTableDeserializer::readPartsCtrlData));
    }
}
