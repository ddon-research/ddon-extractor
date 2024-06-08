package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.ParentRegionStatusParam;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.ParentRegionStatusParamTable;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.RegionBreakInfo;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.RegionBreakInfoTable;

public class ParentRegionStatusParamTableDeserializer extends ClientResourceFileDeserializer<ParentRegionStatusParamTable> {


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
    protected ParentRegionStatusParamTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new ParentRegionStatusParamTable(bufferReader.readArray(ParentRegionStatusParamTableDeserializer::readParentRegionStatusParam));
    }
}
