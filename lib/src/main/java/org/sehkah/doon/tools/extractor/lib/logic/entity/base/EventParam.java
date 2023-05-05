package org.sehkah.doon.tools.extractor.lib.logic.entity.base;

import org.sehkah.doon.tools.extractor.lib.common.error.TechnicalException;

import java.util.List;

public record EventParam(
        int Type,
        int Stage,
        int EvNo,
        int Flag,
        String FileName,
        long QuestId,
        long LightCtrl,
        int StartFadeType,
        int EndFadeType,
        short SubMixerBefore,
        short SubMixerAfter,
        float OmAQCScale,
        long Version,
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

    public static EventParam of(int type, int stage, int evNo, int flag, String fileName, long questId, long lightCtrl,
                                int startFadeType, int endFadeType, short subMixerBefore, short subMixerAfter, float omAQCScale, List<OmList> omList) {
        return new EventParam(type, stage, evNo, flag, fileName, questId, lightCtrl, startFadeType, endFadeType,
                subMixerBefore, subMixerAfter, omAQCScale, omList.size(), omList);
    }
}
