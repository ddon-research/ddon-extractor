package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ui;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.AreaMasterRankData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.AreaMasterRankDataList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.meta.AreaMasterNpcId;

import java.nio.file.Path;
import java.util.regex.Pattern;

public class AreaMasterRankDataDeserializer extends ClientResourceFileDeserializer<AreaMasterRankDataList> {
    private static final Pattern rankAreaIdPattern = Pattern.compile("am_rank_(\\d+)\\.amr");

    private static AreaMasterRankData readAreaMasterRankData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int AreaId) {
        long MsgGroupSerial = bufferReader.readUnsignedInteger();
        long Point = bufferReader.readUnsignedInteger();
        int BonusType = bufferReader.readUnsignedByte();

        Translation Message = null;
        if (lookupUtil != null) {
            Message = lookupUtil.getMsgGroupTranslation(String.format("npc/n%1$04d/ui/00_message/npc/base/n%1$04d.mss", AreaMasterNpcId.of(AreaId).NpcId), MsgGroupSerial);
        }

        return new AreaMasterRankData(MsgGroupSerial, Message, Point, BonusType);
    }

    @Override
    protected AreaMasterRankDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        // ui/uGUIAreaMaster/ui/00_param/master/am_rank_01.amr
        int AreaId = Integer.valueOf(rankAreaIdPattern.matcher(filePath.getFileName().toString()).results().findFirst().get().group(1), 10);

        return new AreaMasterRankDataList(bufferReader.readArray(br -> readAreaMasterRankData(bufferReader, lookupUtil, AreaId)), AreaId);
    }
}
