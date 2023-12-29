package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.binary;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.binary.BinaryHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.binary.ClassData;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.binary.ClassHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.binary.PropertyHeader;

import java.util.List;

public class BinaryHeaderDeserializer {
    private BinaryHeaderDeserializer() {

    }

    private static PropertyHeader readPropertyHeader(FileReader fileReader) {
        PropertyHeader propertyHeader = new PropertyHeader();

        propertyHeader.propertyNameOffset = fileReader.readUnsignedInteger();
        // bitfield FieldFlag { type : 8; attr : 8; bytes : 15; disable : 1; };
        propertyHeader.propertyParam = fileReader.readUnsignedInteger();

        propertyHeader.propertyParamType = BitUtil.extractInt(propertyHeader.propertyParam, 0, 8);
        propertyHeader.propertyParamAttr = BitUtil.extractInt(propertyHeader.propertyParam, 8, 16);
        propertyHeader.propertyParamBytes = BitUtil.extractInt(propertyHeader.propertyParam, 16, 31);
        propertyHeader.propertyParamDisable = BitUtil.extractInt(propertyHeader.propertyParam, 31, 32);

        propertyHeader.unk1 = fileReader.readUnsignedInteger();
        propertyHeader.unk2 = fileReader.readUnsignedInteger();
        propertyHeader.unk3 = fileReader.readUnsignedInteger();
        propertyHeader.unk4 = fileReader.readUnsignedInteger();

        return propertyHeader;
    }

    private static ClassData readClassData(FileReader fileReader) {
        final long ID = fileReader.readUnsignedInteger();
        final long classParam = fileReader.readUnsignedInteger();
        final int propNum = BitUtil.extractInt(classParam, 0, 15);
        final int init = BitUtil.extractInt(classParam, 15, 16);
        final int reserved = BitUtil.extractInt(classParam, 16, 32);
        final List<PropertyHeader> fields = fileReader.readFixedLengthArray(propNum, BinaryHeaderDeserializer::readPropertyHeader);
        return new ClassData(
                ID, FrameworkResourcesUtil.getFrameworkResourceClassNameByCrc(ID),
                classParam,
                propNum,
                init,
                reserved,
                fields
        );
    }

    private static ClassHeader readClassHeader(FileReader fileReader) {
        final long numClasses = fileReader.readUnsignedInteger();
        final long bufferSize = fileReader.readUnsignedInteger();
        final int baseOffset = fileReader.getPosition();
        final List<Long> classDataOffset = fileReader.readFixedLengthArray(numClasses, FileReader::readUnsignedInteger);
        final List<ClassData> classDataList = fileReader.readFixedLengthArray(classDataOffset.size(), BinaryHeaderDeserializer::readClassData);
        classDataList.forEach(classData -> classData.properties().forEach(property -> {
            fileReader.setPosition(baseOffset + (int) property.propertyNameOffset);
            property.name = fileReader.readNullTerminatedString();
        }));
        fileReader.setPosition(baseOffset + (int) bufferSize);

        return new ClassHeader(
                numClasses,
                bufferSize,
                classDataOffset,
                classDataList
        );
    }

    public static BinaryHeader parseClientResourceFile(FileReader fileReader) {
        return new BinaryHeader(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readClassHeader(fileReader)
        );
    }
}
