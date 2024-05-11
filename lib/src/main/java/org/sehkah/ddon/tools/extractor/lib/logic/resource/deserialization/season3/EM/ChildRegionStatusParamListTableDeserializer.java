package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.ChildRegionStatusParamList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.ChildRegionStatusParamListTable;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.ChildRegionStatusParamTable;

public class ChildRegionStatusParamListTableDeserializer extends ClientResourceFileDeserializer {
    public ChildRegionStatusParamListTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ChildRegionStatusParamTable readChildRegionStatusParamTable(FileReader fileReader) {
        long version = fileReader.readUnsignedInteger();
        ChildRegionStatusParamTable childRegionStatusParamTable = new ChildRegionStatusParamTable(fileReader.readArray(ChildRegionStatusParamDeserializer::readChildRegionStatusParam));
        childRegionStatusParamTable.setFileHeader(new FileHeader(version, 4));
        return childRegionStatusParamTable;
    }

    private static ChildRegionStatusParamList readChildRegionStatusParamList(FileReader fileReader) {
        return new ChildRegionStatusParamList(
                readChildRegionStatusParamTable(fileReader),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    @Override
    protected ChildRegionStatusParamListTable parseClientResourceFile(FileReader fileReader) {
        return new ChildRegionStatusParamListTable(fileReader.readArray(ChildRegionStatusParamListTableDeserializer::readChildRegionStatusParamList));
    }
}
