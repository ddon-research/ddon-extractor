package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIKeyConfig;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIKeyConfig.KeyConfigTextTable;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIKeyConfig.KeyText;

public class KeyConfigTextTableDeserializer extends ClientResourceFileDeserializer {


    private static KeyText readKeyText(BufferReader bufferReader) {
        return new KeyText(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected KeyConfigTextTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new KeyConfigTextTable(bufferReader.readArray(KeyConfigTextTableDeserializer::readKeyText));
    }
}
