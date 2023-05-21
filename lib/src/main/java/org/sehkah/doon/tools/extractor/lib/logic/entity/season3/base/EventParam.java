package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.meta.EventParamEventFlag;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.meta.EventParamEventType;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.meta.EventParamLightCtrlType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;

public record EventParam(
        int Type,
        @MetaInformation
        EventParamEventType TypeName,
        int Stage,
        int EvNo,
        int Flag,
        @MetaInformation
        EventParamEventFlag FlagName,
        String FileName,
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
                flag, EventParamEventFlag.of(flag),
                fileName,
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
