package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.PackageQuestInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.PackageQuestInfoList;

public class PackageQuestInfoDeserializer extends ClientResourceFileDeserializer {
    public PackageQuestInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected PackageQuestInfoList parseClientResourceFile(BufferReader bufferReader) {
        return new PackageQuestInfoList(bufferReader.readArray(PackageQuestInfoDeserializer::readPackageQuestInfo));
    }
}
