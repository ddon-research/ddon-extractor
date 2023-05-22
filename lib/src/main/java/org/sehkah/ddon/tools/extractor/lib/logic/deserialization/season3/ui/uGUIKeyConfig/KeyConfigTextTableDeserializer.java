package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIKeyConfig;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.ui.uGUIKeyConfig.KeyConfigTextTable;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.ui.uGUIKeyConfig.KeyText;

public class KeyConfigTextTableDeserializer extends ClientResourceFileDeserializer {
    public KeyConfigTextTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static KeyText readKeyText(FileReader fileReader) {
        return new KeyText(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected KeyConfigTextTable parseClientResourceFile(FileReader fileReader) {
        return new KeyConfigTextTable(fileReader.readArray(KeyConfigTextTableDeserializer::readKeyText));
    }
}
