package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SchedulerHeader {
    private int TrackNum;
    private long Crc;
    private int FrameMax;
    private boolean FloorFrame;
    private long BaseTrack;
    private long MetaDataOffset;
}
