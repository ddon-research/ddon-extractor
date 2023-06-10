package org.sehkah.ddon.tools.extractor.lib.logic;

import org.sehkah.ddon.tools.extractor.lib.common.crypto.CrcUtil;

import java.util.*;

public enum ClientResourceFileExtension {
    rArchive,
    rAIPawnAutoWordTbl,
    rAbilityAddData,
    rAbilityData,
    rAbilityList,
    rAchievement,
    rAchievementHeader,
    rAdjustParam,
    rAnimalData,
    rAreaInfo,
    rAreaInfoJointArea,
    rAreaInfoStage,
    rAreaMasterRankData,
    rAreaMasterSpotData,
    rAreaMasterSpotDetailData,
    rCraftCapPass,
    rCraftElementExp,
    rCraftQuality,
    rCraftSkillCost,
    rCraftSkillSpd,
    rCraftUpGradeExp,
    rCustomSkillData,
    rCycleQuestInfo,
    rEmBaseInfoSv,
    rEmDamageDirInfo,
    rEmDmgTimerTbl,
    rEmLvUpParam,
    rEnemyGroup,
    rEquipPreset,
    rEvaluationTable,
    rEventParam,
    rFieldAreaAdjoinList,
    rFieldAreaList,
    rFieldAreaMarkerInfo,
    rFieldMapData,
    rFurnitureData,
    rFurnitureGroup,
    rFurnitureItem,
    rFurnitureLayout,
    rGUIDogmaOrb,
    rGUIMessage,
    rGatheringItem,
    rHumanEnemyCustomSkill,
    rHumanEnemyEquip,
    rItemList,
    rJobBaseParam,
    rJobLevelUpTbl2,
    rJobMasterCtrl,
    rJobTutorialQuestList,
    rKeyConfigTextTable,
    rLandInfo,
    rLayoutPreset,
    rLocationData,
    rMapSpotData,
    rMapSpotStageList,
    rMsgSet,
    rNamedParam,
    rNormalSkillData,
    rNpcConstItem,
    rNpcMeetingPlace,
    rPawnQuestTalk,
    rPlPartsInfo,
    rPlayerExpTable,
    rPrologueHmStatus,
    rQuestHistoryData,
    rQuestMarkerInfo,
    rQuestSequenceList,
    rQuestTextData,
    rRageTable,
    rShopGoods,
    rShrinkBlowValue,
    rSituationMsgCtrl,
    rStageAdjoinList,
    rStageList,
    rStageMap,
    rStageToSpot,
    rStaminaDecTbl,
    rStartPosArea,
    rStatusGainTable,
    rTbl2ChatMacro,
    rTutorialDialogMessage,
    rTutorialList,
    rTutorialQuestGroup,
    rWarpLocation;

    private static final Map<Long, ClientResourceFileExtension> jamCrcTable = new HashMap<>(128);

    private static final Map<String, ClientResourceFileExtension> fileExtensionResourceMap = new HashMap<>(ClientResourceFileExtension.values().length);

    private static final Map<ClientResourceFileExtension, String> fileExtensionMap = new EnumMap<>(ClientResourceFileExtension.class);

    static {
        fileExtensionResourceMap.put(".arc", rArchive);
        fileExtensionResourceMap.put(".aad", rAbilityAddData);
        fileExtensionResourceMap.put(".abd", rAbilityData);
        fileExtensionResourceMap.put(".abl", rAbilityList);
        fileExtensionResourceMap.put(".ach", rAchievementHeader);
        fileExtensionResourceMap.put(".acv", rAchievement);
        fileExtensionResourceMap.put(".ajp", rAdjustParam);
        fileExtensionResourceMap.put(".aml", rAnimalData);
        fileExtensionResourceMap.put(".amr", rAreaMasterRankData);
        fileExtensionResourceMap.put(".ams", rAreaMasterSpotData);
        fileExtensionResourceMap.put(".amsd", rAreaMasterSpotDetailData);
        fileExtensionResourceMap.put(".ari", rAreaInfo);
        fileExtensionResourceMap.put(".arj", rAreaInfoJointArea);
        fileExtensionResourceMap.put(".ars", rAreaInfoStage);
        fileExtensionResourceMap.put(".ccp", rCraftCapPass);
        fileExtensionResourceMap.put(".cee", rCraftElementExp);
        fileExtensionResourceMap.put(".ckc", rCraftSkillCost);
        fileExtensionResourceMap.put(".cks", rCraftSkillSpd);
        fileExtensionResourceMap.put(".cqi", rCycleQuestInfo);
        fileExtensionResourceMap.put(".cqr", rCraftQuality);
        fileExtensionResourceMap.put(".csd", rCustomSkillData);
        fileExtensionResourceMap.put(".cuex", rCraftUpGradeExp);
        fileExtensionResourceMap.put(".dgm", rGUIDogmaOrb);
        fileExtensionResourceMap.put(".dtt", rEmDmgTimerTbl);
        fileExtensionResourceMap.put(".ebi_sv", rEmBaseInfoSv);
        fileExtensionResourceMap.put(".edv", rEmDamageDirInfo);
        fileExtensionResourceMap.put(".emg", rEnemyGroup);
        fileExtensionResourceMap.put(".equip_preset", rEquipPreset);
        fileExtensionResourceMap.put(".evl", rEvaluationTable);
        fileExtensionResourceMap.put(".evp", rEventParam);
        fileExtensionResourceMap.put(".exp", rPlayerExpTable);
        fileExtensionResourceMap.put(".faa", rFieldAreaAdjoinList);
        fileExtensionResourceMap.put(".fal", rFieldAreaList);
        fileExtensionResourceMap.put(".fmd", rFieldMapData);
        fileExtensionResourceMap.put(".fmi", rFieldAreaMarkerInfo);
        fileExtensionResourceMap.put(".fnd", rFurnitureData);
        fileExtensionResourceMap.put(".fng", rFurnitureGroup);
        fileExtensionResourceMap.put(".fni", rFurnitureItem);
        fileExtensionResourceMap.put(".fnl", rFurnitureLayout);
        fileExtensionResourceMap.put(".gat", rGatheringItem);
        fileExtensionResourceMap.put(".gmd", rGUIMessage);
        fileExtensionResourceMap.put(".hmcs", rHumanEnemyCustomSkill);
        fileExtensionResourceMap.put(".hmeq", rHumanEnemyEquip);
        fileExtensionResourceMap.put(".ipa", rItemList);
        fileExtensionResourceMap.put(".jlt2", rJobLevelUpTbl2);
        fileExtensionResourceMap.put(".jmc", rJobMasterCtrl);
        fileExtensionResourceMap.put(".jobbase", rJobBaseParam);
        fileExtensionResourceMap.put(".jtq", rJobTutorialQuestList);
        fileExtensionResourceMap.put(".kctt", rKeyConfigTextTable);
        fileExtensionResourceMap.put(".lai", rLandInfo);
        fileExtensionResourceMap.put(".lcd", rLocationData);
        fileExtensionResourceMap.put(".lop", rLayoutPreset);
        fileExtensionResourceMap.put(".lup", rEmLvUpParam);
        fileExtensionResourceMap.put(".msd", rMapSpotData);
        fileExtensionResourceMap.put(".msl", rMapSpotStageList);
        fileExtensionResourceMap.put(".mss", rMsgSet);
        fileExtensionResourceMap.put(".nci", rNpcConstItem);
        fileExtensionResourceMap.put(".ndp", rNamedParam);
        fileExtensionResourceMap.put(".nmp", rNpcMeetingPlace);
        fileExtensionResourceMap.put(".nsd", rNormalSkillData);
        fileExtensionResourceMap.put(".paw", rAIPawnAutoWordTbl);
        fileExtensionResourceMap.put(".phs", rPrologueHmStatus);
        fileExtensionResourceMap.put(".pqt", rPawnQuestTalk);
        fileExtensionResourceMap.put(".psi", rPlPartsInfo);
        fileExtensionResourceMap.put(".qhd", rQuestHistoryData);
        fileExtensionResourceMap.put(".qmi", rQuestMarkerInfo);
        fileExtensionResourceMap.put(".qsq", rQuestSequenceList);
        fileExtensionResourceMap.put(".qtd", rQuestTextData);
        fileExtensionResourceMap.put(".rag", rRageTable);
        fileExtensionResourceMap.put(".sal", rStageAdjoinList);
        fileExtensionResourceMap.put(".sbv", rShrinkBlowValue);
        fileExtensionResourceMap.put(".sdt", rStaminaDecTbl);
        fileExtensionResourceMap.put(".sg_tbl", rStatusGainTable);
        fileExtensionResourceMap.put(".slt", rStageList);
        fileExtensionResourceMap.put(".smc", rSituationMsgCtrl);
        fileExtensionResourceMap.put(".smp", rStageMap);
        fileExtensionResourceMap.put(".spg_tbl", rShopGoods);
        fileExtensionResourceMap.put(".sta", rStartPosArea);
        fileExtensionResourceMap.put(".sts", rStageToSpot);
        fileExtensionResourceMap.put(".tcm", rTbl2ChatMacro);
        fileExtensionResourceMap.put(".tdm", rTutorialDialogMessage);
        fileExtensionResourceMap.put(".tlt", rTutorialList);
        fileExtensionResourceMap.put(".tqg", rTutorialQuestGroup);
        fileExtensionResourceMap.put(".wal", rWarpLocation);

        Arrays.stream(ClientResourceFileExtension.values()).forEach(e -> jamCrcTable.put(CrcUtil.jamCrc32(e.name().getBytes()), e));
        Arrays.stream(ClientResourceFileExtension.values()).forEach(e -> {
            for (Map.Entry<String, ClientResourceFileExtension> stringClientResourceFileExtensionEntry : fileExtensionResourceMap.entrySet()) {
                if (stringClientResourceFileExtensionEntry.getValue() == e) {
                    fileExtensionMap.put(e, stringClientResourceFileExtensionEntry.getKey());
                }
            }
        });
    }

    public static ClientResourceFileExtension of(String fileExtension) {
        return fileExtensionResourceMap.get(fileExtension);
    }

    public static String getFileExtensions(ClientResourceFileExtension resource) {
        return fileExtensionMap.get(resource);
    }

    public static Set<String> getSupportedFileExtensions() {
        return fileExtensionResourceMap.keySet();
    }

    // TODO: Replace with a more complete table by referencing all known class names in a separate enum
    public static ClientResourceFileExtension getClientResourceFileExtensionByCrc(long crc) {
        return jamCrcTable.get(crc);
    }
}
