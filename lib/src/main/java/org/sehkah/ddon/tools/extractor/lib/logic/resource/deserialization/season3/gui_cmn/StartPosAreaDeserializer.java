package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn.StartPosArea;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn.StartPosAreaList;

public class StartPosAreaDeserializer extends ClientResourceFileDeserializer {
    public StartPosAreaDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StartPosArea readStartPosArea(FileReader fileReader) {
        return new StartPosArea(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort()
        );
    }

    @Override
    protected StartPosAreaList parseClientResourceFile(FileReader fileReader) {
        return new StartPosAreaList(fileReader.readArray(StartPosAreaDeserializer::readStartPosArea));
    }
}
