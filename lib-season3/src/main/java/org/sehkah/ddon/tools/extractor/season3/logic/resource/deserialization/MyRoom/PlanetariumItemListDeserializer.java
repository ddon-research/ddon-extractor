package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.MyRoom;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.PlanetariumItem;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.PlanetariumItemList;

import java.nio.file.Path;

public class PlanetariumItemListDeserializer extends ClientResourceFileDeserializer<PlanetariumItemList> {
    private static PlanetariumItem readPlanetariumItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ItemId = bufferReader.readUnsignedInteger();
        long NpcNo = bufferReader.readUnsignedInteger();
        long Category = bufferReader.readUnsignedInteger();
        long MotNo = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation NpcName = null;

        if (lookupUtil != null) {
            ItemName = lookupUtil.getItemName(ItemId);
            NpcName = lookupUtil.getNpcName(NpcNo);
        }

        return new PlanetariumItem(ItemId, ItemName, NpcNo, NpcName, Category, MotNo);
    }

    @Override
    protected PlanetariumItemList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new PlanetariumItemList(bufferReader.readArray(PlanetariumItemListDeserializer::readPlanetariumItem, lookupUtil));

    }
}
