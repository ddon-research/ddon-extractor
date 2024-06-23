package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.MyRoom;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.MyRoom.meta.RoomWearType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom.RoomWearParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom.RoomWearParamTbl;

import java.nio.file.Path;

public class RoomWearParamTblDeserializer extends ClientResourceFileDeserializer<RoomWearParamTbl> {
    private static RoomWearParam readRoomWearParam(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ItemId = bufferReader.readUnsignedInteger();
        Translation ItemName = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getItemName(ItemId);
        }
        long Type = bufferReader.readUnsignedInteger();
        RoomWearType TypeName = RoomWearType.of(Type);
        int AH_M = bufferReader.readUnsignedShort();
        int AB_M = bufferReader.readUnsignedShort();
        int WB_M = bufferReader.readUnsignedShort();
        int AA_M = bufferReader.readUnsignedShort();
        int AL_M = bufferReader.readUnsignedShort();
        int WL_M = bufferReader.readUnsignedShort();
        int AC_M = bufferReader.readUnsignedShort();
        int AH_W = bufferReader.readUnsignedShort();
        int AB_W = bufferReader.readUnsignedShort();
        int WB_W = bufferReader.readUnsignedShort();
        int AA_W = bufferReader.readUnsignedShort();
        int AL_W = bufferReader.readUnsignedShort();
        int WL_W = bufferReader.readUnsignedShort();
        int AC_W = bufferReader.readUnsignedShort();

        return new RoomWearParam(ItemId, ItemName, Type, TypeName, AH_M, AB_M, WB_M, AA_M, AL_M, WL_M, AC_M, AH_W, AB_W, WB_W, AA_W, AL_W, WL_W, AC_W);
    }

    @Override
    protected RoomWearParamTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new RoomWearParamTbl(bufferReader.readArray(RoomWearParamTblDeserializer::readRoomWearParam, lookupUtil));
    }
}
