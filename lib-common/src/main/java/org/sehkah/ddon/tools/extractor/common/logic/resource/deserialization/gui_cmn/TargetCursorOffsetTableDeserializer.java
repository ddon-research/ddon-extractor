package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound.TargetCursorOffset;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound.TargetCursorOffsetTable;

import java.nio.file.Path;

public class TargetCursorOffsetTableDeserializer extends ClientResourceFileDeserializer<TargetCursorOffsetTable> {

    private static TargetCursorOffset readTargetCursorOffset(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long EmId = bufferReader.readUnsignedInteger();
        Translation EnemyName = null;
        if (lookupUtil != null) {
            EnemyName = lookupUtil.getEnemyName(Long.parseLong(String.valueOf(EmId), 16));
        }
        int JointNo = bufferReader.readSignedInteger();
        Vector3f OffsetFromJoint = bufferReader.readVector3f();

        return new TargetCursorOffset(EmId, EnemyName, JointNo, OffsetFromJoint);
    }

    @Override
    protected TargetCursorOffsetTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new TargetCursorOffsetTable(bufferReader.readArray(TargetCursorOffsetTableDeserializer::readTargetCursorOffset, lookupUtil));
    }
}
