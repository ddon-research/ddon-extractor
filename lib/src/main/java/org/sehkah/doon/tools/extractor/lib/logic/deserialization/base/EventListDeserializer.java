package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtractionType;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.EventParam;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.OmList;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta.EventParamWithMetaInformation;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta.StageInfoWithMetaInformation;

public class EventListDeserializer extends FileDeserializer {
    public EventListDeserializer(FileReader fileReader) {
        super(ExtractionType.EVENT_PARAM, fileReader);
    }

    private static EventParam readEntity(FileReader fileReader) {
        return EventParam.of(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readNullTerminatedString(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readFloat(),
                fileReader.readArray(EventListDeserializer::readOmList)
        );
    }

    private static OmList readOmList(FileReader fileReader) {
        return new OmList(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort()
        );
    }

    private static EventParamWithMetaInformation readEntityWithMetaInformation(FileReader fileReader) {
        return EventParamWithMetaInformation.of(readEntity(fileReader));
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(EventListDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return fileReader.readArray(EventListDeserializer::readEntityWithMetaInformation);
    }
}
