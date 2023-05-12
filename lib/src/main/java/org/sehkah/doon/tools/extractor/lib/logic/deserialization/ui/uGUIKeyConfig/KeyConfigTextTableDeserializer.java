package org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIKeyConfig;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIKeyConfig.KeyText;

import java.util.List;

public class KeyConfigTextTableDeserializer extends FileDeserializer<List<KeyText>> {
    public KeyConfigTextTableDeserializer() {
        super(ClientResourceFile.rKeyConfigTextTable);
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
    protected List<KeyText> readObject(FileReader fileReader) {
        return fileReader.readArray(KeyConfigTextTableDeserializer::readEntity);
    }
}
