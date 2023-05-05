package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import org.sehkah.doon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.EventParam;

import java.util.List;

public record EventParamWithMetaInformation(
        int Type,
        EventParamEventType TypeName,
        int Stage,
        int EvNo,
        int Flag,
        EventParamEventFlag FlagName,
        String FileName,
        long QuestId,
        long LightCtrl,
        EventParamLightCtrlType LightCtrlName,
        int StartFadeType,
        int EndFadeType,
        short SubMixerBefore,
        short SubMixerAfter,
        float OmAQCScale,
        long Version,
        List<OmListWithMetaInformation> OmList
) {
    public EventParamWithMetaInformation {
        if (!FileName.startsWith("event")) {
            throw new TechnicalException("Event file name does not start with event!");
        }
        if (Float.isNaN(OmAQCScale)) {
            throw new TechnicalException("OmAQCScale can not be NaN!");
        }
    }

    public static EventParamWithMetaInformation of(EventParam eventParam) {
        return new EventParamWithMetaInformation(
                eventParam.Type(), EventParamEventType.of(eventParam.Type()),
                eventParam.Stage(),
                eventParam.EvNo(),
                eventParam.Flag(), EventParamEventFlag.of(eventParam.Flag()),
                eventParam.FileName(),
                eventParam.QuestId(),
                eventParam.LightCtrl(), EventParamLightCtrlType.of(eventParam.LightCtrl()),
                eventParam.StartFadeType(),
                eventParam.EndFadeType(),
                eventParam.SubMixerBefore(),
                eventParam.SubMixerAfter(),
                eventParam.OmAQCScale(),
                eventParam.Version(),
                eventParam.OmList().stream().map(OmListWithMetaInformation::of).toList()
                );
    }
}
