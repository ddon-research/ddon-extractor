package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class PackageQuestInfo {
    private long PackageId;
    private long ContentInfoIdx;
    private PackageQuestClientInfo ClientInfo;
    private long HistoryMessageIdx;
}
