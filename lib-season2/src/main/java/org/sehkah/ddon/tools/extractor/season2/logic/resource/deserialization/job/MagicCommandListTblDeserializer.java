package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.job;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.job.MagicCommand;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.job.MagicCommandList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.job.MagicCommandListTbl;

public class MagicCommandListTblDeserializer extends ClientResourceFileDeserializer<MagicCommandListTbl> {


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
    protected MagicCommandListTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        // MGCC is the only format to not have a file header, instead exporting all its data in "binary" format directly
        //  As a workaround to how file header identification is a basis of everything, treat the number of items as version
        //  afterward reset to position 0
        bufferReader.setPosition(0);
        return new MagicCommandListTbl(bufferReader.readArray(MagicCommandListTblDeserializer::readMagicCommandList));
    }
}
