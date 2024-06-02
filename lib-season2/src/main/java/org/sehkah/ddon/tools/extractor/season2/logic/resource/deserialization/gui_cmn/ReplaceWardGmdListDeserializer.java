package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.ReplaceWardGmd;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.ReplaceWardGmdList;

public class ReplaceWardGmdListDeserializer extends ClientResourceFileDeserializer {
    public ReplaceWardGmdListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ReplaceWardGmd readReplaceWardGmd(BufferReader bufferReader) {
        return new ReplaceWardGmd(bufferReader.readUnsignedLong());
    }

    @Override
    protected ReplaceWardGmdList parseClientResourceFile(BufferReader bufferReader) {
        return new ReplaceWardGmdList(bufferReader.readArray(ReplaceWardGmdListDeserializer::readReplaceWardGmd));
    }
}
