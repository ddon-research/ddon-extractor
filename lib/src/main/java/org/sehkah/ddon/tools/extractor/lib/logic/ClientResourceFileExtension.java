package org.sehkah.ddon.tools.extractor.lib.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum ClientResourceFileExtension {
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

    private static final Map<String, ClientResourceFileExtension> fileExtensionMap = new HashMap<>(ClientResourceFileExtension.values().length);

    static {
        fileExtensionMap.put(".aad", rAbilityAddData);
        fileExtensionMap.put(".abd", rAbilityData);
        fileExtensionMap.put(".abl", rAbilityList);
        fileExtensionMap.put(".ach", rAchievementHeader);
        fileExtensionMap.put(".acv", rAchievement);
        fileExtensionMap.put(".ajp", rAdjustParam);
        fileExtensionMap.put(".aml", rAnimalData);
        fileExtensionMap.put(".amr", rAreaMasterRankData);
        fileExtensionMap.put(".ams", rAreaMasterSpotData);
        fileExtensionMap.put(".amsd", rAreaMasterSpotDetailData);
        fileExtensionMap.put(".ari", rAreaInfo);
        fileExtensionMap.put(".arj", rAreaInfoJointArea);
        fileExtensionMap.put(".ars", rAreaInfoStage);
        fileExtensionMap.put(".ccp", rCraftCapPass);
        fileExtensionMap.put(".cee", rCraftElementExp);
        fileExtensionMap.put(".ckc", rCraftSkillCost);
        fileExtensionMap.put(".cks", rCraftSkillSpd);
        fileExtensionMap.put(".cqi", rCycleQuestInfo);
        fileExtensionMap.put(".cqr", rCraftQuality);
        fileExtensionMap.put(".csd", rCustomSkillData);
        fileExtensionMap.put(".cuex", rCraftUpGradeExp);
        fileExtensionMap.put(".dgm", rGUIDogmaOrb);
        fileExtensionMap.put(".dtt", rEmDmgTimerTbl);
        fileExtensionMap.put(".ebi_sv", rEmBaseInfoSv);
        fileExtensionMap.put(".edv", rEmDamageDirInfo);
        fileExtensionMap.put(".emg", rEnemyGroup);
        fileExtensionMap.put(".equip_preset", rEquipPreset);
        fileExtensionMap.put(".evl", rEvaluationTable);
        fileExtensionMap.put(".evp", rEventParam);
        fileExtensionMap.put(".exp", rPlayerExpTable);
        fileExtensionMap.put(".faa", rFieldAreaAdjoinList);
        fileExtensionMap.put(".fal", rFieldAreaList);
        fileExtensionMap.put(".fmd", rFieldMapData);
        fileExtensionMap.put(".fmi", rFieldAreaMarkerInfo);
        fileExtensionMap.put(".fnd", rFurnitureData);
        fileExtensionMap.put(".fng", rFurnitureGroup);
        fileExtensionMap.put(".fni", rFurnitureItem);
        fileExtensionMap.put(".fnl", rFurnitureLayout);
        fileExtensionMap.put(".gat", rGatheringItem);
        fileExtensionMap.put(".gmd", rGUIMessage);
        fileExtensionMap.put(".hmcs", rHumanEnemyCustomSkill);
        fileExtensionMap.put(".hmeq", rHumanEnemyEquip);
        fileExtensionMap.put(".ipa", rItemList);
        fileExtensionMap.put(".jlt2", rJobLevelUpTbl2);
        fileExtensionMap.put(".jmc", rJobMasterCtrl);
        fileExtensionMap.put(".jobbase", rJobBaseParam);
        fileExtensionMap.put(".jtq", rJobTutorialQuestList);
        fileExtensionMap.put(".kctt", rKeyConfigTextTable);
        fileExtensionMap.put(".lai", rLandInfo);
        fileExtensionMap.put(".lcd", rLocationData);
        fileExtensionMap.put(".lop", rLayoutPreset);
        fileExtensionMap.put(".lup", rEmLvUpParam);
        fileExtensionMap.put(".msd", rMapSpotData);
        fileExtensionMap.put(".msl", rMapSpotStageList);
        fileExtensionMap.put(".mss", rMsgSet);
        fileExtensionMap.put(".nci", rNpcConstItem);
        fileExtensionMap.put(".ndp", rNamedParam);
        fileExtensionMap.put(".nmp", rNpcMeetingPlace);
        fileExtensionMap.put(".nsd", rNormalSkillData);
        fileExtensionMap.put(".paw", rAIPawnAutoWordTbl);
        fileExtensionMap.put(".phs", rPrologueHmStatus);
        fileExtensionMap.put(".pqt", rPawnQuestTalk);
        fileExtensionMap.put(".psi", rPlPartsInfo);
        fileExtensionMap.put(".qhd", rQuestHistoryData);
        fileExtensionMap.put(".qmi", rQuestMarkerInfo);
        fileExtensionMap.put(".qsq", rQuestSequenceList);
        fileExtensionMap.put(".qtd", rQuestTextData);
        fileExtensionMap.put(".rag", rRageTable);
        fileExtensionMap.put(".sal", rStageAdjoinList);
        fileExtensionMap.put(".sbv", rShrinkBlowValue);
        fileExtensionMap.put(".sdt", rStaminaDecTbl);
        fileExtensionMap.put(".sg_tbl", rStatusGainTable);
        fileExtensionMap.put(".slt", rStageList);
        fileExtensionMap.put(".smc", rSituationMsgCtrl);
        fileExtensionMap.put(".smp", rStageMap);
        fileExtensionMap.put(".spg_tbl", rShopGoods);
        fileExtensionMap.put(".sta", rStartPosArea);
        fileExtensionMap.put(".sts", rStageToSpot);
        fileExtensionMap.put(".tcm", rTbl2ChatMacro);
        fileExtensionMap.put(".tdm", rTutorialDialogMessage);
        fileExtensionMap.put(".tlt", rTutorialList);
        fileExtensionMap.put(".tqg", rTutorialQuestGroup);
        fileExtensionMap.put(".wal", rWarpLocation);
    }

    public static ClientResourceFileExtension of(String fileExtension) {
        return fileExtensionMap.get(fileExtension);
    }

    public static Set<String> getSupportedFileExtensions() {
        return fileExtensionMap.keySet();
    }
}
