package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.character_edit;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.character_edit.EditStageParam;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.character_edit.EditStageParamInfo;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.character_edit.EditStageParamInfoWeatherData;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.character_edit.EditStageParamList;

public class EditStageParamDeserializer extends ClientResourceFileDeserializer {
    public EditStageParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EditStageParamList readEditStageParamList(BufferReader bufferReader) {
        return new EditStageParamList(
                bufferReader.readFixedLengthArray(8, BufferReader::readSignedByte)
        );
    }

    private static EditStageParamInfoWeatherData readEditStageParamInfoWeatherData(BufferReader bufferReader) {
        return new EditStageParamInfoWeatherData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static EditStageParamInfo readEditStageParamInfo(BufferReader bufferReader) {
        return new EditStageParamInfo(
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readFixedLengthArray(2, EditStageParamDeserializer::readEditStageParamInfoWeatherData),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected EditStageParam parseClientResourceFile(BufferReader bufferReader) {
        return new EditStageParam(
                bufferReader.readArray(EditStageParamDeserializer::readEditStageParamInfo),
                bufferReader.readArray(EditStageParamDeserializer::readEditStageParamList)
        );
    }
}
