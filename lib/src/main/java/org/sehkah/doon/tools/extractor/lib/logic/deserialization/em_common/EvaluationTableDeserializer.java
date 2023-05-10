package org.sehkah.doon.tools.extractor.lib.logic.deserialization.em_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.em_common.EvaluationTable;

import java.util.List;

public class EvaluationTableDeserializer extends FileDeserializer<List<EvaluationTable>> {
    public EvaluationTableDeserializer() {
        super(ClientResourceFile.rEvaluationTable);
    }

    private static EvaluationTable readEntity(FileReader fileReader) {
        return new EvaluationTable(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected List<EvaluationTable> readObject(FileReader fileReader) {
        return fileReader.readArray(EvaluationTableDeserializer::readEntity);
    }
}
