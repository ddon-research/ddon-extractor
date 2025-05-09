package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.binary;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.datatype.*;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.binary.meta.PropertyType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.binary.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

// TODO: Make better use of this to abstract the unwrapping of all the binary meta data
// TODO: Forward to other deserializers and get rid of buffer position hack
@Slf4j
public class XfsDeserializer {
    private XfsDeserializer() {

    }

    private static PropertyHeader readPropertyHeader(BufferReader bufferReader) {
        PropertyHeader propertyHeader = new PropertyHeader();

        propertyHeader.setPropertyNameOffset(bufferReader.readUnsignedInteger());
        // bitfield FieldFlag { type : 8; attr : 8; bytes : 15; disable : 1; };
        propertyHeader.setPropertyParam(bufferReader.readUnsignedInteger());

        propertyHeader.setPropertyParamType(BitUtil.extractInt(propertyHeader.getPropertyParam(), 0, 7));
        propertyHeader.setPropertyParamTypeName(PropertyType.of(propertyHeader.getPropertyParamType()));

        propertyHeader.setPropertyParamAttr(BitUtil.extractInt(propertyHeader.getPropertyParam(), 8, 15));
        propertyHeader.setPropertyParamBytes(BitUtil.extractInt(propertyHeader.getPropertyParam(), 16, 30));
        propertyHeader.setPropertyParamDisable(BitUtil.extractBoolean(propertyHeader.getPropertyParam(), 31));

        propertyHeader.setUnknown1(bufferReader.readUnsignedInteger());
        propertyHeader.setUnknown2(bufferReader.readUnsignedInteger());
        propertyHeader.setUnknown3(bufferReader.readUnsignedInteger());
        propertyHeader.setUnknown4(bufferReader.readUnsignedInteger());

        return propertyHeader;
    }

    private static ClassData readClassData(BufferReader bufferReader) {
        final long ID = bufferReader.readUnsignedInteger();
        final long classParam = bufferReader.readUnsignedInteger();
        final int propNum = BitUtil.extractInt(classParam, 0, 14);
        final boolean init = BitUtil.extractBoolean(classParam, 15);
        final int reserved = BitUtil.extractInt(classParam, 16, 31);
        final List<PropertyHeader> fields = bufferReader.readFixedLengthArray(propNum, XfsDeserializer::readPropertyHeader);
        return new ClassData(

                ID, FrameworkResourcesUtil.getFrameworkResourceClassNameByCrc(ID),
                classParam,
                propNum,
                init,
                reserved,
                fields
        );
    }

    private static ClassHeader readClassHeader(BufferReader bufferReader) {
        final long numClasses = bufferReader.readUnsignedInteger();
        final long bufferSize = bufferReader.readUnsignedInteger();
        final int baseOffset = bufferReader.getPosition();
        final List<Long> classDataOffset = bufferReader.readFixedLengthArray(numClasses, BufferReader::readUnsignedInteger);
        final List<ClassData> classDataList = bufferReader.readFixedLengthArray(classDataOffset.size(), XfsDeserializer::readClassData);
        classDataList.forEach(classData -> {
            log.debug("[XFS] {}, r: {}, #{}", classData.getID(), classData.getResourceName(), classData.getPropNum());
            classData.getProperties().forEach(property -> {
                bufferReader.setPosition(baseOffset + (int) property.getPropertyNameOffset());
                property.setName(bufferReader.readNullTerminatedString());
                if (property.isPropertyParamDisable()) {
                    log.warn("Class header for '{}' indicates that parameter '{}' is disabled.", classData.getResourceName(), property.getName());
                }
            });
        });
        bufferReader.setPosition(baseOffset + (int) bufferSize);

        return new ClassHeader(
                numClasses,
                bufferSize,
                classDataOffset,
                classDataList
        );
    }

    public static XfsHeader readHeader(BufferReader bufferReader) {
        int resourceVersion = bufferReader.readUnsignedShort();
        long objectDataNum = bufferReader.readUnsignedInteger();
        int classIndex = bufferReader.readUnsignedShort();
        int objIndex = bufferReader.readUnsignedShort();
        ClassHeader classHeader = readClassHeader(bufferReader);
        Map<Integer, ClassData> classDataIndexMap = HashMap.newHashMap((int) classHeader.getNumClasses());
        // TODO: empiric data shows this is the value, but unclear how this calculation makes sense
        int classDataIndex = 1;
        for (ClassData classData : classHeader.getClassDataList()) {
            classDataIndexMap.put(classDataIndex, classData);
            classDataIndex += 2;
        }
        return new XfsHeader(
                resourceVersion,
                objectDataNum,
                classIndex,
                objIndex,
                classHeader,
                classDataIndexMap
        );
    }

    public static XfsBody readResource(BufferReader bufferReader) {
        XfsObjectData xfsObjectData = readXfsObjectData(bufferReader);
        long quality = readXfsProperty(bufferReader, BufferReader::readUnsignedInteger);

        return new XfsBody(
                xfsObjectData,
                quality
        );
    }

    public static XfsObjectData readXfsObjectData(BufferReader bufferReader) {
        int classIndex = bufferReader.readUnsignedShort();
        int objIndex = bufferReader.readUnsignedShort();
        long bufferSize = bufferReader.readUnsignedInteger();
        return new XfsObjectData(
                classIndex,
                objIndex,
                bufferSize
        );
    }

    // TODO: Create special XFS Buffered Reader via inheritance instead?
    public static <T> T readXfsProperty(BufferReader bufferReader, Function<BufferReader, T> entityReaderFunction) {
        long propertyCount = bufferReader.readUnsignedInteger();
        return entityReaderFunction.apply(bufferReader);
    }

    public static long readUnsignedInteger(BufferReader bufferReader) {
        return readXfsProperty(bufferReader, BufferReader::readUnsignedInteger);
    }

    public static int readUnsignedByte(BufferReader bufferReader) {
        return readXfsProperty(bufferReader, BufferReader::readUnsignedByte);
    }

    public static byte readSignedByte(BufferReader bufferReader) {
        return readXfsProperty(bufferReader, BufferReader::readSignedByte);
    }

    public static String readJapaneseNullTerminatedString(BufferReader bufferReader) {
        return readXfsProperty(bufferReader, BufferReader::readJapaneseNullTerminatedString);
    }

    public static String readNullTerminatedString(BufferReader bufferReader) {
        return readXfsProperty(bufferReader, BufferReader::readNullTerminatedString);
    }

    public static int readSignedInteger(BufferReader bufferReader) {
        return readXfsProperty(bufferReader, BufferReader::readSignedInteger);
    }

    public static BigInteger readUnsignedLong(BufferReader bufferReader) {
        return readXfsProperty(bufferReader, BufferReader::readUnsignedLong);
    }

    public static boolean readBoolean(BufferReader bufferReader) {
        return readXfsProperty(bufferReader, BufferReader::readBoolean);
    }

    public static short readSignedShort(BufferReader bufferReader) {
        return readXfsProperty(bufferReader, BufferReader::readSignedShort);
    }

    public static int readUnsignedShort(BufferReader bufferReader) {
        return readXfsProperty(bufferReader, BufferReader::readUnsignedShort);
    }

    public static float readFloat(BufferReader bufferReader) {
        return readXfsProperty(bufferReader, BufferReader::readFloat);
    }

    public static OrientedBoundingBox readOrientedBoundingBox(BufferReader bufferReader) {
        OrientedBoundingBox orientedBoundingBox = readXfsProperty(bufferReader, BufferReader::readOrientedBoundingBox);
        float padding = bufferReader.readFloat();
        return orientedBoundingBox;
    }

    public static Sphere readSphere(BufferReader bufferReader) {
        long propertyCount = bufferReader.readUnsignedInteger();

        Vector3f pos = bufferReader.readVector3f();
        float r = bufferReader.readFloat();

        return new Sphere(pos, r);
    }

    public static Cylinder readCylinder(BufferReader bufferReader) {
        long propertyCount = bufferReader.readUnsignedInteger();

        Vector3f p0 = bufferReader.readVector3f();
        float padding1 = bufferReader.readFloat();
        assert padding1 == 0f;
        Vector3f p1 = bufferReader.readVector3f();
        float padding2 = bufferReader.readFloat();
        assert padding2 == 0f;
        float r = bufferReader.readFloat();
        float padding3 = bufferReader.readFloat();
        assert padding3 == 0f;
        float padding4 = bufferReader.readFloat();
        assert padding4 == 0f;
        float padding5 = bufferReader.readFloat();
        assert padding5 == 0f;

        return new Cylinder(p0, p1, r);
    }

    public static AxisAlignedBoundingBox readAxisAlignedBoundingBox(BufferReader bufferReader) {
        long propertyCount = bufferReader.readUnsignedInteger();

        Vector3f minpos = bufferReader.readVector3f();
        float padding1 = bufferReader.readFloat();
        Vector3f maxpos = bufferReader.readVector3f();
        float padding2 = bufferReader.readFloat();

        return new AxisAlignedBoundingBox(minpos, maxpos);
    }

    public static Vector3f readVector3f(BufferReader bufferReader) {
        Vector3f vector3f = readXfsProperty(bufferReader, BufferReader::readVector3f);
        float padding = bufferReader.readFloat();
        return vector3f;
    }

    public static Matrix readMatrix(BufferReader bufferReader) {
        Matrix matrix = readXfsProperty(bufferReader, BufferReader::readMatrix);
        return matrix;
    }

    public static <T> List<T> readMtArray(BufferReader bufferReader, Function<BufferReader, T> entityReaderFunction) {
        long propertyCount = bufferReader.readUnsignedInteger();

        XfsObjectData xfsObjectData = readXfsObjectData(bufferReader);

        boolean autoDelete = readXfsProperty(bufferReader, BufferReader::readBoolean);
        return bufferReader.readArray(entityReaderFunction);
    }

}
