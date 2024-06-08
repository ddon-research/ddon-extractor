package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.ChildRegionStatusParamList;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.ChildRegionStatusParamListTable;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.ChildRegionStatusParamTable;

public class ChildRegionStatusParamListTableDeserializer extends ClientResourceFileDeserializer<ChildRegionStatusParamListTable> {


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
    protected ChildRegionStatusParamListTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new ChildRegionStatusParamListTable(bufferReader.readArray(ChildRegionStatusParamListTableDeserializer::readChildRegionStatusParamList));
    }
}
