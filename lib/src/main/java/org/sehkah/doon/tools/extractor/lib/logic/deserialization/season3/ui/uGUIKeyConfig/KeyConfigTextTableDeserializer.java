package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIKeyConfig;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUIKeyConfig.KeyText;

import java.util.List;

public class KeyConfigTextTableDeserializer extends ClientResourceFileDeserializer<List<KeyText>> {
    public KeyConfigTextTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static KeyText readEntity(FileReader fileReader) {
        return new KeyText(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<KeyText> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(KeyConfigTextTableDeserializer::readEntity);
    }
}
