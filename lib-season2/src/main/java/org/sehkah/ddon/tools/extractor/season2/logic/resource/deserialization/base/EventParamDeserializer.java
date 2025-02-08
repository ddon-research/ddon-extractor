package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.EventParamEventFlag;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.EventParamEventType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.EventParamLightCtrlType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.EventParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.EventParamList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.OmList;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public class EventParamDeserializer extends ClientResourceFileDeserializer<EventParamList> {
    private static OmList readOmList(BufferReader bufferReader) {
        return new OmList(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort()
        );
    }

    private static EventParam readEventParam(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int Type = bufferReader.readUnsignedShort();
        EventParamEventType TypeName = EventParamEventType.of(Type);
        int Stage = bufferReader.readUnsignedShort();
        int EvNo = bufferReader.readUnsignedShort();
        int Flag = bufferReader.readUnsignedShort();
        Set<EventParamEventFlag> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(EventParamEventFlag::of, i -> 1 << i, Flag);
        String FileName = bufferReader.readNullTerminatedString();
        long QuestId = bufferReader.readUnsignedInteger();
        long LightCtrl = bufferReader.readUnsignedInteger();
        EventParamLightCtrlType LightCtrlName = EventParamLightCtrlType.of(LightCtrl);
        int StartFadeType = bufferReader.readUnsignedByte();
        int EndFadeType = bufferReader.readUnsignedByte();
        short SubMixerBefore = bufferReader.readSignedShort();
        short SubMixerAfter = bufferReader.readSignedShort();
        float OmAQCScale = bufferReader.readFloat();
        List<OmList> OmList = bufferReader.readArray(EventParamDeserializer::readOmList);

        Translation StageName = null;
        Translation QuestName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo(Stage);
            QuestName = lookupUtil.getQuestName(QuestId);
        }

        return new EventParam(Type, TypeName, Stage, StageName, EvNo, Flag, FlagTypes, FileName, QuestId, QuestName, LightCtrl, LightCtrlName, StartFadeType, EndFadeType, SubMixerBefore, SubMixerAfter, OmAQCScale, OmList);
    }

    @Override
    protected EventParamList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EventParamList(bufferReader.readArray(EventParamDeserializer::readEventParam, lookupUtil));
    }
}
