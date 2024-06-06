package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.em_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common.EvaluationTable;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common.EvaluationTableList;

public class EvaluationTableDeserializer extends ClientResourceFileDeserializer {


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
    protected EvaluationTableList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EvaluationTableList(bufferReader.readArray(EvaluationTableDeserializer::readEvaluationTable));
    }
}
