package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.job;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.job.MagicCommand;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.job.MagicCommandList;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.job.MagicCommandListTbl;

public class MagicCommandListTblDeserializer extends ClientResourceFileDeserializer {
    public MagicCommandListTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MagicCommand readMagicCommand(BufferReader bufferReader) {
        return new MagicCommand(bufferReader.readFloat());
    }

    private static MagicCommandList readMagicCommandList(BufferReader bufferReader) {
        return new MagicCommandList(
                bufferReader.readArray(MagicCommandListTblDeserializer::readMagicCommand),
                bufferReader.readArray(MagicCommandListTblDeserializer::readMagicCommand),
                bufferReader.readArray(MagicCommandListTblDeserializer::readMagicCommand)
        );
    }

    @Override
    protected MagicCommandListTbl parseClientResourceFile(BufferReader bufferReader) {
        // MGCC is the only format to not have a file header, instead exporting all its data in "binary" format directly
        //  As a workaround to how file header identification is a basis of everything, treat the number of items as version
        //  afterward reset to position 0
        bufferReader.setPosition(0);
        return new MagicCommandListTbl(bufferReader.readArray(MagicCommandListTblDeserializer::readMagicCommandList));
    }
}
