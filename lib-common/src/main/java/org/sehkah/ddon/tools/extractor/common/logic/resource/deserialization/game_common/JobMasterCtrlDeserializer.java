package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.JobMasterCtrl;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.JobMasterCtrlList;

import java.nio.file.Path;

public class JobMasterCtrlDeserializer extends ClientResourceFileDeserializer<JobMasterCtrlList> {
    private static JobMasterCtrl readJobMasterCtrl(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long JobId = bufferReader.readUnsignedInteger();
        long StartJobLevel = bufferReader.readUnsignedInteger();
        long FirstTalkGrpSerial = bufferReader.readUnsignedInteger();
        long TraningTalkGrpSerial = bufferReader.readUnsignedInteger();
        long FirstOrderTalkGrpSerial = bufferReader.readUnsignedInteger();
        long JobTutorialQuestId = bufferReader.readUnsignedInteger();
        long JobMasterTutorialQuestId = bufferReader.readUnsignedInteger();
        long AreaId = bufferReader.readUnsignedInteger();
        long AreaRank = bufferReader.readUnsignedInteger();
        Translation JobName = null;
        Translation JobTutorialQuestName = null;
        Translation JobMasterTutorialQuestName = null;
        Translation AreaName = null;
        if (lookupUtil != null) {
            JobName = lookupUtil.getJobName((int) JobId);
            JobTutorialQuestName = lookupUtil.getQuestName((int) JobTutorialQuestId);
            JobMasterTutorialQuestName = lookupUtil.getQuestName((int) JobMasterTutorialQuestId);
            AreaName = lookupUtil.getAreaName((int) AreaId);
        }

        return new JobMasterCtrl(JobId, JobName, StartJobLevel, FirstTalkGrpSerial, TraningTalkGrpSerial, FirstOrderTalkGrpSerial, JobTutorialQuestId, JobTutorialQuestName, JobMasterTutorialQuestId, JobMasterTutorialQuestName, AreaId, AreaName, AreaRank);
    }

    @Override
    protected JobMasterCtrlList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new JobMasterCtrlList(bufferReader.readArray(JobMasterCtrlDeserializer::readJobMasterCtrl, lookupUtil));
    }
}
