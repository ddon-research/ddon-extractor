package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmRisingMagma extends SetInfo {
    private List<Float> F3Height;//6
    private List<Float> F3Sec;//5
    // TODO: Lookup
    private int Kind;
    private int Grp;
    private int ID;
    private SetInfoOmOld InfoOm;
}
