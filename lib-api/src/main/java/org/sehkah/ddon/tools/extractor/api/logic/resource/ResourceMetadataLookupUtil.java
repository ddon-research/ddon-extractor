package org.sehkah.ddon.tools.extractor.api.logic.resource;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ResourceCache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class ResourceMetadataLookupUtil {
    protected final ResourceCache cache;
    private final Map<String, Map<Integer, GMDTranslation>> translationMap;

    protected ResourceMetadataLookupUtil(Path clientRootFolder, Path clientTranslationFile) {
        cache = new ResourceCache(clientRootFolder);
        translationMap = loadTranslationMap(clientTranslationFile);
    }

    private static List<GMDTranslation> loadTranslation(Path filePath) {
        GMDTranslationSerializer translationSerializer = GMDTranslationSerializer.get();
        try {
            String gmdTranslationContent = Files.readString(filePath);
            return translationSerializer.deserialize(gmdTranslationContent);
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }

    private Map<String, Map<Integer, GMDTranslation>> loadTranslationMap(Path filePath) {
        List<GMDTranslation> deserialized = loadTranslation(filePath);
        Map<String, Map<Integer, GMDTranslation>> result = HashMap.newHashMap(6000);
        deserialized.forEach(gmdTranslation -> {
            String gmdFilePath = (gmdTranslation.getArcPath().substring(1).replace(".arc", "") + '/' + gmdTranslation.getGmdPath()).replace('\\', '/');
            Map<Integer, GMDTranslation> gmdIndexTranslationMap = result.getOrDefault(gmdFilePath, HashMap.newHashMap(21504));
            gmdIndexTranslationMap.put(gmdTranslation.getReadIndex(), gmdTranslation);
            result.putIfAbsent(gmdFilePath, gmdIndexTranslationMap);
        });
        return result;
    }

    public Translation getMessageTranslation(String gmdFilePath, int msgGmdIdx) {
        Map<Integer, GMDTranslation> gmdTranslationMap = translationMap.get(gmdFilePath);
        if (gmdTranslationMap == null) {
            log.warn("Missing translation file for {}.", gmdFilePath);
            return null;
        } else {
            GMDTranslation messageTranslation = gmdTranslationMap.get(msgGmdIdx);
            if (messageTranslation == null) {
                log.warn("Missing translation for ID {} in file {}.", msgGmdIdx, gmdFilePath);
                return null;
            }
            return new Translation(messageTranslation.getMsgJp(), messageTranslation.getMsgEn());
        }
    }

    public Translation getMessageTranslation(String gmdFilePath, String key) {
        Map<Integer, GMDTranslation> gmdTranslationMap = translationMap.get(gmdFilePath);
        if (gmdTranslationMap == null) {
            log.warn("Missing translation file for {}.", gmdFilePath);
            return null;
        } else {
            Collection<GMDTranslation> values = gmdTranslationMap.values();
            for (GMDTranslation value : values) {
                if (value.getKey().equals(key)) {
                    return new Translation(value.getMsgJp(), value.getMsgEn());
                }
            }
            log.warn("Missing translation for key {} in file {}.", key, gmdFilePath);
            return null;
        }
    }

    public String getMessageTranslationKey(String gmdFilePath, int msgGmdIdx) {
        Map<Integer, GMDTranslation> gmdTranslationMap = translationMap.get(gmdFilePath);
        if (gmdTranslationMap == null) {
            log.warn("Missing translation file for {}.", gmdFilePath);
            return null;
        } else {
            GMDTranslation messageTranslation = gmdTranslationMap.get(msgGmdIdx);
            return messageTranslation.getKey();
        }
    }

    public abstract Translation getMsgGroupTranslation(String msgSetFilePath, long msgGroupSerial);

    public abstract Translation getMsgGroupMessageTranslation(String msgSetFilePath, int msgSerial);

    public abstract Translation getNpcName(long npcId);

    public abstract Translation getStageNameByStageNo(int stageNo);

    public abstract Translation getStageNameByStageId(int stageId);

    public abstract Translation getItemName(long itemId);

    /**
     * Caller must convert from hex to decimal if necessary.
     *
     * @param enemyId decimal radix
     */
    public abstract Translation getEnemyName(long enemyId);

    public abstract Translation getEnemyGroupName(long enemyGroupId);

    public Translation getNamedEnemyName(long namedParamId) {
        return getMessageTranslation(GUIMessageLookupTable.NAMED_PARAM.getFilePath(), "namedparam_" + namedParamId);
    }

    public Translation getQuestName(long questId) {
        String questIdStr = String.format("q%08d", questId);
        String gmdFilePath = String.format("quest/%1$s/ui/00_message/quest_info/%1$s_00.gmd", questIdStr);
        return getMessageTranslation(gmdFilePath, 0);
    }

    public Translation getJobName(int jobId) {
        return getMessageTranslation(GUIMessageLookupTable.JOB_NAME.getFilePath(), jobId);
    }

    public Translation getAreaName(int areaId) {
        return getMessageTranslation(GUIMessageLookupTable.AREA_LIST.getFilePath(), "AREA_NAME_" + areaId);
    }

    public Translation getSpotName(long spotId) {
        return getMessageTranslation(GUIMessageLookupTable.SPOT_NAME.getFilePath(), "SPOT_NAME_" + spotId);
    }

    public Translation getLandName(int landId) {
        return getMessageTranslation(GUIMessageLookupTable.LAND_NAME.getFilePath(), landId - 1);
    }

    public Translation getSkillName(int jobId, int skillNo) {
        Translation translation = null;

        String normalSkillFilePath = String.format("ui/gui_cmn/ui/00_message/skill/normal_skill_name_%02d.gmd", jobId);
        translation = getMessageTranslation(normalSkillFilePath, String.format("NORMAL_SKILL_NAME_%02d_%d", jobId, skillNo));
        if (translation != null) {
            return translation;
        }

        String customSkillFilePath = String.format("ui/gui_cmn/ui/00_message/skill/custom_skill_name_%02d.gmd", jobId);
        translation = getMessageTranslation(customSkillFilePath, String.format("CUSTOM_SKILL_NAME_%02d_%d", jobId, skillNo));

        return translation;
    }

    public Translation getAbilityName(int abilityNo) {
        return getMessageTranslation(GUIMessageLookupTable.ABILITY_NAME.getFilePath(), "ABILITY_NAME_" + abilityNo);
    }

    /**
     * Looks up am_spot_(01).ams via area(1)_spot_info.gmd
     */
    public Translation getSpotInfoMessage(Path sourcePath, int spotMessageId) {
        int sourceSpotId = Integer.valueOf(sourcePath.getFileName().toString().replace("am_spot_", "").replace(".ams", ""), 10);
        String gmdFilePath = String.format("ui/uGUIAreaMaster/ui/00_message/master/area%d_spot_info.gmd", sourceSpotId);
        return getMessageTranslation(gmdFilePath, spotMessageId);
    }

    public abstract long getAreaIdByStageNo(int stageNoMap);
}
