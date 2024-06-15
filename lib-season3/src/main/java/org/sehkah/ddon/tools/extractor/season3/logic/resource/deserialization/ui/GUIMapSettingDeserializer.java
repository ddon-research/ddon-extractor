package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui;

import org.sehkah.ddon.tools.extractor.api.datatype.Rectangle;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector2f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.*;

import java.nio.file.Path;
import java.util.List;

public class GUIMapSettingDeserializer extends ClientResourceFileDeserializer<GUIMapSetting> {
    private static GUIMapZoneShapeInfoBase readZoneShapeInfoBase(BufferReader bufferReader) {
        return new GUIMapZoneShapeInfoBase(
                bufferReader.readFloat(),
                bufferReader.readBoolean()
        );
    }

    private static GUIMapZoneShapeInfoOBB readZoneShapeInfoOBB(BufferReader bufferReader) {
        return new GUIMapZoneShapeInfoOBB(
                readZoneShapeInfoBase(bufferReader),
                bufferReader.readOrientedBoundingBox(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readBoolean()
        );
    }

    private static GUIMapZoneShapeInfoArea readZoneShapeInfoArea(BufferReader bufferReader) {
        return new GUIMapZoneShapeInfoArea(
                readZoneShapeInfoBase(bufferReader),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readFixedLengthArray(4, BufferReader::readVector3f),
                bufferReader.readVector3f()
        );
    }

    private static GUIMapAreaHitShape readAreaHitShape(BufferReader bufferReader) {
        String Name = bufferReader.readJapaneseNullTerminatedString();
        float CheckAngle = bufferReader.readFloat();
        float CheckRange = bufferReader.readFloat();
        float CheckToward = bufferReader.readFloat();
        boolean AngleFlag = bufferReader.readBoolean();
        boolean TowardFlag = bufferReader.readBoolean();
        int ShapeType = bufferReader.readSignedInteger();

        GUIMapZoneShapeInfoBase Zone = null;
        switch (ShapeType) {
            case 1 -> Zone = readZoneShapeInfoArea(bufferReader);
            case 9 -> Zone = readZoneShapeInfoOBB(bufferReader);
            default -> throw new TechnicalException("Unexpected value: " + ShapeType);
        }

        return new GUIMapAreaHitShape(Name,
                CheckAngle,
                CheckRange,
                CheckToward,
                AngleFlag,
                TowardFlag,
                ShapeType,
                Zone
        );
    }

    private static GUIMapSettingData readGUIMapSettingData(BufferReader bufferReader) {
        int ShapeType = bufferReader.readSignedInteger();
        String ShapeName = bufferReader.readNullTerminatedString();
        GUIMapAreaHitShape Shape = readAreaHitShape(bufferReader);
        long FloorId = bufferReader.readUnsignedInteger();

        return new GUIMapSettingData(ShapeType, ShapeName, Shape, FloorId);
    }

    @Override
    protected GUIMapSetting parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        Vector2f Center = bufferReader.readVector2f();
        int FloorBaseId = bufferReader.readSignedInteger();
        long FloorBaseSizeId = bufferReader.readUnsignedInteger();
        long TextureNumX = bufferReader.readUnsignedInteger();
        long TextureNumY = bufferReader.readUnsignedInteger();
        Rectangle Rect = bufferReader.readRectangle();
        float FoundationScale = bufferReader.readFloat();
        float OffsetPosX = bufferReader.readFloat();
        float OffsetPosY = bufferReader.readFloat();
        boolean UseIdTex = bufferReader.readBoolean();
        List<GUIMapSettingData> Array = bufferReader.readArray(GUIMapSettingDeserializer::readGUIMapSettingData);

        return new GUIMapSetting(Center, FloorBaseId, FloorBaseSizeId, TextureNumX, TextureNumY, Rect, FoundationScale, OffsetPosX, OffsetPosY, UseIdTex, Array);
    }
}
