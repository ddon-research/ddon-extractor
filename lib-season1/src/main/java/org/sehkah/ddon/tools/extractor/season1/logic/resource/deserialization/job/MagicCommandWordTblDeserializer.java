package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.job;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job.MagicCommandWord;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job.MagicCommandWordTbl;

public class MagicCommandWordTblDeserializer extends ClientResourceFileDeserializer {


    private static MagicCommandWord readMagicCommandWord(BufferReader bufferReader) {
        return new MagicCommandWord(bufferReader.readFixedLengthArray(32, BufferReader::readSignedInteger));
    }

    @Override
    protected MagicCommandWordTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new MagicCommandWordTbl(bufferReader.readArray(MagicCommandWordTblDeserializer::readMagicCommandWord));
    }
}
