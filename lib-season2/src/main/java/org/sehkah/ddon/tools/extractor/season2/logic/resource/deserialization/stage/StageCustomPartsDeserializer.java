package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.datatype.Color;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageCustomParts;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageCustomPartsFilter;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageCustomPartsInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageCustomPartsParam;

import java.math.BigInteger;
import java.nio.file.Path;
import java.util.List;

public class StageCustomPartsDeserializer extends ClientResourceFileDeserializer<StageCustomParts> {


    private static StageCustomPartsInfo readStageCustomPartsInfo(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        String Model = bufferReader.readNullTerminatedString();
        String ScrSbc1 = bufferReader.readNullTerminatedString();
        String EffSbc1 = bufferReader.readNullTerminatedString();
        String ScrSbc2 = bufferReader.readNullTerminatedString();
        String EffSbc2 = bufferReader.readNullTerminatedString();
        String ScrSbc3 = bufferReader.readNullTerminatedString();
        String EffSbc3 = bufferReader.readNullTerminatedString();
        String Light = bufferReader.readNullTerminatedString();
        String NaviMesh = bufferReader.readNullTerminatedString();
        String Epv = bufferReader.readNullTerminatedString();
        String Occluder = bufferReader.readNullTerminatedString();

        int AreaNo = bufferReader.readSignedShort();
        int Type = bufferReader.readSignedShort();
        long Size = bufferReader.readUnsignedInteger();
        float OffsetZ = bufferReader.readFloat();
        int EpvIndexAlways = bufferReader.readSignedInteger();
        int EpvIndexDay = bufferReader.readSignedInteger();
        int EpvIndexNight = bufferReader.readSignedInteger();
        Color Color = bufferReader.readColor();

        BigInteger EfcColorZone = bufferReader.readUnsignedLong();
        BigInteger EfcCtrlZone = bufferReader.readUnsignedLong();
        BigInteger IndoorZoneScr = bufferReader.readUnsignedLong();
        BigInteger IndoorZoneEfc = bufferReader.readUnsignedLong();
        BigInteger LightAndFogZone = bufferReader.readUnsignedLong();
        BigInteger SoundAreaInfo = bufferReader.readUnsignedLong();
        List<BigInteger> ZoneUnitCtrl = bufferReader.readFixedLengthArray(3, BufferReader::readUnsignedLong);
        BigInteger ZoneStatus = bufferReader.readUnsignedLong();

        String Comment = bufferReader.readJapaneseNullTerminatedString();

        Translation AreaName = null;
        if (lookupUtil != null) {
            AreaName = lookupUtil.getAreaName(AreaNo);
        }

        return new StageCustomPartsInfo(Model, ScrSbc1, EffSbc1, ScrSbc2, EffSbc2, ScrSbc3, EffSbc3, Light, NaviMesh,
                Epv, Occluder, AreaNo, AreaName, Type, Size, OffsetZ, EpvIndexAlways, EpvIndexDay, EpvIndexNight,
                Color, EfcColorZone, EfcCtrlZone, IndoorZoneScr, IndoorZoneEfc, LightAndFogZone, SoundAreaInfo,
                ZoneUnitCtrl, ZoneStatus, Comment);
    }

    private static StageCustomPartsFilter readStageCustomPartsFilter(BufferReader bufferReader) {
        return new StageCustomPartsFilter(
                bufferReader.readNullTerminatedString()
        );
    }

    private static StageCustomPartsParam readStageCustomPartsParam(BufferReader bufferReader) {
        return new StageCustomPartsParam(
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected StageCustomParts parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageCustomParts(
                readStageCustomPartsParam(bufferReader),
                bufferReader.readArray(StageCustomPartsDeserializer::readStageCustomPartsInfo, lookupUtil),
                bufferReader.readArray(StageCustomPartsDeserializer::readStageCustomPartsFilter)
        );
    }
}
