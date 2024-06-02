package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.job;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.job.JumpParam;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.job.JumpParamTbl;

public class JumpParamTblDeserializer extends ClientResourceFileDeserializer {
    public JumpParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static JumpParam readJumpParam(BufferReader bufferReader) {
        return new JumpParam(
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readBoolean(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected JumpParamTbl parseClientResourceFile(BufferReader bufferReader) {
        return new JumpParamTbl(bufferReader.readArray(JumpParamTblDeserializer::readJumpParam));
    }
}
