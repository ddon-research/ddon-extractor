package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.gui_cmn;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Float2f;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.gui_cmn.meta.FieldMapDataType;

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
    // TODO: Lookup
    private int MessId;
    private long ID;
    private int StageNo;
    @MetaInformation
    private Translation StageName;
    private Float2f Point;
    private Vector3f WorldPos;
    private boolean DispWideMap;
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
}
