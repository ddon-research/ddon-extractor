package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common.EvaluationTable;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common.EvaluationTableList;

public class EvaluationTableDeserializer extends ClientResourceFileDeserializer {
    public EvaluationTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected EvaluationTableList parseClientResourceFile(BufferReader bufferReader) {
        return new EvaluationTableList(bufferReader.readArray(EvaluationTableDeserializer::readEvaluationTable));
    }
}
