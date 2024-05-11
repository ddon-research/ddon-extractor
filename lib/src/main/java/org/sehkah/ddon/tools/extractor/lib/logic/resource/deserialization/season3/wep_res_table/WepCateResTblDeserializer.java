package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.wep_res_table;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.wep_res_table.WepCateRes;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.wep_res_table.WepCateResTbl;

public class WepCateResTblDeserializer extends ClientResourceFileDeserializer {
    public WepCateResTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static WepCateRes readWepCateRes(FileReader fileReader) {
        return new WepCateRes(
                fileReader.readUnsignedInteger(),
                fileReader.readNullTerminatedString(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong()
        );
    }

    @Override
    protected WepCateResTbl parseClientResourceFile(FileReader fileReader) {
        return new WepCateResTbl(fileReader.readArray(WepCateResTblDeserializer::readWepCateRes));
    }
}
