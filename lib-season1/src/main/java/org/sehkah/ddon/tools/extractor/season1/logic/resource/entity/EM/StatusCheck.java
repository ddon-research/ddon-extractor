package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StatusCheck {
    private int Group;
    private int Result;
    private long Type;
    private List<Float> SystemParam;
    private boolean ResultAdd;
    private boolean ResultOver;
    private boolean TypeReverse;
}
