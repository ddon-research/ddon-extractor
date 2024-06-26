package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.ReplaceWardGmd;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.ReplaceWardGmdList;

import java.nio.file.Path;

public class ReplaceWardGmdListDeserializer extends ClientResourceFileDeserializer<ReplaceWardGmdList> {
    private static ReplaceWardGmd readReplaceWardGmd(BufferReader bufferReader) {
        return new ReplaceWardGmd(bufferReader.readUnsignedLong());
    }

    @Override
    protected ReplaceWardGmdList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new ReplaceWardGmdList(bufferReader.readArray(ReplaceWardGmdListDeserializer::readReplaceWardGmd));
    }
}
