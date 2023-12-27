package org.sehkah.ddon.tools.extractor.lib.logic;

import java.util.*;

public enum ClientResourceFileExtension {
    rAIPawnActNoSwitch,
    rAIPawnAutoMotionTbl,
    rAIPawnAutoWordTbl,
    rAIPawnEmParam,
    rAIPawnOrder,
    rAIPawnSkillParamTbl,
    rAISensor,
    rAbilityAddData,
    rAbilityData,
    rAbilityList,
    rAchievement,
    rAchievementHeader,
    rAdjLimitParam,
    rAdjustParam,
    rAnimalData,
    rArchive,
    rArchiveListArray,
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
    rDungeonMarker,
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
    rMyRoomActParam,
    rNamedParam,
    rNormalSkillData,
    rNpcConstItem,
    rNpcLedgerList,
    rNpcMeetingPlace,
    rPartnerPawnTalk,
    rPartnerReactParam,
    rPawnQuestTalk,
    rPlPartsInfo,
    rPlayerExpTable,
    rPrologueHmStatus,
    rQuestHistoryData,
    rQuestMarkerInfo,
    rQuestSequenceList,
    rQuestTextData,
    rRageTable,
    rReplaceWardGmdList,
    rRoomWearParam,
    rShopGoods,
    rShotReqInfo,
    rShotReqInfo2,
    rShrinkBlowValue,
    rSituationMsgCtrl,
    rStageAdjoinList,
    rStageJoint,
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
    rWarpLocation,
    rWaypoint,
    rWaypoint2,
    rWeaponOffset,
    rWeaponResTable,
    rWepCateResTbl;

    private static final Map<Long, ClientResourceFileExtension> jamCrcToResourceMap = HashMap.newHashMap(ClientResourceFileExtension.values().length);

    private static final Map<String, ClientResourceFileExtension> fileExtensionToResourceMap = HashMap.newHashMap(ClientResourceFileExtension.values().length);

    private static final Map<ClientResourceFileExtension, String> resourceToFileExtensionMap = new EnumMap<>(ClientResourceFileExtension.class);

    static {
        fileExtensionToResourceMap.put(".aad", rAbilityAddData);
        fileExtensionToResourceMap.put(".abd", rAbilityData);
        fileExtensionToResourceMap.put(".abl", rAbilityList);
        fileExtensionToResourceMap.put(".ach", rAchievementHeader);
        fileExtensionToResourceMap.put(".acv", rAchievement);
        fileExtensionToResourceMap.put(".ajp", rAdjustParam);
        fileExtensionToResourceMap.put(".ala", rArchiveListArray);
        fileExtensionToResourceMap.put(".alp", rAdjLimitParam);
        fileExtensionToResourceMap.put(".aml", rAnimalData);
        fileExtensionToResourceMap.put(".amr", rAreaMasterRankData);
        fileExtensionToResourceMap.put(".ams", rAreaMasterSpotData);
        fileExtensionToResourceMap.put(".amsd", rAreaMasterSpotDetailData);
        fileExtensionToResourceMap.put(".aps", rAIPawnSkillParamTbl);
        fileExtensionToResourceMap.put(".arc", rArchive);
        fileExtensionToResourceMap.put(".ari", rAreaInfo);
        fileExtensionToResourceMap.put(".arj", rAreaInfoJointArea);
        fileExtensionToResourceMap.put(".ars", rAreaInfoStage);
        fileExtensionToResourceMap.put(".bjt", rBakeJoint);
        fileExtensionToResourceMap.put(".blow_save", rBlowSaveEmLvParam);
        fileExtensionToResourceMap.put(".btb", rBitTable);
        fileExtensionToResourceMap.put(".caip", rCaughtInfoParam);
        fileExtensionToResourceMap.put(".ccp", rCraftCapPass);
        fileExtensionToResourceMap.put(".cda", rCalcDamageAtdmAdj);
        fileExtensionToResourceMap.put(".cdarate", rCalcDamageAtdmAdjRate);
        fileExtensionToResourceMap.put(".cdl", rCalcDamageLvAdj);
        fileExtensionToResourceMap.put(".cdrr", rCaughtDamageRateRefTbl);
        fileExtensionToResourceMap.put(".cdrt", rCaughtDamageRateTbl);
        fileExtensionToResourceMap.put(".cee", rCraftElementExp);
        fileExtensionToResourceMap.put(".cip", rCatchInfoParam);
        fileExtensionToResourceMap.put(".ckc", rCraftSkillCost);
        fileExtensionToResourceMap.put(".cks", rCraftSkillSpd);
        fileExtensionToResourceMap.put(".cqi", rCycleQuestInfo);
        fileExtensionToResourceMap.put(".cqr", rCraftQuality);
        fileExtensionToResourceMap.put(".csd", rCustomSkillData);
        fileExtensionToResourceMap.put(".cuex", rCraftUpGradeExp);
        fileExtensionToResourceMap.put(".dmi", rDungeonMarker);
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
        fileExtensionToResourceMap.put(".mra", rMyRoomActParam);
        fileExtensionToResourceMap.put(".msl", rMapSpotStageList);
        fileExtensionToResourceMap.put(".mss", rMsgSet);
        fileExtensionToResourceMap.put(".nci", rNpcConstItem);
        fileExtensionToResourceMap.put(".nll", rNpcLedgerList);
        fileExtensionToResourceMap.put(".ndp", rNamedParam);
        fileExtensionToResourceMap.put(".nmp", rNpcMeetingPlace);
        fileExtensionToResourceMap.put(".nsd", rNormalSkillData);
        fileExtensionToResourceMap.put(".pam", rAIPawnAutoMotionTbl);
        fileExtensionToResourceMap.put(".pao", rAIPawnOrder);
        fileExtensionToResourceMap.put(".pas", rAIPawnActNoSwitch);
        fileExtensionToResourceMap.put(".paw", rAIPawnAutoWordTbl);
        fileExtensionToResourceMap.put(".pep", rAIPawnEmParam);
        fileExtensionToResourceMap.put(".phs", rPrologueHmStatus);
        fileExtensionToResourceMap.put(".ppr", rPartnerReactParam);
        fileExtensionToResourceMap.put(".ppt", rPartnerPawnTalk);
        fileExtensionToResourceMap.put(".pqt", rPawnQuestTalk);
        fileExtensionToResourceMap.put(".psi", rPlPartsInfo);
        fileExtensionToResourceMap.put(".qhd", rQuestHistoryData);
        fileExtensionToResourceMap.put(".qmi", rQuestMarkerInfo);
        fileExtensionToResourceMap.put(".qsq", rQuestSequenceList);
        fileExtensionToResourceMap.put(".qtd", rQuestTextData);
        fileExtensionToResourceMap.put(".rag", rRageTable);
        fileExtensionToResourceMap.put(".repgmdlist", rReplaceWardGmdList);
        fileExtensionToResourceMap.put(".rwr", rRoomWearParam);
        fileExtensionToResourceMap.put(".sal", rStageAdjoinList);
        fileExtensionToResourceMap.put(".sbv", rShrinkBlowValue);
        fileExtensionToResourceMap.put(".sdt", rStaminaDecTbl);
        fileExtensionToResourceMap.put(".sg_tbl", rStatusGainTable);
        fileExtensionToResourceMap.put(".sja", rStageJoint);
        fileExtensionToResourceMap.put(".slt", rStageList);
        fileExtensionToResourceMap.put(".smc", rSituationMsgCtrl);
        fileExtensionToResourceMap.put(".smp", rStageMap);
        fileExtensionToResourceMap.put(".sn2", rAISensor);
        fileExtensionToResourceMap.put(".spg_tbl", rShopGoods);
        fileExtensionToResourceMap.put(".sri", rShotReqInfo);
        fileExtensionToResourceMap.put(".sri2", rShotReqInfo2);
        fileExtensionToResourceMap.put(".sta", rStartPosArea);
        fileExtensionToResourceMap.put(".sts", rStageToSpot);
        fileExtensionToResourceMap.put(".tcm", rTbl2ChatMacro);
        fileExtensionToResourceMap.put(".tdm", rTutorialDialogMessage);
        fileExtensionToResourceMap.put(".tlt", rTutorialList);
        fileExtensionToResourceMap.put(".tqg", rTutorialQuestGroup);
        fileExtensionToResourceMap.put(".wal", rWarpLocation);
        fileExtensionToResourceMap.put(".wpt", rWaypoint);
        fileExtensionToResourceMap.put(".wp2", rWaypoint2);
        fileExtensionToResourceMap.put(".wpn_ofs", rWeaponOffset);
        fileExtensionToResourceMap.put(".wrt", rWeaponResTable);
        fileExtensionToResourceMap.put(".wcrt", rWepCateResTbl);

        fileExtensionToResourceMap.forEach((key, value) -> resourceToFileExtensionMap.put(value, key));

        Arrays.stream(ClientResourceFileExtension.values()).forEach(e -> jamCrcToResourceMap.put(FrameworkResourcesUtil.convertDataTypeStringToDataTypeId(e.name()), e));
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
