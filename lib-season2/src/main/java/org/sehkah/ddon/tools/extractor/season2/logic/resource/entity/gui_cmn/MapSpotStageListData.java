package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class MapSpotStageListData {
    private int StageNo;
}