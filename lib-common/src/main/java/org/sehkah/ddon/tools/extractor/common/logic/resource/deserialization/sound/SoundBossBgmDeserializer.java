package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.sound;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ReferenceArchiveDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ResourceInfoS;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound.SoundBossBgm;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound.SoundBossBgmList;

import java.nio.file.Path;

public class SoundBossBgmDeserializer extends ClientResourceFileDeserializer<SoundBossBgmList> {
    private static SoundBossBgm readSoundBossBgm(BufferReader bufferReader) {
        long EnemyId = bufferReader.readUnsignedInteger();
        long BgmNo = bufferReader.readUnsignedInteger();
        ResourceInfoS SrqrId = ReferenceArchiveDeserializer.readResourceInfoS(bufferReader);

        return new SoundBossBgm(EnemyId, BgmNo, SrqrId);
    }


    @Override
    protected SoundBossBgmList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new SoundBossBgmList(bufferReader.readArray(SoundBossBgmDeserializer::readSoundBossBgm));
    }
}
