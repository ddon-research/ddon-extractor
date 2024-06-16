package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.sound;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ReferenceArchiveDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ResourceInfoS;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound.SoundBossBgm;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound.SoundBossBgmList;

import java.nio.file.Path;

public class SoundBossBgmDeserializer extends ClientResourceFileDeserializer<SoundBossBgmList> {
    private static SoundBossBgm readSoundBossBgm(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long EnemyId = bufferReader.readUnsignedInteger();
        Translation EnemyName = null;
        if (lookupUtil != null) {
            EnemyName = lookupUtil.getEnemyName(EnemyId);
        }
        long BgmNo = bufferReader.readUnsignedInteger();
        ResourceInfoS SrqrId = ReferenceArchiveDeserializer.readResourceInfoS(bufferReader);

        return new SoundBossBgm(EnemyId, EnemyName, BgmNo, SrqrId);
    }


    @Override
    protected SoundBossBgmList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new SoundBossBgmList(bufferReader.readArray(SoundBossBgmDeserializer::readSoundBossBgm, lookupUtil));
    }
}
