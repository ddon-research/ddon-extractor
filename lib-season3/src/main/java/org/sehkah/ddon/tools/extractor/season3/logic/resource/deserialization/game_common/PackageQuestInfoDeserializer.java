package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.PackageQuestInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.PackageQuestInfoList;

public class PackageQuestInfoDeserializer extends ClientResourceFileDeserializer<PackageQuestInfoList> {
    private static PackageQuestInfo readPackageQuestInfo(BufferReader bufferReader) {
        return new PackageQuestInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected PackageQuestInfoList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new PackageQuestInfoList(bufferReader.readArray(PackageQuestInfoDeserializer::readPackageQuestInfo));
    }
}
