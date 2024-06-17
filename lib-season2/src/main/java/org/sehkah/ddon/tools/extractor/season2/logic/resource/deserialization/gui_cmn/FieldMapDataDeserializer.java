package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.datatype.Float2f;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.FieldMapData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.FieldMapDataList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.meta.FieldMapDataType;

import java.nio.file.Path;

public class FieldMapDataDeserializer extends ClientResourceFileDeserializer<FieldMapDataList> {
    private static FieldMapData readFieldMapData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long Type = bufferReader.readUnsignedInteger();
        FieldMapDataType TypeName = FieldMapDataType.of(Type);
        int MessId = bufferReader.readSignedInteger();
        long ID = bufferReader.readUnsignedInteger();
        int StageNo = bufferReader.readSignedInteger();
        Float2f Point = bufferReader.readFloat2f();
        Vector3f WorldPos = bufferReader.readVector3f();
        boolean DispWideMap = bufferReader.readBoolean();
        long QuestId = bufferReader.readUnsignedInteger();

        Translation StageName = null;
        Translation QuestName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo(StageNo);
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new FieldMapData(Type, TypeName, MessId, ID, StageNo, StageName, Point, WorldPos, DispWideMap, QuestId, QuestName);
    }

    @Override
    protected FieldMapDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FieldMapDataList(bufferReader.readArray(FieldMapDataDeserializer::readFieldMapData, lookupUtil));
    }
}
