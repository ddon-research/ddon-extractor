package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EmSound {
    private long Idx;
    private long SoundResNo;
    private long SoundNo;
    private boolean AttachFlag;
    private long RequestType;
    private int BoneNo;
    private Vector3f OffsetPos;
    private boolean DieIsNoCall;
}
