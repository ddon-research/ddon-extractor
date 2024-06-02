package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.wep_res_table;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.wep_res_table.WepCateRes;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.wep_res_table.WepCateResTbl;

public class WepCateResTblDeserializer extends ClientResourceFileDeserializer {
    public WepCateResTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static WepCateRes readWepCateRes(BufferReader bufferReader) {
        return new WepCateRes(
                bufferReader.readUnsignedInteger(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong()
        );
    }

    @Override
    protected WepCateResTbl parseClientResourceFile(BufferReader bufferReader) {
        return new WepCateResTbl(bufferReader.readArray(WepCateResTblDeserializer::readWepCateRes));
    }
}
