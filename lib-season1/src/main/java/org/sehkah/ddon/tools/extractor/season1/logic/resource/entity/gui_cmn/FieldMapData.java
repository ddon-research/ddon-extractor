package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Float2f;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.meta.FieldMapDataType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FieldMapData {
    private long Type;
    @MetaInformation
    private FieldMapDataType TypeName;
    private int MessId;
    private long ID;
    private int StageNo;
    private Float2f Point;
    private Vector3f WorldPos;
    private boolean DispWideMap;
    private long QuestId;

    public FieldMapData(long type, int messId, long ID, int stageNo, Float2f point, Vector3f worldPos, boolean dispWideMap, long questId) {
        this(
                type, FieldMapDataType.of(type),
                messId,
                ID,
                stageNo,
                point,
                worldPos,
                dispWideMap,
                questId);
    }
}
