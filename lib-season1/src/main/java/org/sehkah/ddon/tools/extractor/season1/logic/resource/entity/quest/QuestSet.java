package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.SetInfoCoordOmIdType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.SetInfo;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSet {
    private long OmID;
    @MetaInformation
    private SetInfoCoordOmIdType OmIDType;
    private long UnitNo;
    private String Comment;
    private long Kind;
    private SetInfo setInfo;

    public QuestSet(long omID, long unitNo, String comment, long kind, SetInfo setInfo) {
        this(omID, SetInfoCoordOmIdType.of((int) omID),
                unitNo, comment, kind, setInfo);
    }
}
