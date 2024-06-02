package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.binary;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.OrientedBoundingBox;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.binary.*;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.binary.meta.PropertyType;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

// TODO: Make better use of this to abstract the unwrapping of all the binary meta data
// TODO: Forward to other deserializers and get rid of buffer position hack
public class XfsDeserializer {
    private XfsDeserializer() {

    }

    private static PropertyHeader readPropertyHeader(BufferReader bufferReader) {
        PropertyHeader propertyHeader = new PropertyHeader();

        propertyHeader.propertyNameOffset = bufferReader.readUnsignedInteger();
        // bitfield FieldFlag { type : 8; attr : 8; bytes : 15; disable : 1; };
        propertyHeader.propertyParam = bufferReader.readUnsignedInteger();

        propertyHeader.propertyParamType = BitUtil.extractInt(propertyHeader.propertyParam, 0, 8);
        propertyHeader.propertyParamTypeName = PropertyType.of(propertyHeader.propertyParamType);

        propertyHeader.propertyParamAttr = BitUtil.extractInt(propertyHeader.propertyParam, 8, 16);
        propertyHeader.propertyParamBytes = BitUtil.extractInt(propertyHeader.propertyParam, 16, 31);
        propertyHeader.propertyParamDisable = BitUtil.extractInt(propertyHeader.propertyParam, 31, 32);

        propertyHeader.unk1 = bufferReader.readUnsignedInteger();
        propertyHeader.unk2 = bufferReader.readUnsignedInteger();
        propertyHeader.unk3 = bufferReader.readUnsignedInteger();
        propertyHeader.unk4 = bufferReader.readUnsignedInteger();

        return propertyHeader;
    }

    private static ClassData readClassData(BufferReader bufferReader) {
        final long ID = bufferReader.readUnsignedInteger();
        final long classParam = bufferReader.readUnsignedInteger();
        final int propNum = BitUtil.extractInt(classParam, 0, 15);
        final int init = BitUtil.extractInt(classParam, 15, 16);
        final int reserved = BitUtil.extractInt(classParam, 16, 32);
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
        classDataList.forEach(classData -> classData.properties().forEach(property -> {
            bufferReader.setPosition(baseOffset + (int) property.propertyNameOffset);
            property.name = bufferReader.readNullTerminatedString();
        }));
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
        Map<Integer, ClassData> classDataIndexMap = HashMap.newHashMap((int) classHeader.numClasses());
        // TODO: empiric data shows this is the value, but unclear how this calculation makes sense
        int classDataIndex = 1;
        for (ClassData classData : classHeader.classDataList()) {
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
        long propertyCount = bufferReader.readUnsignedInteger();
        OrientedBoundingBox orientedBoundingBox = bufferReader.readOrientedBoundingBox();
        float padding = bufferReader.readFloat();
        return orientedBoundingBox;
    }

    public static Vector3f readVector3f(BufferReader bufferReader) {
        Vector3f vector3f = readXfsProperty(bufferReader, BufferReader::readVector3f);
        float padding = bufferReader.readFloat();
        return vector3f;
    }

    public static <T> List<T> readMtArray(BufferReader bufferReader, Function<BufferReader, T> entityReaderFunction) {
        long propertyCount = bufferReader.readUnsignedInteger();

        readXfsObjectData(bufferReader);

        boolean autoDelete = readXfsProperty(bufferReader, BufferReader::readBoolean);
        return bufferReader.readArray(entityReaderFunction);
    }

}
