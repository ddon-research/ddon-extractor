package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.binary.meta.PropertyType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.Scheduler;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.SchedulerHeader;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.SchedulerKey;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.SchedulerKeyMode;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.SchedulerTrack;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.SchedulerTrackType;

import java.math.BigInteger;
import java.nio.file.Path;
import java.util.List;

public class SchedulerDeserializer extends ClientResourceFileDeserializer<Scheduler> {
    private static Object readSchedulerValue(BufferReader bufferReader, SchedulerHeader header, PropertyType PropType) {
        return switch (PropType) {
            case TYPE_BOOL, TYPE_EVENT -> bufferReader.readBoolean();
            case TYPE_S8 -> bufferReader.readSignedByte();
            case TYPE_U8 -> bufferReader.readUnsignedByte();
            case TYPE_S16 -> bufferReader.readSignedShort();
            case TYPE_U16 -> bufferReader.readUnsignedShort();
            case TYPE_S32 -> bufferReader.readSignedInteger();
            case TYPE_U32, TYPE_EVENT32, TYPE_CLASSREF -> bufferReader.readUnsignedInteger();
            case TYPE_F32 -> bufferReader.readFloat();
            case TYPE_HERMITECURVE -> bufferReader.readHermiteCurve();
            case TYPE_QUATERNION, TYPE_VECTOR4 -> bufferReader.readVector4f();
            case TYPE_MATRIX -> bufferReader.readMatrix();
            case TYPE_FLOAT2 -> bufferReader.readVector2f();
            case TYPE_VECTOR3 -> {
                Vector3f vector3f = bufferReader.readVector3f();
                bufferReader.readFloat(); //padding
                yield vector3f;
            }
            case TYPE_CUSTOM -> {
                long offset = bufferReader.readUnsignedInteger();
                int position = bufferReader.getPosition();
                bufferReader.setPosition((int) (header.getMetaDataOffset() + offset));
                String name = bufferReader.readNullTerminatedString();
                bufferReader.setPosition(position);
                yield name;
            }
            default -> throw new TechnicalException("Unsupported property type encountered: " + PropType);
        };
    }


    private static SchedulerKey readSchedulerKey(BufferReader bufferReader) {
        long KeyBits = bufferReader.readUnsignedInteger();
        int Frame = BitUtil.extractInt(KeyBits, 0, 23);
        int Mode = BitUtil.extractInt(KeyBits, 24, 31);
        SchedulerKeyMode ModeType = SchedulerKeyMode.of(Mode);

        return new SchedulerKey(Frame, Mode, ModeType);
    }

    private static SchedulerTrack readSchedulerTrack(BufferReader bufferReader, SchedulerHeader header) {
        long TrackBits = bufferReader.readUnsignedInteger();
        int TrackType = BitUtil.extractInt(TrackBits, 0, 7);
        SchedulerTrackType TrackTypeName = SchedulerTrackType.of(TrackType);
        int PropType = BitUtil.extractInt(TrackBits, 8, 15);
        PropertyType PropTypeName = PropertyType.of(PropType);
        int KeyNum = BitUtil.extractInt(TrackBits, 16, 23);

        long ParentIndex = bufferReader.readUnsignedInteger();

        String TrackName = null;
        long TrackNameOffset = bufferReader.readUnsignedInteger();
        if (TrackNameOffset > 0) {
            int position = bufferReader.getPosition();
            bufferReader.setPosition((int) (header.getMetaDataOffset() + TrackNameOffset));
            TrackName = bufferReader.readNullTerminatedString();
            bufferReader.setPosition(position);
        }

        long DTIID = bufferReader.readUnsignedInteger();
        String ResourceName = null;
        if (DTIID > 0) {
            ResourceName = FrameworkResourcesUtil.getFrameworkResourceClassNameByCrc(DTIID);
        }

        BigInteger UnitGroup = bufferReader.readUnsignedLong();

        List<SchedulerKey> KeyFrame = null;
        long KeyFrameOffset = bufferReader.readUnsignedInteger();
        if (KeyFrameOffset > 0) {
            int position = bufferReader.getPosition();
            bufferReader.setPosition((int) KeyFrameOffset);
            KeyFrame = bufferReader.readArray(KeyNum, SchedulerDeserializer::readSchedulerKey);
            bufferReader.setPosition(position);
        }

        List<Object> KeyValue = null;
        long KeyValueOffset = bufferReader.readUnsignedInteger();
        if (KeyValueOffset > 0) {
            int position = bufferReader.getPosition();
            bufferReader.setPosition((int) KeyValueOffset);
            KeyValue = bufferReader.readArray(KeyNum, br -> readSchedulerValue(br, header, PropTypeName));
            bufferReader.setPosition(position);
        }

        return new SchedulerTrack(TrackType, TrackTypeName, PropType, PropTypeName, KeyNum, ParentIndex, TrackName, DTIID, ResourceName, UnitGroup, KeyFrame, KeyValue);
    }

    private static SchedulerHeader readSchedulerHeader(BufferReader bufferReader) {
        int TrackNum = bufferReader.readUnsignedShort();
        long Crc = bufferReader.readUnsignedInteger();

        long FrameBits = bufferReader.readUnsignedInteger();
        int FrameMax = BitUtil.extractInt(FrameBits, 0, 23);
        boolean FloorFrame = BitUtil.extractBoolean(FrameBits, 24);

        long BaseTrack = bufferReader.readUnsignedInteger();
        long MetaDataOffset = bufferReader.readUnsignedInteger();

        return new SchedulerHeader(TrackNum, Crc, FrameMax, FloorFrame, BaseTrack, MetaDataOffset);
    }

    @Override
    protected Scheduler parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        SchedulerHeader Header = readSchedulerHeader(bufferReader);
        List<SchedulerTrack> Tracks = bufferReader.readArray(Header.getTrackNum(), br -> readSchedulerTrack(br, Header));

        // Lots of jumping around and lots of padding in rScheduler. To avoid complicated bit consumption logic, risk losing some data by pretending to have read everything.
        // Assume that if all data has been somewhat correctly read then the last position should be just before the string pool (meta data).
        bufferReader.setPosition(bufferReader.getLimit());

        return new Scheduler(Header, Tracks);
    }
}
