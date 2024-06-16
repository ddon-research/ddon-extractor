package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.LayoutPreset;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.LayoutPresetList;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LayoutPresetDeserializer extends ClientResourceFileDeserializer<LayoutPresetList> {
    private static LayoutPreset readLayoutPreset(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int presetNo) {
        int PresetKind = presetNo;
        String Keyword = bufferReader.readNullTerminatedString();
        long CtrlType = bufferReader.readUnsignedInteger();
        long EnemyId = bufferReader.readUnsignedInteger();
        Translation EnemyName = null;
        if (lookupUtil != null) {
            EnemyName = lookupUtil.getEnemyName(EnemyId);
        }

        return new LayoutPreset(PresetKind, Keyword, CtrlType, EnemyId, EnemyName);
    }

    @Override
    protected LayoutPresetList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        int arraySize = (int) bufferReader.readUnsignedInteger();
        List<LayoutPreset> presets = new ArrayList<>(arraySize);
        for (int i = 0; i < arraySize; i++) {
            presets.add(readLayoutPreset(bufferReader, lookupUtil, i));
        }
        return new LayoutPresetList(presets);
    }
}
