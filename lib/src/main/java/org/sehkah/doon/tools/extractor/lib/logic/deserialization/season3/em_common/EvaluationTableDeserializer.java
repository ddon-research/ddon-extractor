package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.em_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.em_common.EvaluationTable;

import java.util.List;

public class EvaluationTableDeserializer extends ClientResourceFileDeserializer<List<EvaluationTable>> {
    public EvaluationTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<EvaluationTable> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(EvaluationTableDeserializer::readEntity);
    }
}
