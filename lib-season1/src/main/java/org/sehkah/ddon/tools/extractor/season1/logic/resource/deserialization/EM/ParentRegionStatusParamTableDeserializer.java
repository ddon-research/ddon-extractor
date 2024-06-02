package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.ParentRegionStatusParam;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.ParentRegionStatusParamTable;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.RegionBreakInfo;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.RegionBreakInfoTable;

public class ParentRegionStatusParamTableDeserializer extends ClientResourceFileDeserializer {
    public ParentRegionStatusParamTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static RegionBreakInfo readRegionBreakInfo(BufferReader bufferReader) {
        return new RegionBreakInfo(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger()
        );
    }

    private static RegionBreakInfoTable readRegionBreakInfoTable(BufferReader bufferReader) {
        return new RegionBreakInfoTable(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(ParentRegionStatusParamTableDeserializer::readRegionBreakInfo)
        );
    }

    private static ParentRegionStatusParam readParentRegionStatusParam(BufferReader bufferReader) {
        return new ParentRegionStatusParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFixedLengthArray(5, BufferReader::readUnsignedInteger),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                readRegionBreakInfoTable(bufferReader)
        );
    }

    @Override
    protected ParentRegionStatusParamTable parseClientResourceFile(BufferReader bufferReader) {
        return new ParentRegionStatusParamTable(bufferReader.readArray(ParentRegionStatusParamTableDeserializer::readParentRegionStatusParam));
    }
}
