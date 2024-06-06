package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.gui_cmn.AbilityData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.gui_cmn.AbilityDataList;

public class AbilityDataDeserializer extends ClientResourceFileDeserializer<AbilityDataList> {


    private static AbilityData readAbilityData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int Id = bufferReader.readUnsignedShort();
        int MsgNameIndex = bufferReader.readUnsignedShort();
        int MsgExpIndex = bufferReader.readUnsignedShort();
        String AbilityName = null;
        String AbilityInfo = null;
        if (lookupUtil != null) {
            AbilityName = lookupUtil.getMessage(ResourceFileLookupType.ABILITY_NAME.getFilePath(), MsgNameIndex);
            AbilityInfo = lookupUtil.getMessage(ResourceFileLookupType.ABILITY_INFO.getFilePath(), MsgExpIndex);

        }
        int IconId = bufferReader.readUnsignedShort();
        int Cost = bufferReader.readUnsignedShort();
        int SortNo = bufferReader.readUnsignedShort();
        boolean IsPawnDisable = bufferReader.readBoolean();

        return new AbilityData(Id, MsgNameIndex, AbilityName, MsgExpIndex, AbilityInfo, IconId, Cost, SortNo, IsPawnDisable);
    }

    @Override
    protected AbilityDataList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AbilityDataList(bufferReader.readArray(AbilityDataDeserializer::readAbilityData, lookupUtil));
    }
}
