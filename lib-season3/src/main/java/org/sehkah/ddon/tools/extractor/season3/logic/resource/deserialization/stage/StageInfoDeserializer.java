package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.StageResourcePointer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.StageFlag;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.StageInfo;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public class StageInfoDeserializer extends ClientResourceFileDeserializer<StageInfo> {
    private static StageResourcePointer readStageResourcePointer(BufferReader bufferReader) {
        String Path = bufferReader.readNullTerminatedString();
        return Path.isEmpty() ? null : new StageResourcePointer(null, Path);
    }

    private static StageResourcePointer readTypedStageResourcePointer(BufferReader bufferReader) {
        String Type = bufferReader.readNullTerminatedString();
        return Type.isEmpty() ? null : new StageResourcePointer(Type, bufferReader.readNullTerminatedString());
    }

    private static StageInfo readStageStageInfo(BufferReader bufferReader) {
        StageResourcePointer SchedulerModel = readStageResourcePointer(bufferReader);
        StageResourcePointer SchedulerFilter = readTypedStageResourcePointer(bufferReader);
        StageResourcePointer CollisionScrSbc0 = readStageResourcePointer(bufferReader);
        StageResourcePointer CollisionEffSbc0 = readStageResourcePointer(bufferReader);
        StageResourcePointer CollisionScrSbc1 = readStageResourcePointer(bufferReader);
        StageResourcePointer CollisionEffSbc1 = readStageResourcePointer(bufferReader);
        StageResourcePointer CollisionScrSbc2 = readStageResourcePointer(bufferReader);
        StageResourcePointer CollisionEffSbc2 = readStageResourcePointer(bufferReader);
        StageResourcePointer NavigationMeshNaviMesh = readTypedStageResourcePointer(bufferReader);
        StageResourcePointer OccluderExOCC = readTypedStageResourcePointer(bufferReader);
        StageResourcePointer StartPosStartPos = readTypedStageResourcePointer(bufferReader);
        StageResourcePointer CameraParamListEvt = readStageResourcePointer(bufferReader);
        Vector3f Pos = bufferReader.readVector3f();
        float Ang = bufferReader.readFloat();
        long SceLoadFlag = bufferReader.readUnsignedInteger();
        long Flag = bufferReader.readUnsignedInteger();
        Set<StageFlag> StageFlagType = BitUtil.extractBitSetUnsignedIntegerFlag(StageFlag::of, i -> 1 << 1, Flag);
        StageResourcePointer WeatherStageInfo = readStageResourcePointer(bufferReader);
        StageResourcePointer WeatherParamInfoTbl = readStageResourcePointer(bufferReader);
        StageResourcePointer WeatherParamEfcInfo = readStageResourcePointer(bufferReader);
        StageResourcePointer WeatherEffectParam = readStageResourcePointer(bufferReader);
        StageResourcePointer SchedulerStageLightSchdl = readTypedStageResourcePointer(bufferReader);
        StageResourcePointer EffectProvider = readStageResourcePointer(bufferReader);
        int EpvIndexAlways = bufferReader.readSignedInteger();
        int EpvIndexDay = bufferReader.readSignedInteger();
        int EpvIndexNight = bufferReader.readSignedInteger();
        List<StageResourcePointer> ZoneList = bufferReader.readFixedLengthArray(4, StageInfoDeserializer::readTypedStageResourcePointer);
        StageResourcePointer ZoneIndoorScr = readTypedStageResourcePointer(bufferReader);
        StageResourcePointer ZoneIndoorEfc = readTypedStageResourcePointer(bufferReader);
        float DayNightLightChgFrame = bufferReader.readFloat();
        float DayNightFogChgFrame = bufferReader.readFloat();
        int SkyInfiniteLightGroup = bufferReader.readSignedInteger();
        List<StageResourcePointer> ZoneUnitCtrl = bufferReader.readFixedLengthArray(3, StageInfoDeserializer::readTypedStageResourcePointer);
        StageResourcePointer ZoneStatus = readTypedStageResourcePointer(bufferReader);
        List<StageResourcePointer> SoundZone = bufferReader.readFixedLengthArray(3, StageInfoDeserializer::readTypedStageResourcePointer);
        List<Float> EqLength = bufferReader.readFixedLengthArray(4, BufferReader::readFloat);
        StageResourcePointer SoundAreaInfo = readStageResourcePointer(bufferReader);
        StageResourcePointer SchedulerEffectSchdl = readStageResourcePointer(bufferReader);
        StageResourcePointer SchedulerLanternSchdl = readStageResourcePointer(bufferReader);
        boolean IsCraftStage = bufferReader.readBoolean();
        StageResourcePointer LocationData = readTypedStageResourcePointer(bufferReader);
        float GrassVisiblePercentMulValue = bufferReader.readFloat();
        float GrassFadeBeginDistance = bufferReader.readFloat();
        float GrassFadeEndDistance = bufferReader.readFloat();
        int PerformanceFlag = bufferReader.readUnsignedShort();
        String AnotherMapName = bufferReader.readNullTerminatedString();
        boolean Unknown = bufferReader.readBoolean();

        return new StageInfo(SchedulerModel, SchedulerFilter, CollisionScrSbc0, CollisionEffSbc0, CollisionScrSbc1,
                CollisionEffSbc1, CollisionScrSbc2, CollisionEffSbc2, NavigationMeshNaviMesh, OccluderExOCC,
                StartPosStartPos, CameraParamListEvt, Pos, Ang, SceLoadFlag, Flag, StageFlagType, WeatherStageInfo,
                WeatherParamInfoTbl, WeatherParamEfcInfo, WeatherEffectParam, SchedulerStageLightSchdl, EffectProvider,
                EpvIndexAlways, EpvIndexDay, EpvIndexNight, ZoneList, ZoneIndoorScr, ZoneIndoorEfc, DayNightLightChgFrame,
                DayNightFogChgFrame, SkyInfiniteLightGroup, ZoneUnitCtrl, ZoneStatus, SoundZone, EqLength,
                SoundAreaInfo, SchedulerEffectSchdl, SchedulerLanternSchdl, IsCraftStage, LocationData,
                GrassVisiblePercentMulValue, GrassFadeBeginDistance, GrassFadeEndDistance, PerformanceFlag,
                AnotherMapName, Unknown);
    }

    @Override
    protected StageInfo parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return readStageStageInfo(bufferReader);
    }
}
