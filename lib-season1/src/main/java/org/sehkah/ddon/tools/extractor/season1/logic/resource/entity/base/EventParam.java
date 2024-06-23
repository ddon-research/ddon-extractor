package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.EventParamEventFlag;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.EventParamEventType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.EventParamLightCtrlType;

import java.util.List;
import java.util.Set;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EventParam {
    private int Type;
    @MetaInformation
    private EventParamEventType TypeName;
    private int Stage;
    @MetaInformation
    private Translation StageName;
    // TODO: Lookup
    private int EvNo;
    private int Flag;
    @MetaInformation
    private Set<EventParamEventFlag> FlagTypes;
    private String FileName;
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
    private long LightCtrl;
    @MetaInformation
    private EventParamLightCtrlType LightCtrlName;
    private int StartFadeType;
    private int EndFadeType;
    private short SubMixerBefore;
    private short SubMixerAfter;
    private float OmAQCScale;
    private List<OmList> OmList;
}
