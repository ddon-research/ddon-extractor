package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.MyRoom;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.JukeBoxItem;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.JukeBoxItemList;

import java.nio.file.Path;

public class JukeBoxItemListDeserializer extends ClientResourceFileDeserializer<JukeBoxItemList> {
    private static JukeBoxItem readJukeBoxItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ItemId = bufferReader.readUnsignedInteger();
        long BgmNo = bufferReader.readUnsignedInteger();

        Translation ItemName = null;

        if (lookupUtil != null) {
            ItemName = lookupUtil.getItemName(ItemId);
        }

        return new JukeBoxItem(ItemId, ItemName, BgmNo);
    }

    @Override
    protected JukeBoxItemList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new JukeBoxItemList(bufferReader.readArray(JukeBoxItemListDeserializer::readJukeBoxItem, lookupUtil));

    }
}
