package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.wep_res_table;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.wep_res_table.WepCateRes;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.wep_res_table.WepCateResTbl;

import java.nio.file.Path;

public class WepCateResTblDeserializer extends ClientResourceFileDeserializer<WepCateResTbl> {


    private static WepCateRes readWepCateRes(BufferReader bufferReader) {
        return new WepCateRes(
                bufferReader.readUnsignedInteger(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong()
        );
    }

    @Override
    protected WepCateResTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new WepCateResTbl(bufferReader.readArray(WepCateResTblDeserializer::readWepCateRes));
    }
}
