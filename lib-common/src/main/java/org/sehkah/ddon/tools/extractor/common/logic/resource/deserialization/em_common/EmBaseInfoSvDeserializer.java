package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.em_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common.EmBaseInfoSv;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common.EmBaseInfoSvList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common.meta.EnemyCategoryType;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EmBaseInfoSvDeserializer extends ClientResourceFileDeserializer<EmBaseInfoSvList> {
    private static EmBaseInfoSv readEmBaseInfoSv(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int num) {
        int EnemyNo = num;
        long EnemyID = bufferReader.readUnsignedInteger();
        Translation EnemyName = null;
        if (lookupUtil != null) {
            EnemyName = lookupUtil.getEnemyName(EnemyID);
        }
        long EmCategory = bufferReader.readUnsignedInteger();
        Set<EnemyCategoryType> EnemyCategoryNames = BitUtil.extractBitSetUnsignedIntegerFlag(EnemyCategoryType::of, EmCategory);

        return new EmBaseInfoSv(EnemyNo, EnemyID, EnemyName, EmCategory, EnemyCategoryNames);
    }

    @Override
    protected EmBaseInfoSvList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long length = bufferReader.readUnsignedInteger();
        List<EmBaseInfoSv> entities = new ArrayList<>((int) length);
        for (int i = 0; i < length; i++) {
            entities.add(readEmBaseInfoSv(bufferReader, lookupUtil, i));
        }
        return new EmBaseInfoSvList(entities);
    }
}
