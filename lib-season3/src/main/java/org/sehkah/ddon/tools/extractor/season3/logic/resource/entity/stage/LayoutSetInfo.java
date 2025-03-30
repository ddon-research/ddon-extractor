package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.LayoutSetInfoType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class LayoutSetInfo {
    private int ID;
    private long Type;
    @MetaInformation
    private LayoutSetInfoType TypeName;
    private SetInfo Info;

    public LayoutSetInfo(int ID, long type, SetInfo info) {
        this.ID = ID;
        Type = type;
        TypeName = LayoutSetInfoType.of(type);
        Info = info;
    }
}
