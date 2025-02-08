package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.StageResourcePointer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.StageFlag;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageInfo;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public class StageInfoDeserializer extends ClientResourceFileDeserializer<StageInfo> {
    private static StageResourcePointer readStageResourcePointer(BufferReader bufferReader) {
        String Type = bufferReader.readNullTerminatedString();
        return Type.isEmpty() ? null : new StageResourcePointer(Type, bufferReader.readNullTerminatedString());
    }

    private static StageInfo readStageStageInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int StageNo = bufferReader.readSignedInteger();
        StageResourcePointer SchedulerModel = readStageResourcePointer(bufferReader);
        StageResourcePointer SchedulerFilter = readStageResourcePointer(bufferReader);
        StageResourcePointer CollisionScrSbc0 = readStageResourcePointer(bufferReader);
        StageResourcePointer CollisionEffSbc0 = readStageResourcePointer(bufferReader);
        StageResourcePointer CollisionScrSbc1 = readStageResourcePointer(bufferReader);
        StageResourcePointer CollisionEffSbc1 = readStageResourcePointer(bufferReader);
        StageResourcePointer CollisionScrSbc2 = readStageResourcePointer(bufferReader);
        StageResourcePointer CollisionEffSbc2 = readStageResourcePointer(bufferReader);
        StageResourcePointer NavigationMeshNaviMesh = readStageResourcePointer(bufferReader);
        StageResourcePointer AIPathConsecutiverWayPoint = readStageResourcePointer(bufferReader);
        StageResourcePointer OccluderExOCC = readStageResourcePointer(bufferReader);
        StageResourcePointer StartPosStartPos = readStageResourcePointer(bufferReader);
        StageResourcePointer CameraParamListFld = readStageResourcePointer(bufferReader);
        StageResourcePointer CameraParamListEvt = readStageResourcePointer(bufferReader);
        Vector3f Pos = bufferReader.readVector3f();
        float Ang = bufferReader.readFloat();
        long SceLoadFlag = bufferReader.readUnsignedInteger();
        long Flag = bufferReader.readUnsignedInteger();
        Set<StageFlag> StageFlagType = BitUtil.extractBitSetUnsignedIntegerFlag(StageFlag::of, i -> 1 << i, Flag);
        StageResourcePointer WeatherStageInfo = readStageResourcePointer(bufferReader);
        StageResourcePointer WeatherParamInfoTbl = readStageResourcePointer(bufferReader);
        StageResourcePointer WeatherParamEfcInfo = readStageResourcePointer(bufferReader);
        StageResourcePointer WeatherEffectParam = readStageResourcePointer(bufferReader);
        StageResourcePointer SchedulerStageLightSchdl = readStageResourcePointer(bufferReader);
        StageResourcePointer EffectProvider = readStageResourcePointer(bufferReader);
        int EpvIndexAlways = bufferReader.readSignedInteger();
        int EpvIndexDay = bufferReader.readSignedInteger();
        int EpvIndexNight = bufferReader.readSignedInteger();
        List<StageResourcePointer> ZoneList = bufferReader.readFixedLengthArray(4, StageInfoDeserializer::readStageResourcePointer);
        StageResourcePointer ZoneIndoorScr = readStageResourcePointer(bufferReader);
        StageResourcePointer ZoneIndoorEfc = readStageResourcePointer(bufferReader);
        float DayNightLightChgFrame = bufferReader.readFloat();
        float DayNightFogChgFrame = bufferReader.readFloat();
        int SkyInfiniteLightGroup = bufferReader.readSignedInteger();
        List<StageResourcePointer> ZoneUnitCtrl = bufferReader.readFixedLengthArray(3, StageInfoDeserializer::readStageResourcePointer);
        StageResourcePointer ZoneStatus = readStageResourcePointer(bufferReader);
        List<StageResourcePointer> SoundZone = bufferReader.readFixedLengthArray(3, StageInfoDeserializer::readStageResourcePointer);
        List<Float> EqLength = bufferReader.readFixedLengthArray(4, BufferReader::readFloat);
        StageResourcePointer SoundAreaInfo = readStageResourcePointer(bufferReader);
        StageResourcePointer SchedulerEffectSchdl = readStageResourcePointer(bufferReader);
        StageResourcePointer SchedulerLanternSchdl = readStageResourcePointer(bufferReader);
        boolean IsCraftStage = bufferReader.readBoolean();
        StageResourcePointer LocationData = readStageResourcePointer(bufferReader);
        float GrassVisiblePercentMulValue = bufferReader.readFloat();
        float GrassFadeBeginDistance = bufferReader.readFloat();
        float GrassFadeEndDistance = bufferReader.readFloat();
        int PerformanceFlag = bufferReader.readUnsignedShort();
        String AnotherMapName = bufferReader.readNullTerminatedString();

        Translation StageName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo(StageNo);
        }

        return new StageInfo(StageNo, StageName, SchedulerModel, SchedulerFilter, CollisionScrSbc0, CollisionEffSbc0,
                CollisionScrSbc1, CollisionEffSbc1, CollisionScrSbc2, CollisionEffSbc2, NavigationMeshNaviMesh,
                AIPathConsecutiverWayPoint, OccluderExOCC, StartPosStartPos, CameraParamListFld, CameraParamListEvt,
                Pos, Ang, SceLoadFlag, Flag, StageFlagType, WeatherStageInfo, WeatherParamInfoTbl, WeatherParamEfcInfo, WeatherEffectParam,
                SchedulerStageLightSchdl, EffectProvider, EpvIndexAlways, EpvIndexDay, EpvIndexNight, ZoneList, ZoneIndoorScr,
                ZoneIndoorEfc, DayNightLightChgFrame, DayNightFogChgFrame, SkyInfiniteLightGroup, ZoneUnitCtrl, ZoneStatus,
                SoundZone, EqLength, SoundAreaInfo, SchedulerEffectSchdl, SchedulerLanternSchdl, IsCraftStage, LocationData,
                GrassVisiblePercentMulValue, GrassFadeBeginDistance, GrassFadeEndDistance, PerformanceFlag, AnotherMapName);
    }

    @Override
    protected StageInfo parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return readStageStageInfo(bufferReader, lookupUtil);
    }
}
