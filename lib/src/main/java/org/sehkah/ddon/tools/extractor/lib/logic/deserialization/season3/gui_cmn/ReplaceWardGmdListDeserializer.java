package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.gui_cmn.ReplaceWardGmd;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.gui_cmn.ReplaceWardGmdList;

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
