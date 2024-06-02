package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.job;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.job.MagicCommandWord;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.job.MagicCommandWordTbl;

public class MagicCommandWordTblDeserializer extends ClientResourceFileDeserializer {
    public MagicCommandWordTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MagicCommandWord readMagicCommandWord(BufferReader bufferReader) {
        return new MagicCommandWord(bufferReader.readFixedLengthArray(32, BufferReader::readSignedInteger));
    }

    @Override
    protected MagicCommandWordTbl parseClientResourceFile(BufferReader bufferReader) {
        return new MagicCommandWordTbl(bufferReader.readArray(MagicCommandWordTblDeserializer::readMagicCommandWord));
    }
}
