package org.sehkah.ddon.tools.extractor.lib.logic;

import org.sehkah.ddon.tools.extractor.lib.common.crypto.CrcUtil;

import java.util.*;

public enum ClientResourceFileExtension {
    rArchive,
    rAISensor,
    rAIPawnAutoWordTbl,
    rAIPawnAutoMotionTbl,
    rAIPawnSkillParamTbl,
    rAIPawnEmParam,
    rAIPawnActNoSwitch,
    rAIPawnOrder,
    rAbilityAddData,
    rAbilityData,
    rAbilityList,
    rAchievement,
    rAchievementHeader,
    rAdjustParam,
    rAdjLimitParam,
    rAnimalData,
    rAreaInfo,
    rAreaInfoJointArea,
    rAreaInfoStage,
    rAreaMasterRankData,
    rAreaMasterSpotData,
    rAreaMasterSpotDetailData,
    rBakeJoint,
    rBitTable,
    rBlowSaveEmLvParam,
    rCalcDamageAtdmAdj,
    rCalcDamageAtdmAdjRate,
    rCalcDamageLvAdj,
    rCatchInfoParam,
    rCaughtDamageRateRefTbl,
    rCaughtDamageRateTbl,
    rCaughtInfoParam,
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

    private static final Map<Long, ClientResourceFileExtension> jamCrcToResourceMap = new HashMap<>(ClientResourceFileExtension.values().length);

    private static final Map<String, ClientResourceFileExtension> fileExtensionToResourceMap = new HashMap<>(ClientResourceFileExtension.values().length);

    private static final Map<ClientResourceFileExtension, String> resourceToFileExtensionMap = new EnumMap<>(ClientResourceFileExtension.class);

    static {
        fileExtensionToResourceMap.put(".arc", rArchive);
        fileExtensionToResourceMap.put(".aad", rAbilityAddData);
        fileExtensionToResourceMap.put(".abd", rAbilityData);
        fileExtensionToResourceMap.put(".abl", rAbilityList);
        fileExtensionToResourceMap.put(".ach", rAchievementHeader);
        fileExtensionToResourceMap.put(".acv", rAchievement);
        fileExtensionToResourceMap.put(".ajp", rAdjustParam);
        fileExtensionToResourceMap.put(".alp", rAdjLimitParam);
        fileExtensionToResourceMap.put(".aml", rAnimalData);
        fileExtensionToResourceMap.put(".amr", rAreaMasterRankData);
        fileExtensionToResourceMap.put(".ams", rAreaMasterSpotData);
        fileExtensionToResourceMap.put(".amsd", rAreaMasterSpotDetailData);
        fileExtensionToResourceMap.put(".ari", rAreaInfo);
        fileExtensionToResourceMap.put(".arj", rAreaInfoJointArea);
        fileExtensionToResourceMap.put(".ars", rAreaInfoStage);
        fileExtensionToResourceMap.put(".bjt", rBakeJoint);
        fileExtensionToResourceMap.put(".btb", rBitTable);
        fileExtensionToResourceMap.put(".blow_save", rBlowSaveEmLvParam);
        fileExtensionToResourceMap.put(".cda", rCalcDamageAtdmAdj);
        fileExtensionToResourceMap.put(".cdarate", rCalcDamageAtdmAdjRate);
        fileExtensionToResourceMap.put(".cdl", rCalcDamageLvAdj);
        fileExtensionToResourceMap.put(".caip", rCaughtInfoParam);
        fileExtensionToResourceMap.put(".cdrt", rCaughtDamageRateTbl);
        fileExtensionToResourceMap.put(".cdrr", rCaughtDamageRateRefTbl);
        fileExtensionToResourceMap.put(".cip", rCatchInfoParam);
        fileExtensionToResourceMap.put(".ccp", rCraftCapPass);
        fileExtensionToResourceMap.put(".cee", rCraftElementExp);
        fileExtensionToResourceMap.put(".ckc", rCraftSkillCost);
        fileExtensionToResourceMap.put(".cks", rCraftSkillSpd);
        fileExtensionToResourceMap.put(".cqi", rCycleQuestInfo);
        fileExtensionToResourceMap.put(".cqr", rCraftQuality);
        fileExtensionToResourceMap.put(".csd", rCustomSkillData);
        fileExtensionToResourceMap.put(".cuex", rCraftUpGradeExp);
        fileExtensionToResourceMap.put(".dgm", rGUIDogmaOrb);
        fileExtensionToResourceMap.put(".dtt", rEmDmgTimerTbl);
        fileExtensionToResourceMap.put(".ebi_sv", rEmBaseInfoSv);
        fileExtensionToResourceMap.put(".edv", rEmDamageDirInfo);
        fileExtensionToResourceMap.put(".emg", rEnemyGroup);
        fileExtensionToResourceMap.put(".equip_preset", rEquipPreset);
        fileExtensionToResourceMap.put(".evl", rEvaluationTable);
        fileExtensionToResourceMap.put(".evp", rEventParam);
        fileExtensionToResourceMap.put(".exp", rPlayerExpTable);
        fileExtensionToResourceMap.put(".faa", rFieldAreaAdjoinList);
        fileExtensionToResourceMap.put(".fal", rFieldAreaList);
        fileExtensionToResourceMap.put(".fmd", rFieldMapData);
        fileExtensionToResourceMap.put(".fmi", rFieldAreaMarkerInfo);
        fileExtensionToResourceMap.put(".fnd", rFurnitureData);
        fileExtensionToResourceMap.put(".fng", rFurnitureGroup);
        fileExtensionToResourceMap.put(".fni", rFurnitureItem);
        fileExtensionToResourceMap.put(".fnl", rFurnitureLayout);
        fileExtensionToResourceMap.put(".gat", rGatheringItem);
        fileExtensionToResourceMap.put(".gmd", rGUIMessage);
        fileExtensionToResourceMap.put(".hmcs", rHumanEnemyCustomSkill);
        fileExtensionToResourceMap.put(".hmeq", rHumanEnemyEquip);
        fileExtensionToResourceMap.put(".ipa", rItemList);
        fileExtensionToResourceMap.put(".jlt2", rJobLevelUpTbl2);
        fileExtensionToResourceMap.put(".jmc", rJobMasterCtrl);
        fileExtensionToResourceMap.put(".jobbase", rJobBaseParam);
        fileExtensionToResourceMap.put(".jtq", rJobTutorialQuestList);
        fileExtensionToResourceMap.put(".kctt", rKeyConfigTextTable);
        fileExtensionToResourceMap.put(".lai", rLandInfo);
        fileExtensionToResourceMap.put(".lcd", rLocationData);
        fileExtensionToResourceMap.put(".lop", rLayoutPreset);
        fileExtensionToResourceMap.put(".lup", rEmLvUpParam);
        fileExtensionToResourceMap.put(".msd", rMapSpotData);
        fileExtensionToResourceMap.put(".msl", rMapSpotStageList);
        fileExtensionToResourceMap.put(".mss", rMsgSet);
        fileExtensionToResourceMap.put(".nci", rNpcConstItem);
        fileExtensionToResourceMap.put(".ndp", rNamedParam);
        fileExtensionToResourceMap.put(".nmp", rNpcMeetingPlace);
        fileExtensionToResourceMap.put(".nsd", rNormalSkillData);
        fileExtensionToResourceMap.put(".sn2", rAISensor);
        fileExtensionToResourceMap.put(".paw", rAIPawnAutoWordTbl);
        fileExtensionToResourceMap.put(".pam", rAIPawnAutoMotionTbl);
        fileExtensionToResourceMap.put(".aps", rAIPawnSkillParamTbl);
        fileExtensionToResourceMap.put(".pas", rAIPawnActNoSwitch);
        fileExtensionToResourceMap.put(".pao", rAIPawnOrder);
        fileExtensionToResourceMap.put(".pep", rAIPawnEmParam);
        fileExtensionToResourceMap.put(".phs", rPrologueHmStatus);
        fileExtensionToResourceMap.put(".pqt", rPawnQuestTalk);
        fileExtensionToResourceMap.put(".psi", rPlPartsInfo);
        fileExtensionToResourceMap.put(".qhd", rQuestHistoryData);
        fileExtensionToResourceMap.put(".qmi", rQuestMarkerInfo);
        fileExtensionToResourceMap.put(".qsq", rQuestSequenceList);
        fileExtensionToResourceMap.put(".qtd", rQuestTextData);
        fileExtensionToResourceMap.put(".rag", rRageTable);
        fileExtensionToResourceMap.put(".sal", rStageAdjoinList);
        fileExtensionToResourceMap.put(".sbv", rShrinkBlowValue);
        fileExtensionToResourceMap.put(".sdt", rStaminaDecTbl);
        fileExtensionToResourceMap.put(".sg_tbl", rStatusGainTable);
        fileExtensionToResourceMap.put(".slt", rStageList);
        fileExtensionToResourceMap.put(".smc", rSituationMsgCtrl);
        fileExtensionToResourceMap.put(".smp", rStageMap);
        fileExtensionToResourceMap.put(".spg_tbl", rShopGoods);
        fileExtensionToResourceMap.put(".sta", rStartPosArea);
        fileExtensionToResourceMap.put(".sts", rStageToSpot);
        fileExtensionToResourceMap.put(".tcm", rTbl2ChatMacro);
        fileExtensionToResourceMap.put(".tdm", rTutorialDialogMessage);
        fileExtensionToResourceMap.put(".tlt", rTutorialList);
        fileExtensionToResourceMap.put(".tqg", rTutorialQuestGroup);
        fileExtensionToResourceMap.put(".wal", rWarpLocation);

        fileExtensionToResourceMap.forEach((key, value) -> resourceToFileExtensionMap.put(value, key));

        Arrays.stream(ClientResourceFileExtension.values()).forEach(e -> jamCrcToResourceMap.put(CrcUtil.jamCrc32(e.name().getBytes()), e));
    }

    public static ClientResourceFileExtension of(String fileExtension) {
        return fileExtensionToResourceMap.get(fileExtension);
    }

    public static String getFileExtensions(ClientResourceFileExtension resource) {
        return resourceToFileExtensionMap.get(resource);
    }

    public static Set<String> getSupportedFileExtensions() {
        return fileExtensionToResourceMap.keySet();
    }
}
