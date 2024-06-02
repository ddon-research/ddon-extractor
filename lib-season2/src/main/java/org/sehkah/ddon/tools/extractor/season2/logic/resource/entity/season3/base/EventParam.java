package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.base.meta.EventParamEventFlag;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.base.meta.EventParamEventType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.base.meta.EventParamLightCtrlType;

import java.util.List;
import java.util.Set;

public record EventParam(
        int Type,
        @MetaInformation
        EventParamEventType TypeName,
        int Stage,
        int EvNo,
        int Flag,
        @MetaInformation
        Set<EventParamEventFlag> FlagTypes,
        String FileName,
        @MetaInformation
        String EventName,
        long QuestId,
        long LightCtrl,
        @MetaInformation
        EventParamLightCtrlType LightCtrlName,
        int StartFadeType,
        int EndFadeType,
        short SubMixerBefore,
        short SubMixerAfter,
        float OmAQCScale,
        List<OmList> OmList
) {
    public EventParam {
        if (!FileName.startsWith("event")) {
            throw new TechnicalException("Event file name does not start with event!");
        }
        if (Float.isNaN(OmAQCScale)) {
            throw new TechnicalException("OmAQCScale can not be NaN!");
        }
    }

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
