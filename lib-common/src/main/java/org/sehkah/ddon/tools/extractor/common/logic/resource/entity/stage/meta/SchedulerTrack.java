package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.binary.meta.PropertyType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.SchedulerKey;

import java.math.BigInteger;
import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SchedulerTrack {
    private int TrackType;
    @MetaInformation
    private SchedulerTrackType TrackTypeName;
    private int PropType;
    @MetaInformation
    private PropertyType PropTypeName;
    private int KeyNum;
    private long ParentIndex;
    private String TrackName;
    private long DTIID;
    @MetaInformation
    private String ResourceName;
    private BigInteger UnitGroup;
    private List<SchedulerKey> KeyFrame;
    private List<Object> KeyValue;
}
