package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.job;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.job.MagicCommand;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.job.MagicCommandList;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.job.MagicCommandListTbl;

public class MagicCommandListTblDeserializer extends ClientResourceFileDeserializer {
    public MagicCommandListTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MagicCommand readMagicCommand(FileReader fileReader) {
        return new MagicCommand(fileReader.readFloat());
    }

    private static MagicCommandList readMagicCommandList(FileReader fileReader) {
        return new MagicCommandList(
                fileReader.readArray(MagicCommandListTblDeserializer::readMagicCommand),
                fileReader.readArray(MagicCommandListTblDeserializer::readMagicCommand),
                fileReader.readArray(MagicCommandListTblDeserializer::readMagicCommand)
        );
    }

    @Override
    protected MagicCommandListTbl parseClientResourceFile(FileReader fileReader) {
        // MGCC is the only format to not have a file header, instead exporting all its data in "binary" format directly
        //  As a workaround to how file header identification is a basis of everything, treat the number of items as version
        //  afterward reset to position 0
        fileReader.setPosition(0);
        return new MagicCommandListTbl(fileReader.readArray(MagicCommandListTblDeserializer::readMagicCommandList));
    }
}
