package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common.EvaluationTable;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common.EvaluationTableList;

public class EvaluationTableDeserializer extends ClientResourceFileDeserializer {
    public EvaluationTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EvaluationTable readEvaluationTable(FileReader fileReader) {
        return new EvaluationTable(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected EvaluationTableList parseClientResourceFile(FileReader fileReader) {
        return new EvaluationTableList(fileReader.readArray(EvaluationTableDeserializer::readEvaluationTable));
    }
}
