package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.EventParamEventFlag;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.EventParamEventType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.EventParamLightCtrlType;

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
    private int EvNo;
    private int Flag;
    @MetaInformation
    private Set<EventParamEventFlag> FlagTypes;
    private String FileName;
    @MetaInformation
    private String EventName;
    private long QuestId;
    private long LightCtrl;
    @MetaInformation
    private EventParamLightCtrlType LightCtrlName;
    private int StartFadeType;
    private int EndFadeType;
    private short SubMixerBefore;
    private short SubMixerAfter;
    private float OmAQCScale;
    private List<OmList> OmList;

    public EventParam(int type, int stage, int evNo, int flag, String fileName, long questId, long lightCtrl, int startFadeType, int endFadeType, short subMixerBefore, short subMixerAfter, float omAQCScale, List<OmList> omList) {
        this(
                type, EventParamEventType.of(type),
                stage,
                evNo,
                flag, BitUtil.extractBitSetUnsignedIntegerFlag(EventParamEventFlag::of, i -> 1 << i, flag),
                fileName, null,// FIXME: only works for season 3, season 2 lacks event room DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.EVENT_NAME, "EVENT_NAME_" + fileName.substring(fileName.lastIndexOf("\\") + 1)),
                questId,
                lightCtrl, EventParamLightCtrlType.of(lightCtrl),
                startFadeType,
                endFadeType,
                subMixerBefore,
                subMixerAfter,
                omAQCScale,
                omList);
    }
}
