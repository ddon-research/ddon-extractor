package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.EmScale;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.EmScaleTable;

public class EmScaleTableDeserializer extends ClientResourceFileDeserializer {
    public EmScaleTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmScale readEmScaleData(FileReader fileReader) {
        return new EmScale(
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readVector3f()
        );
    }

    @Override
    protected EmScaleTable parseClientResourceFile(FileReader fileReader) {
        return new EmScaleTable(fileReader.readArray(EmScaleTableDeserializer::readEmScaleData));
    }
}
