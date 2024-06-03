package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

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
public class StageConnectConnect {
    private short Start;
    private short Goal;
    private String floor;
    private long unk1;
    private long unk2;
    private long unk3;
    private long unk4;
    private short unk5;
    private long questOrMarkerId;
    private boolean unk6;
    private List<Short> Index;
    private long unk7;
    private List<Short> Index2;
    private long unk8;
    private long questOrMarkerId2;
    private long questOrMarkerId3;
    private boolean unk9;
    private long IndexNum;
}
