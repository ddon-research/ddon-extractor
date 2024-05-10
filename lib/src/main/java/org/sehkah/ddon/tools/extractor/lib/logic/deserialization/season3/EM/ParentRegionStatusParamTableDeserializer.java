package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.ParentRegionStatusParam;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.ParentRegionStatusParamTable;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.RegionBreakInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.RegionBreakInfoTable;

public class ParentRegionStatusParamTableDeserializer extends ClientResourceFileDeserializer {
    public ParentRegionStatusParamTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static RegionBreakInfo readRegionBreakInfo(FileReader fileReader) {
        return new RegionBreakInfo(
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    private static RegionBreakInfoTable readRegionBreakInfoTable(FileReader fileReader) {
        return new RegionBreakInfoTable(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(ParentRegionStatusParamTableDeserializer::readRegionBreakInfo)
        );
    }

    private static ParentRegionStatusParam readParentRegionStatusParam(FileReader fileReader) {
        return new ParentRegionStatusParam(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readFixedLengthArray(5, FileReader::readUnsignedInteger),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                readRegionBreakInfoTable(fileReader)
        );
    }

    @Override
    protected ParentRegionStatusParamTable parseClientResourceFile(FileReader fileReader) {
        return new ParentRegionStatusParamTable(fileReader.readArray(ParentRegionStatusParamTableDeserializer::readParentRegionStatusParam));
    }
}
