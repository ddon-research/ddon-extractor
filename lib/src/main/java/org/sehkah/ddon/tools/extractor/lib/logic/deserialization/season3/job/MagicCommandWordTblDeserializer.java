package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.job;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.job.MagicCommandWord;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.job.MagicCommandWordTbl;

public class MagicCommandWordTblDeserializer extends ClientResourceFileDeserializer {
    public MagicCommandWordTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MagicCommandWord readMagicCommandWord(FileReader fileReader) {
        return new MagicCommandWord(fileReader.readFixedLengthArray(32, FileReader::readSignedInteger));
    }

    @Override
    protected MagicCommandWordTbl parseClientResourceFile(FileReader fileReader) {
        return new MagicCommandWordTbl(fileReader.readArray(MagicCommandWordTblDeserializer::readMagicCommandWord));
    }
}
