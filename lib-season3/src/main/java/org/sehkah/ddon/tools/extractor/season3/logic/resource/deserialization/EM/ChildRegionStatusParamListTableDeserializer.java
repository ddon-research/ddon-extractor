package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.ChildRegionStatusParamList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.ChildRegionStatusParamListTable;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.ChildRegionStatusParamTable;

public class ChildRegionStatusParamListTableDeserializer extends ClientResourceFileDeserializer {
    public ChildRegionStatusParamListTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ChildRegionStatusParamTable readChildRegionStatusParamTable(BufferReader bufferReader) {
        long version = bufferReader.readUnsignedInteger();
        ChildRegionStatusParamTable childRegionStatusParamTable = new ChildRegionStatusParamTable(bufferReader.readArray(ChildRegionStatusParamDeserializer::readChildRegionStatusParam));
        childRegionStatusParamTable.setFileHeader(new FileHeader(version, 4));
        return childRegionStatusParamTable;
    }

    private static ChildRegionStatusParamList readChildRegionStatusParamList(BufferReader bufferReader) {
        return new ChildRegionStatusParamList(
                readChildRegionStatusParamTable(bufferReader),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger()
        );
    }

    @Override
    protected ChildRegionStatusParamListTable parseClientResourceFile(BufferReader bufferReader) {
        return new ChildRegionStatusParamListTable(bufferReader.readArray(ChildRegionStatusParamListTableDeserializer::readChildRegionStatusParamList));
    }
}
