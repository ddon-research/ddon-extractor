package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.ui.uGUIKeyConfig;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUIKeyConfig.KeyConfigTextTable;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUIKeyConfig.KeyText;

public class KeyConfigTextTableDeserializer extends ClientResourceFileDeserializer {
    public KeyConfigTextTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static KeyText readKeyText(BufferReader bufferReader) {
        return new KeyText(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected KeyConfigTextTable parseClientResourceFile(BufferReader bufferReader) {
        return new KeyConfigTextTable(bufferReader.readArray(KeyConfigTextTableDeserializer::readKeyText));
    }
}
