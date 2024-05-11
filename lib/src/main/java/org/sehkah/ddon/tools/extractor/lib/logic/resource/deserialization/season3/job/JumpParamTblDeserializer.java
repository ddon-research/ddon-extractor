package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.job;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.job.JumpParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.job.JumpParamTbl;

public class JumpParamTblDeserializer extends ClientResourceFileDeserializer {
    public JumpParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static JumpParam readJumpParam(FileReader fileReader) {
        return new JumpParam(
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readBoolean(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected JumpParamTbl parseClientResourceFile(FileReader fileReader) {
        return new JumpParamTbl(fileReader.readArray(JumpParamTblDeserializer::readJumpParam));
    }
}
