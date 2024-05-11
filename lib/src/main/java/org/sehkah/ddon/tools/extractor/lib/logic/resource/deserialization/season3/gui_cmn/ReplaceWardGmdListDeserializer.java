package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn.ReplaceWardGmd;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn.ReplaceWardGmdList;

public class ReplaceWardGmdListDeserializer extends ClientResourceFileDeserializer {
    public ReplaceWardGmdListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ReplaceWardGmd readReplaceWardGmd(FileReader fileReader) {
        return new ReplaceWardGmd(fileReader.readUnsignedLong());
    }

    @Override
    protected ReplaceWardGmdList parseClientResourceFile(FileReader fileReader) {
        return new ReplaceWardGmdList(fileReader.readArray(ReplaceWardGmdListDeserializer::readReplaceWardGmd));
    }
}
