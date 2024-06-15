package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.em_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common.EvaluationTable;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common.EvaluationTableList;

import java.nio.file.Path;

public class EvaluationTableDeserializer extends ClientResourceFileDeserializer<EvaluationTableList> {


    private static EvaluationTable readEvaluationTable(BufferReader bufferReader) {
        return new EvaluationTable(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected EvaluationTableList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EvaluationTableList(bufferReader.readArray(EvaluationTableDeserializer::readEvaluationTable));
    }
}
