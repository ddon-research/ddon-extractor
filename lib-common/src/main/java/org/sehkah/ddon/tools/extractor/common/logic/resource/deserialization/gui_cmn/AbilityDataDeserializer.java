package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.AbilityData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.AbilityDataList;

import java.nio.file.Path;

public class AbilityDataDeserializer extends ClientResourceFileDeserializer<AbilityDataList> {
    private static AbilityData readAbilityData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int Id = bufferReader.readUnsignedShort();
        int MsgNameIndex = bufferReader.readUnsignedShort();
        int MsgExpIndex = bufferReader.readUnsignedShort();
        Translation AbilityName = null;
        Translation AbilityInfo = null;
        if (lookupUtil != null) {
            AbilityName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ABILITY_NAME.getFilePath(), MsgNameIndex);
            AbilityInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ABILITY_INFO.getFilePath(), MsgExpIndex);
        }
        int IconId = bufferReader.readUnsignedShort();
        int Cost = bufferReader.readUnsignedShort();
        int SortNo = bufferReader.readUnsignedShort();
        boolean IsPawnDisable = bufferReader.readBoolean();

        return new AbilityData(Id, MsgNameIndex, AbilityName, MsgExpIndex, AbilityInfo, IconId, Cost, SortNo, IsPawnDisable);
    }

    @Override
    protected AbilityDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AbilityDataList(bufferReader.readArray(AbilityDataDeserializer::readAbilityData, lookupUtil));
    }
}
