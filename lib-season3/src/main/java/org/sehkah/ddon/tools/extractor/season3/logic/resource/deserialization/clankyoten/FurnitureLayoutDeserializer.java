package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureLayout;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureLayoutList;

import java.nio.file.Path;

public class FurnitureLayoutDeserializer extends ClientResourceFileDeserializer<FurnitureLayoutList> {
    private static FurnitureLayout readFurnitureLayout(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ID = bufferReader.readUnsignedInteger();
        boolean IsRemovable = bufferReader.readBoolean();
        long GroupId = bufferReader.readUnsignedInteger();
        long GmdIdx = bufferReader.readUnsignedInteger();
        Translation LayoutName = null;
        if (lookupUtil != null) {
            LayoutName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.FURNITURE_LAYOUT_NAME.getFilePath(), (int) GmdIdx);
            if (LayoutName == null) {
                LayoutName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.CLAN_FURNITURE_LAYOUT_NAME.getFilePath(), (int) GmdIdx);
            }
        }
        int SortNo = bufferReader.readUnsignedByte();

        return new FurnitureLayout(ID, IsRemovable, GroupId, GmdIdx, LayoutName, SortNo);
    }

    @Override
    protected FurnitureLayoutList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FurnitureLayoutList(bufferReader.readArray(FurnitureLayoutDeserializer::readFurnitureLayout, lookupUtil));
    }
}
