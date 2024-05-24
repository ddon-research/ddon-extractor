package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.binary;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary.BinaryHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary.ClassData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary.ClassHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary.PropertyHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary.meta.PropertyType;

import java.util.List;

public class BinaryHeaderDeserializer {
    private BinaryHeaderDeserializer() {

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
        final List<PropertyHeader> fields = bufferReader.readFixedLengthArray(propNum, BinaryHeaderDeserializer::readPropertyHeader);
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
        final List<ClassData> classDataList = bufferReader.readFixedLengthArray(classDataOffset.size(), BinaryHeaderDeserializer::readClassData);
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

    public static BinaryHeader parseHeader(BufferReader bufferReader) {
        return new BinaryHeader(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readClassHeader(bufferReader)
        );
    }
}
