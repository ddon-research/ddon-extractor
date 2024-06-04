package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.character_edit;

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
public class EditStageParamList {
    private List<Byte> ListTbl; //8;
}
