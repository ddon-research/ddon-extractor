package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.camera;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.camera.LargeCameraParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.camera.LargeCameraParamTable;

import java.nio.file.Path;

public class LargeCameraParamTableDeserializer extends ClientResourceFileDeserializer<LargeCameraParamTable> {
    private static LargeCameraParam readLargeCameraParam(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long EmId = bufferReader.readUnsignedInteger();
        Translation EnemyName = null;
        if (lookupUtil != null) {
            EnemyName = lookupUtil.getEnemyName(EmId);
        }
        float Range1 = bufferReader.readFloat();
        float Range2 = bufferReader.readFloat();
        long Camera = bufferReader.readUnsignedInteger();
        boolean Group = bufferReader.readBoolean();

        return new LargeCameraParam(EmId, EnemyName, Range1, Range2, Camera, Group);
    }

    @Override
    protected LargeCameraParamTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new LargeCameraParamTable(bufferReader.readArray(LargeCameraParamTableDeserializer::readLargeCameraParam, lookupUtil));
    }
}
