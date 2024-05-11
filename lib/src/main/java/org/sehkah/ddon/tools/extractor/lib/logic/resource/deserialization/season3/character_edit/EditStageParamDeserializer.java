package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.character_edit;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.character_edit.EditStageParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.character_edit.EditStageParamInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.character_edit.EditStageParamInfoWeatherData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.character_edit.EditStageParamList;

public class EditStageParamDeserializer extends ClientResourceFileDeserializer {
    public EditStageParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EditStageParamList readEditStageParamList(FileReader fileReader) {
        return new EditStageParamList(
                fileReader.readFixedLengthArray(8, FileReader::readSignedByte)
        );
    }

    private static EditStageParamInfoWeatherData readEditStageParamInfoWeatherData(FileReader fileReader) {
        return new EditStageParamInfoWeatherData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    private static EditStageParamInfo readEditStageParamInfo(FileReader fileReader) {
        return new EditStageParamInfo(
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readUnsignedInteger(),
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readFixedLengthArray(2, EditStageParamDeserializer::readEditStageParamInfoWeatherData),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected EditStageParam parseClientResourceFile(FileReader fileReader) {
        return new EditStageParam(
                fileReader.readArray(EditStageParamDeserializer::readEditStageParamInfo),
                fileReader.readArray(EditStageParamDeserializer::readEditStageParamList)
        );
    }
}
