package org.sehkah.ddon.tools.extractor.api.logic.resource;

import java.util.*;

public enum ClientResourceFileExtension {
    rAbilityAddData,
    rAbilityData,
    rAbilityList,
    rAchievement,
    rAchievementHeader,
    rAdjLimitParam,
    rAdjustParam,
    rAIFSM,
    rAIPawnActNoSwitch,
    rAIPawnAutoMotionTbl,
    rAIPawnAutoWordTbl,
    rAIPawnEmParam,
    rAIPawnOrder,
    rAIPawnSkillParamTbl,
    rAISensor,
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
    rCharacterEditColorDef,
    rCharacterEditTexturePalette,
    rCharacterEditVoicePalette,
    rCharParamEnemy,
    rChildRegionStatusParam,
    rChildRegionStatusParamList,
    rCraftArmQualityParam,
    rCraftCapPass,
    rCraftElementExp,
    rCraftQuality,
    rCraftRecipe,
    rCraftSkillBurst,
    rCraftSkillCost,
    rCraftSkillGain,
    rCraftSkillSpd,
    rCraftSkillStr,
    rCraftUpGradeExp,
    rCraftWepQualityParam,
    rCustomSkillData,
    rCycleContentsSortieInfo,
    rCycleQuestInfo,
    rDungeonMarker,
    rEditStageParam,
    rEmBaseInfoSv,
    rEmDamageDirInfo,
    rEmDmgTimerTbl,
    rEmLvUpParam,
    rEmScaleTable,
    rEmSoundTable,
    rEmWarpParam,
    rEmWorkRateTable,
    rEndContentsSortieInfo,
    rEnemyBloodStain,
    rEnemyGroup,
    rEnemyLocalEst,
    rEnemyMaterialTable,
    rEnemyReactResEx,
    rEnemyStatusChange,
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
    rGatheringItem,
    rGUIDogmaOrb,
    rGUIMapSetting,
    rGUIMessage,
    rHumanEnemyCustomSkill,
    rHumanEnemyEquip,
    rItemList,
    rJobBaseParam,
    rJobLevelUpTbl2,
    rJobMasterCtrl,
    rJobTutorialQuestList,
    rJointInfo,
    rJointOrder,
    rJumpParamTbl,
    rKeyConfigTextTable,
    rLandInfo,
    rLargeCameraParam,
    rLayout,
    rLayoutGroupParamList,
    rLayoutPreset,
    rLocationData,
    rMagicChantParam,
    rMagicCommandList,
    rMagicCommandWord,
    rMapSpotData,
    rMapSpotStageList,
    rMsgSet,
    rMyRoomActParam,
    rNamedParam,
    rNormalSkillData,
    rNpcConstItem,
    rNpcCustomSkill,
    rNpcIsNoSetPS3,
    rNpcIsUseJobParamEx,
    rNpcLedgerList,
    rNpcMeetingPlace,
    rOcdElectricParam,
    rOcdImmuneParamRes,
    rOcdStatusParamRes,
    rOmKey,
    rOmParam,
    rOmParamPart,
    rPackageQuestInfo,
    rParentRegionStatusParam,
    rPartnerPawnTalk,
    rPartnerReactParam,
    rPartsCtrlTable,
    rPawnQuestTalk,
    rPlayerExpTable,
    rPlPartsInfo,
    rPrologueHmStatus,
    rPushRate,
    rQuestHistoryData,
    rQuestList,
    rQuestMarkerInfo,
    rQuestSequenceList,
    rQuestTextData,
    rRageTable,
    rReaction,
    rReplaceWardGmdList,
    rRoomWearParam,
    rScenario,
    rShopGoods,
    rShotReqInfo,
    rShotReqInfo2,
    rShrinkBlowValue,
    rSituationMsgCtrl,
    rSoundBossBgm,
    rSoundOptData,
    rStageAdjoinList,
    rStageAdjoinList2,
    rStageConnect,
    rStageCustom,
    rStageCustomParts,
    rStageCustomPartsEx,
    rStageInfo,
    rStageJoint,
    rStageList,
    rStageMap,
    rStageToSpot,
    rStaminaDecTbl,
    rStartPos,
    rStartPosArea,
    rStatusCheck,
    rStatusGainTable,
    rTargetCursorOffset,
    rTbl2ChatMacro,
    rTexDetailEdit,
    rTutorialDialogMessage,
    rTutorialList,
    rTutorialQuestGroup,
    rVfxLightInfluence,
    rWarpLocation,
    rWaypoint,
    rWaypoint2,
    rWeaponOffset,
    rWeaponResTable,
    rWeatherFogInfo,
    rWeatherParamInfoTbl,
    rWeatherStageInfo,
    rWepCateResTbl;

    private static final Map<Long, ClientResourceFileExtension> jamCrcToResourceMap = HashMap.newHashMap(ClientResourceFileExtension.values().length);
    private static final Map<String, ClientResourceFileExtension> fileExtensionToResourceMap = HashMap.newHashMap(ClientResourceFileExtension.values().length);
    private static final Map<ClientResourceFileExtension, String> resourceToFileExtensionMap = new EnumMap<>(ClientResourceFileExtension.class);

    static {
        fileExtensionToResourceMap.put(".2EA55F30", rPlayerExpTable);
        fileExtensionToResourceMap.put(".3FD51519", rCraftSkillGain);
        fileExtensionToResourceMap.put(".4BB8A7C5", rCraftSkillBurst);
        fileExtensionToResourceMap.put(".46ECE09C", rCraftSkillStr);
        fileExtensionToResourceMap.put(".60BA5E0B", rCraftWepQualityParam);
        fileExtensionToResourceMap.put(".5362A636", rPartsCtrlTable);
        fileExtensionToResourceMap.put(".5810D1F1", rCraftRecipe);
        fileExtensionToResourceMap.put(".767645BE", rCraftArmQualityParam);
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
        fileExtensionToResourceMap.put(".chant", rMagicChantParam);
        fileExtensionToResourceMap.put(".cip", rCatchInfoParam);
        fileExtensionToResourceMap.put(".ckb", rCraftSkillBurst);
        fileExtensionToResourceMap.put(".ckc", rCraftSkillCost);
        fileExtensionToResourceMap.put(".ckg", rCraftSkillGain);
        fileExtensionToResourceMap.put(".cks", rCraftSkillSpd);
        fileExtensionToResourceMap.put(".ckst", rCraftSkillStr);
        fileExtensionToResourceMap.put(".cpe", rCharParamEnemy);
        fileExtensionToResourceMap.put(".cqa", rCraftArmQualityParam);
        fileExtensionToResourceMap.put(".cqi", rCycleQuestInfo);
        fileExtensionToResourceMap.put(".cqr", rCraftQuality);
        fileExtensionToResourceMap.put(".cqw", rCraftWepQualityParam);
        fileExtensionToResourceMap.put(".crs", rChildRegionStatusParam);
        fileExtensionToResourceMap.put(".csd", rCustomSkillData);
        fileExtensionToResourceMap.put(".csi", rCycleContentsSortieInfo);
        fileExtensionToResourceMap.put(".cuex", rCraftUpGradeExp);
        fileExtensionToResourceMap.put(".dgm", rGUIDogmaOrb);
        fileExtensionToResourceMap.put(".dmi", rDungeonMarker);
        fileExtensionToResourceMap.put(".dtt", rEmDmgTimerTbl);
        fileExtensionToResourceMap.put(".ebi_sv", rEmBaseInfoSv);
        fileExtensionToResourceMap.put(".ebs", rEnemyBloodStain);
        fileExtensionToResourceMap.put(".edt_color_def", rCharacterEditColorDef);
        fileExtensionToResourceMap.put(".edt_tex_pal", rCharacterEditTexturePalette);
        fileExtensionToResourceMap.put(".edt_voice_pal", rCharacterEditVoicePalette);
        fileExtensionToResourceMap.put(".edv", rEmDamageDirInfo);
        fileExtensionToResourceMap.put(".ele", rEnemyLocalEst);
        fileExtensionToResourceMap.put(".eli", rVfxLightInfluence);
        fileExtensionToResourceMap.put(".ema", rEnemyMaterialTable);
        fileExtensionToResourceMap.put(".emg", rEnemyGroup);
        fileExtensionToResourceMap.put(".eoc", rOcdElectricParam);
        fileExtensionToResourceMap.put(".equip_preset", rEquipPreset);
        fileExtensionToResourceMap.put(".era", rEnemyReactResEx);
        fileExtensionToResourceMap.put(".esi", rEndContentsSortieInfo);
        fileExtensionToResourceMap.put(".esl", rEmScaleTable);
        fileExtensionToResourceMap.put(".esn", rEmSoundTable);
        fileExtensionToResourceMap.put(".esp", rEditStageParam);
        fileExtensionToResourceMap.put(".est", rEnemyStatusChange);
        fileExtensionToResourceMap.put(".evl", rEvaluationTable);
        fileExtensionToResourceMap.put(".evp", rEventParam);
        fileExtensionToResourceMap.put(".ewk", rEmWorkRateTable);
        fileExtensionToResourceMap.put(".ewp", rEmWarpParam);
        fileExtensionToResourceMap.put(".exp", rPlayerExpTable);
        fileExtensionToResourceMap.put(".faa", rFieldAreaAdjoinList);
        fileExtensionToResourceMap.put(".fal", rFieldAreaList);
        fileExtensionToResourceMap.put(".fmd", rFieldMapData);
        fileExtensionToResourceMap.put(".fmi", rFieldAreaMarkerInfo);
        fileExtensionToResourceMap.put(".fnd", rFurnitureData);
        fileExtensionToResourceMap.put(".fng", rFurnitureGroup);
        fileExtensionToResourceMap.put(".fni", rFurnitureItem);
        fileExtensionToResourceMap.put(".fnl", rFurnitureLayout);
        fileExtensionToResourceMap.put(".fsm", rAIFSM);
        fileExtensionToResourceMap.put(".gat", rGatheringItem);
        fileExtensionToResourceMap.put(".gmd", rGUIMessage);
        fileExtensionToResourceMap.put(".gmp", rGUIMapSetting);
        fileExtensionToResourceMap.put(".hmcs", rHumanEnemyCustomSkill);
        fileExtensionToResourceMap.put(".hmeq", rHumanEnemyEquip);
        fileExtensionToResourceMap.put(".ipa", rItemList);
        fileExtensionToResourceMap.put(".jlt2", rJobLevelUpTbl2);
        fileExtensionToResourceMap.put(".jmc", rJobMasterCtrl);
        fileExtensionToResourceMap.put(".jmp", rJumpParamTbl);
        fileExtensionToResourceMap.put(".jnt_info", rJointInfo);
        fileExtensionToResourceMap.put(".jnt_order", rJointOrder);
        fileExtensionToResourceMap.put(".jobbase", rJobBaseParam);
        fileExtensionToResourceMap.put(".jtq", rJobTutorialQuestList);
        fileExtensionToResourceMap.put(".kctt", rKeyConfigTextTable);
        fileExtensionToResourceMap.put(".lai", rLandInfo);
        fileExtensionToResourceMap.put(".lcd", rLocationData);
        fileExtensionToResourceMap.put(".lcp", rLargeCameraParam);
        fileExtensionToResourceMap.put(".lop", rLayoutPreset);
        fileExtensionToResourceMap.put(".lot", rLayout);
        fileExtensionToResourceMap.put(".gpl", rLayoutGroupParamList);
        fileExtensionToResourceMap.put(".lup", rEmLvUpParam);
        fileExtensionToResourceMap.put(".mcw", rMagicCommandWord);
        fileExtensionToResourceMap.put(".mgcc", rMagicCommandList);
        fileExtensionToResourceMap.put(".mra", rMyRoomActParam);
        fileExtensionToResourceMap.put(".msd", rMapSpotData);
        fileExtensionToResourceMap.put(".msl", rMapSpotStageList);
        fileExtensionToResourceMap.put(".mss", rMsgSet);
        fileExtensionToResourceMap.put(".nci", rNpcConstItem);
        fileExtensionToResourceMap.put(".ncs", rNpcCustomSkill);
        fileExtensionToResourceMap.put(".ndp", rNamedParam);
        fileExtensionToResourceMap.put(".nll", rNpcLedgerList);
        fileExtensionToResourceMap.put(".nmp", rNpcMeetingPlace);
        fileExtensionToResourceMap.put(".nsd", rNormalSkillData);
        fileExtensionToResourceMap.put(".nsp", rNpcIsNoSetPS3);
        fileExtensionToResourceMap.put(".oIp", rOcdImmuneParamRes);
        fileExtensionToResourceMap.put(".omk", rOmKey);
        fileExtensionToResourceMap.put(".omp", rOmParam);
        fileExtensionToResourceMap.put(".ompp", rOmParamPart);
        fileExtensionToResourceMap.put(".osp", rOcdStatusParamRes);
        fileExtensionToResourceMap.put(".pam", rAIPawnAutoMotionTbl);
        fileExtensionToResourceMap.put(".pao", rAIPawnOrder);
        fileExtensionToResourceMap.put(".pas", rAIPawnActNoSwitch);
        fileExtensionToResourceMap.put(".paw", rAIPawnAutoWordTbl);
        fileExtensionToResourceMap.put(".pep", rAIPawnEmParam);
        fileExtensionToResourceMap.put(".phs", rPrologueHmStatus);
        fileExtensionToResourceMap.put(".ppr", rPartnerReactParam);
        fileExtensionToResourceMap.put(".ppt", rPartnerPawnTalk);
        fileExtensionToResourceMap.put(".pqi", rPackageQuestInfo);
        fileExtensionToResourceMap.put(".pqt", rPawnQuestTalk);
        fileExtensionToResourceMap.put(".prs", rParentRegionStatusParam);
        fileExtensionToResourceMap.put(".psi", rPlPartsInfo);
        fileExtensionToResourceMap.put(".ptc", rPartsCtrlTable);//Overlaps with rPawnThinkControl from season 3
        fileExtensionToResourceMap.put(".push_rate", rPushRate);
        fileExtensionToResourceMap.put(".qhd", rQuestHistoryData);
        fileExtensionToResourceMap.put(".qmi", rQuestMarkerInfo);
        fileExtensionToResourceMap.put(".qsq", rQuestSequenceList);
        fileExtensionToResourceMap.put(".qst", rQuestList);
        fileExtensionToResourceMap.put(".qtd", rQuestTextData);
        fileExtensionToResourceMap.put(".rac", rReaction);
        fileExtensionToResourceMap.put(".rag", rRageTable);
        fileExtensionToResourceMap.put(".rcp", rCraftRecipe);
        fileExtensionToResourceMap.put(".repgmdlist", rReplaceWardGmdList);
        fileExtensionToResourceMap.put(".rsl", rChildRegionStatusParamList);
        fileExtensionToResourceMap.put(".rwr", rRoomWearParam);
        fileExtensionToResourceMap.put(".sal", rStageAdjoinList);
        fileExtensionToResourceMap.put(".sal2", rStageAdjoinList2);
        fileExtensionToResourceMap.put(".sbb", rSoundBossBgm);
        fileExtensionToResourceMap.put(".sbv", rShrinkBlowValue);
        fileExtensionToResourceMap.put(".sca", rStageCustom);
        fileExtensionToResourceMap.put(".scc", rStageConnect);
        fileExtensionToResourceMap.put(".sce", rScenario);
        fileExtensionToResourceMap.put(".sck", rStatusCheck);
        fileExtensionToResourceMap.put(".scp", rStageCustomParts);
        fileExtensionToResourceMap.put(".scpx", rStageCustomPartsEx);
        fileExtensionToResourceMap.put(".sdt", rStaminaDecTbl);
        fileExtensionToResourceMap.put(".sg_tbl", rStatusGainTable);
        fileExtensionToResourceMap.put(".sja", rStageJoint);
        fileExtensionToResourceMap.put(".slt", rStageList);
        fileExtensionToResourceMap.put(".smc", rSituationMsgCtrl);
        fileExtensionToResourceMap.put(".smp", rStageMap);
        fileExtensionToResourceMap.put(".sn2", rAISensor);
        fileExtensionToResourceMap.put(".sot", rSoundOptData);
        fileExtensionToResourceMap.put(".spg_tbl", rShopGoods);
        fileExtensionToResourceMap.put(".sri", rShotReqInfo);
        fileExtensionToResourceMap.put(".sri2", rShotReqInfo2);
        fileExtensionToResourceMap.put(".sta", rStartPosArea);
        fileExtensionToResourceMap.put(".sti", rStageInfo);
        fileExtensionToResourceMap.put(".stp", rStartPos);
        fileExtensionToResourceMap.put(".sts", rStageToSpot);
        fileExtensionToResourceMap.put(".tcm", rTbl2ChatMacro);
        fileExtensionToResourceMap.put(".tco", rTargetCursorOffset);
        fileExtensionToResourceMap.put(".tde", rTexDetailEdit);
        fileExtensionToResourceMap.put(".tdm", rTutorialDialogMessage);
        fileExtensionToResourceMap.put(".tlt", rTutorialList);
        fileExtensionToResourceMap.put(".tqg", rTutorialQuestGroup);
        fileExtensionToResourceMap.put(".ujp", rNpcIsUseJobParamEx);
        fileExtensionToResourceMap.put(".wal", rWarpLocation);
        fileExtensionToResourceMap.put(".wcrt", rWepCateResTbl);
        fileExtensionToResourceMap.put(".wp2", rWaypoint2);
        fileExtensionToResourceMap.put(".wpn_ofs", rWeaponOffset);
        fileExtensionToResourceMap.put(".wpt", rWaypoint);
        fileExtensionToResourceMap.put(".wrt", rWeaponResTable);
        fileExtensionToResourceMap.put(".wsi", rWeatherStageInfo);
        fileExtensionToResourceMap.put(".wtf", rWeatherFogInfo);
        fileExtensionToResourceMap.put(".wtl", rWeatherParamInfoTbl);

        fileExtensionToResourceMap.forEach((key, value) -> resourceToFileExtensionMap.put(value, key));

        Arrays.stream(ClientResourceFileExtension.values()).forEach(e -> jamCrcToResourceMap.put(FrameworkResourcesUtil.convertDataTypeStringToDataTypeId(e.name()), e));

//        fileExtensionToResourceMap.forEach((key, value) -> System.out.println(key + "," + value));// + "," + FrameworkResourcesUtil.convertDataTypeStringToDataTypeId(value.name())));
    }

    public static ClientResourceFileExtension of(String fileExtension) {
        return fileExtensionToResourceMap.get(fileExtension);
    }

    public static String getFileExtensions(ClientResourceFileExtension resource) {
        return resourceToFileExtensionMap.get(resource);
    }

    // TODO: Support JamCRC strings in case someone is using a tool which couldn't properly map the file extension
    public static Set<String> getSupportedFileExtensions() {
        return fileExtensionToResourceMap.keySet();
    }
}
