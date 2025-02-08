package org.sehkah.ddon.tools.extractor.api.logic.resource;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.crypto.CrcUtil;
import org.sehkah.ddon.tools.extractor.api.io.ResourceUtil;
import org.sehkah.ddon.tools.extractor.api.util.StringUtil;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class FrameworkResourcesUtil {
    private static final Map<String, String> resourceToFileExtensionMap = HashMap.newHashMap(420);
    private static final Map<Long, String> jamCrcToResourceMap = HashMap.newHashMap(420);
    private static final Map<Long, String> jamCrcToFileExtensionMap = HashMap.newHashMap(420);

    static {
        List<String> lines = ResourceUtil.loadResourceFileLines("DTI.txt");
        lines.forEach(line -> resourceToFileExtensionMap.put(line, "." + line.replace("::", "_")));

//                resourceToFileExtensionMap.put("cSetInfoOmHvLever", ".cSetInfoOmHvLever"); //TODO Unsure
//                resourceToFileExtensionMap.put("cSetInfoOmMine", ".cSetInfoOmMine"); //TODO Unsure
        resourceToFileExtensionMap.put("rAbilityList", ".abl");
        resourceToFileExtensionMap.put("rAchievement", ".acv");
        resourceToFileExtensionMap.put("rAchievementHeader", ".ach");
        resourceToFileExtensionMap.put("rAcquirement::rAbilityAddData", ".aad");
        resourceToFileExtensionMap.put("rAcquirement::rAbilityData", ".abd");
        resourceToFileExtensionMap.put("rAcquirement::rCustomSkillData", ".csd");
        resourceToFileExtensionMap.put("rAcquirement::rNormalSkillData", ".nsd");
        resourceToFileExtensionMap.put("rActionParamList", ".acp");
        resourceToFileExtensionMap.put("rActivateDragonSkill", ".ads");
        resourceToFileExtensionMap.put("rActorLight", ".ali");
        resourceToFileExtensionMap.put("rAdjLimitParam", ".alp");
        resourceToFileExtensionMap.put("rAdjustParam", ".ajp");
        resourceToFileExtensionMap.put("rAI", ".ais");
        resourceToFileExtensionMap.put("rAIConditionTree", ".cdt");
        resourceToFileExtensionMap.put("rAIDynamicLayout", ".dpth");
        resourceToFileExtensionMap.put("rAIFSM", ".fsm");
        resourceToFileExtensionMap.put("rAIFSMList", ".fsl");
        resourceToFileExtensionMap.put("rAIFSMList::Info", ".fsl_info");
        resourceToFileExtensionMap.put("rAIPathBase", ".are");
        resourceToFileExtensionMap.put("rAIPathBaseXml", ".are.xml");
        resourceToFileExtensionMap.put("rAIPawnActNoSwitch", ".pas");
        resourceToFileExtensionMap.put("rAIPawnAutoMotionTbl", ".pam");
        resourceToFileExtensionMap.put("rAIPawnAutoWordTbl", ".paw");
        resourceToFileExtensionMap.put("rAIPawnCulPrioThinkCategory", ".pc_ptkc");
        resourceToFileExtensionMap.put("rAIPawnEmParam", ".pep");
        resourceToFileExtensionMap.put("rAIPawnOrder", ".pao");
        resourceToFileExtensionMap.put("rAIPawnSkillParamTbl", ".aps");
        resourceToFileExtensionMap.put("rAIPawnSpecialityInfo", ".ps_info");
        resourceToFileExtensionMap.put("rAISensor", ".sn2");
        resourceToFileExtensionMap.put("rAIWayPoint", ".way");
        resourceToFileExtensionMap.put("rAIWayPointGraph", ".gway");
        resourceToFileExtensionMap.put("rAnimalData", ".aml");
        resourceToFileExtensionMap.put("rArchive", ".arc");
        resourceToFileExtensionMap.put("rArchiveImport", ".aimp");
        resourceToFileExtensionMap.put("rArchiveListArray", ".ala");
        resourceToFileExtensionMap.put("rAreaHitShape", ".ahs");
        resourceToFileExtensionMap.put("rAreaInfo", ".ari");
        resourceToFileExtensionMap.put("rAreaInfoJointArea", ".arj");
        resourceToFileExtensionMap.put("rAreaInfoStage", ".ars");
        resourceToFileExtensionMap.put("rAreaMasterRankData", ".amr");
        resourceToFileExtensionMap.put("rAreaMasterSpotData", ".ams");
        resourceToFileExtensionMap.put("rAreaMasterSpotDetailData", ".amsd");
        resourceToFileExtensionMap.put("rArmedEnemyInfo", ".aeminfo");
        resourceToFileExtensionMap.put("rAtDfRateRaid", ".atdf_raid");
        resourceToFileExtensionMap.put("rAttackParam", ".atk");
        resourceToFileExtensionMap.put("rBakeJoint", ".bjt");
        resourceToFileExtensionMap.put("rBitTable", ".btb");
        resourceToFileExtensionMap.put("rBlazeEnemyInfo", ".beminfo");
        resourceToFileExtensionMap.put("rBlowSaveEmLvParam", ".blow_save");
        resourceToFileExtensionMap.put("rBowActParamList", ".bap");
        resourceToFileExtensionMap.put("rBrowserFont", ".bft");
        resourceToFileExtensionMap.put("rBrowserUITableData", ".but");
        resourceToFileExtensionMap.put("rCalcDamageAtdmAdj", ".cda");
        resourceToFileExtensionMap.put("rCalcDamageAtdmAdjRate", ".cdarate");
        resourceToFileExtensionMap.put("rCalcDamageLvAdj", ".cdl");
        resourceToFileExtensionMap.put("rCameraList", ".lcm");
        resourceToFileExtensionMap.put("rCameraParamList", ".cpl");
        resourceToFileExtensionMap.put("rCameraQuakeList", ".cql");
        resourceToFileExtensionMap.put("rCatchInfoParam", ".cip");
        resourceToFileExtensionMap.put("rCaughtDamageRateRefTbl", ".cdrr");
        resourceToFileExtensionMap.put("rCaughtDamageRateTbl", ".cdrt");
        resourceToFileExtensionMap.put("rCaughtInfoParam", ".caip");
        resourceToFileExtensionMap.put("rCharacterEdit", ".edt");
        resourceToFileExtensionMap.put("rCharacterEditCameraParam", ".cecp");
        resourceToFileExtensionMap.put("rCharacterEditColorDef", ".edt_color_def");
        resourceToFileExtensionMap.put("rCharacterEditModelPalette", ".edt_mod_pal");
        resourceToFileExtensionMap.put("rCharacterEditMuscle", ".edt_muscle");
        resourceToFileExtensionMap.put("rCharacterEditPersonalityPalette", ".edt_personality_pal");
        resourceToFileExtensionMap.put("rCharacterEditPresetPalette", ".edt_pset_pal");
        resourceToFileExtensionMap.put("rCharacterEditTalkLvPalette", ".edt_talk_pal");
        resourceToFileExtensionMap.put("rCharacterEditTexturePalette", ".edt_tex_pal");
        resourceToFileExtensionMap.put("rCharacterEditVoicePalette", ".edt_voice_pal");
        resourceToFileExtensionMap.put("rCharParamEnemy", ".cpe");
        resourceToFileExtensionMap.put("rChildRegionStatusParam", ".crs");
        resourceToFileExtensionMap.put("rChildRegionStatusParamList", ".rsl");
        resourceToFileExtensionMap.put("rCnsIK", ".ik");
        resourceToFileExtensionMap.put("rCnsJointOffset", ".jof");
        resourceToFileExtensionMap.put("rCnsLookAt", ".lat");
        resourceToFileExtensionMap.put("rCnsMatrix", ".mtx");
        resourceToFileExtensionMap.put("rCnsTinyChain", ".ctc");
        resourceToFileExtensionMap.put("rCnsTinyIK", ".tik");
        resourceToFileExtensionMap.put("rCollGeom", ".coll_geom");
        resourceToFileExtensionMap.put("rCollIndex", ".coll_idx");
        resourceToFileExtensionMap.put("rCollision", ".sbc");
        resourceToFileExtensionMap.put("rCollisionHeightField", ".sbch");
        resourceToFileExtensionMap.put("rCollisionObj", ".obc");
        resourceToFileExtensionMap.put("rCollNode", ".coll_node");
        resourceToFileExtensionMap.put("rConstModelParam", ".cmp");
        resourceToFileExtensionMap.put("rConvexHull", ".hul");
        resourceToFileExtensionMap.put("rCraftArmQualityParam", ".cqa");
        resourceToFileExtensionMap.put("rCraftCapPass", ".ccp");
        resourceToFileExtensionMap.put("rCraftElementExp", ".cee");
        resourceToFileExtensionMap.put("rCraftQuality", ".cqr");
        resourceToFileExtensionMap.put("rCraftRecipe", ".rcp");
        resourceToFileExtensionMap.put("rCraftSkillBurst", ".ckb");
        resourceToFileExtensionMap.put("rCraftSkillCost", ".ckc");
        resourceToFileExtensionMap.put("rCraftSkillGain", ".ckg");
        resourceToFileExtensionMap.put("rCraftSkillSpd", ".cks");
        resourceToFileExtensionMap.put("rCraftSkillStr", ".ckst");
        resourceToFileExtensionMap.put("rCraftUpGradeExp", ".cuex");
        resourceToFileExtensionMap.put("rCraftWepQualityParam", ".cqw");
        resourceToFileExtensionMap.put("rCustimShlLimit", ".csl");
        resourceToFileExtensionMap.put("rCycleContentsSortieInfo", ".csi");
        resourceToFileExtensionMap.put("rCycleQuestInfo", ".cqi");
        resourceToFileExtensionMap.put("rDamageCounterInfo", ".counter_Adj");
        resourceToFileExtensionMap.put("rDamageSaveEmLvParam", ".damage_save");
        resourceToFileExtensionMap.put("rDamageSpecialAdj", ".damage_spAdj");
        resourceToFileExtensionMap.put("rDarkSkyParam", ".dsp");
        resourceToFileExtensionMap.put("rDDOBenchmark", ".bmk");
        resourceToFileExtensionMap.put("rDDOModelMontage", ".dmt");
        resourceToFileExtensionMap.put("rDDOModelMontageEm", ".dme");
        resourceToFileExtensionMap.put("rDeformWeightMap", ".dwm");
        resourceToFileExtensionMap.put("rDmJobAdjParam", ".dja");
        resourceToFileExtensionMap.put("rDmJobPawnAdjParam", ".dja_pawn");
        resourceToFileExtensionMap.put("rDmLvPawnAdjParam", ".cdl_pawn");
        resourceToFileExtensionMap.put("rDmVecWeightParam", ".dvw");
        resourceToFileExtensionMap.put("rDragonSkillColorParam", ".dscp");
        resourceToFileExtensionMap.put("rDragonSkillEnhanceParam", ".dse");
        resourceToFileExtensionMap.put("rDragonSkillLevelParam", ".dsl");
        resourceToFileExtensionMap.put("rDragonSkillParam", ".dsd");
        resourceToFileExtensionMap.put("rDungeonMarker", ".dmi");
        resourceToFileExtensionMap.put("rDynamicSbc", ".dsc");
        resourceToFileExtensionMap.put("rEditConvert", ".edc");
        resourceToFileExtensionMap.put("rEditStageParam", ".esp");
        resourceToFileExtensionMap.put("rEffect2D", ".e2d");
        resourceToFileExtensionMap.put("rEffectAnim", ".ean");
        resourceToFileExtensionMap.put("rEffectList", ".efl");
        resourceToFileExtensionMap.put("rEffectProvider", ".epv");
        resourceToFileExtensionMap.put("rEffectStrip", ".efs");
        resourceToFileExtensionMap.put("rEmBaseInfoSv", ".ebi_sv");
        resourceToFileExtensionMap.put("rEmblemColorTable", ".ect");
        resourceToFileExtensionMap.put("rEmCategory", ".ecg");
        resourceToFileExtensionMap.put("rEmDamageDirInfo", ".edv");
        resourceToFileExtensionMap.put("rEmDmgTimerTbl", ".dtt");
        resourceToFileExtensionMap.put("rEmEffectTable", ".eef");
        resourceToFileExtensionMap.put("rEmLvUpParam", ".lup");
        resourceToFileExtensionMap.put("rEmMsgTable", ".emt");
        resourceToFileExtensionMap.put("rEmoteGroup", ".peg");
        resourceToFileExtensionMap.put("rEmparam", ".emparam");
        resourceToFileExtensionMap.put("rEmScaleTable", ".esl");
        resourceToFileExtensionMap.put("rEmScrAdjust", ".em_scr_adj");
        resourceToFileExtensionMap.put("rEmSoundTable", ".esn");
        resourceToFileExtensionMap.put("rEmStatusAdj", ".esa");
        resourceToFileExtensionMap.put("rEmWarpParam", ".ewp");
        resourceToFileExtensionMap.put("rEmWeakSafe", ".wallmaria");
        resourceToFileExtensionMap.put("rEmWorkRateTable", ".ewk");
        resourceToFileExtensionMap.put("rEndContentsSortieInfo", ".esi");
        resourceToFileExtensionMap.put("rEnemyBloodStain", ".ebs");
        resourceToFileExtensionMap.put("rEnemyGroup", ".emg");
        resourceToFileExtensionMap.put("rEnemyLocalEst", ".ele");
        resourceToFileExtensionMap.put("rEnemyLocalShelTable", ".esh");
        resourceToFileExtensionMap.put("rEnemyMaterialTable", ".ema");
        resourceToFileExtensionMap.put("rEnemyReactResEx", ".era");
        resourceToFileExtensionMap.put("rEnemyStatusChange", ".est");
        resourceToFileExtensionMap.put("rEnhancedParamList", ".epl");
        resourceToFileExtensionMap.put("rEnumDef", ".edf");
        resourceToFileExtensionMap.put("rEquipCaptureList", ".ecl");
        resourceToFileExtensionMap.put("rEquipPartsInfo", ".epi");
        resourceToFileExtensionMap.put("rEquipPreset", ".equip_preset");
        resourceToFileExtensionMap.put("rEquipPresetPalette", ".epp");
        resourceToFileExtensionMap.put("rErosionInfoRes", ".reg_info");
        resourceToFileExtensionMap.put("rErosionRegion", ".reg_ersion");
        resourceToFileExtensionMap.put("rErosionRegionScaleChange", ".scl_change");
        resourceToFileExtensionMap.put("rErosionShakeConvert", ".ero_addTime");
        resourceToFileExtensionMap.put("rErosionSmallInfoRes", ".eroSmall_info");
        resourceToFileExtensionMap.put("rErosionSuperInfoRes", ".eroSuper_info");
        resourceToFileExtensionMap.put("rEvaluationTable", ".evl");
        resourceToFileExtensionMap.put("rEventParam", ".evp");
        resourceToFileExtensionMap.put("rEventResTable", ".evtr");
        resourceToFileExtensionMap.put("rEventViewerList", ".evlst");
        resourceToFileExtensionMap.put("rEventViewerSetInfo", ".evsi");
        resourceToFileExtensionMap.put("rEvidenceList", ".evd");
        resourceToFileExtensionMap.put("rFacialEditJointPreset", ".fedt_jntpreset");
        resourceToFileExtensionMap.put("rFatAdjust", ".fat_adjust");
        resourceToFileExtensionMap.put("rFieldAreaAdjoinList", ".faa");
        resourceToFileExtensionMap.put("rFieldAreaList", ".fal");
        resourceToFileExtensionMap.put("rFieldAreaMarkerInfo", ".fmi");
        resourceToFileExtensionMap.put("rFieldMapData", ".fmd");
        resourceToFileExtensionMap.put("rFreeF32Tbl", ".f2p");
        resourceToFileExtensionMap.put("rFullbodyIKHuman2", ".fbik_human2");
        resourceToFileExtensionMap.put("rFunctionList", ".ftl");
        resourceToFileExtensionMap.put("rFurnitureAccessories", ".fad");
        resourceToFileExtensionMap.put("rFurnitureData", ".fnd");
        resourceToFileExtensionMap.put("rFurnitureGroup", ".fng");
        resourceToFileExtensionMap.put("rFurnitureItem", ".fni");
        resourceToFileExtensionMap.put("rFurnitureLayout", ".fnl");
        resourceToFileExtensionMap.put("rGatheringItem", ".gat");
        resourceToFileExtensionMap.put("rGeometry2", ".geo2");
        resourceToFileExtensionMap.put("rGeometry2Group", ".geog");
        resourceToFileExtensionMap.put("rGeometry3", ".geo3");
        resourceToFileExtensionMap.put("rGraphPatch", ".gpt");
        resourceToFileExtensionMap.put("rGrass", ".grs");
        resourceToFileExtensionMap.put("rGrass2", ".gr2");
        resourceToFileExtensionMap.put("rGrass2Setting", ".gr2s");
        resourceToFileExtensionMap.put("rGrassWind", ".grw");
        resourceToFileExtensionMap.put("rGUI", ".gui");
        resourceToFileExtensionMap.put("rGUIDogmaOrb", ".dgm");
        resourceToFileExtensionMap.put("rGUIFont", ".gfd");
        resourceToFileExtensionMap.put("rGUIIconInfo", ".gii");
        resourceToFileExtensionMap.put("rGUIMapSetting", ".gmp");
        resourceToFileExtensionMap.put("rGUIMessage", ".gmd");
        resourceToFileExtensionMap.put("rGUIPhotoFrame", ".pho");
        resourceToFileExtensionMap.put("rHeadCtrl", ".head_ctrl");
        resourceToFileExtensionMap.put("rHideNpcNameInfo", ".hni");
        resourceToFileExtensionMap.put("rHumanEnemyCustomSkill", ".hmcs");
        resourceToFileExtensionMap.put("rHumanEnemyEquip", ".hmeq");
        resourceToFileExtensionMap.put("rHumanEnemyParam", ".hmeparam");
        resourceToFileExtensionMap.put("rHumanEnemyPreset", ".hmpre");
        resourceToFileExtensionMap.put("rIKCtrl", ".ikctrl");
        resourceToFileExtensionMap.put("rImplicitSurface", ".is");
        resourceToFileExtensionMap.put("rIniLocal", ".ini");
        resourceToFileExtensionMap.put("rISC", ".isc");
        resourceToFileExtensionMap.put("rIsEquipOneOfSeveral", ".ieo");
        resourceToFileExtensionMap.put("rItemEquipJobInfoList", ".eir");
        resourceToFileExtensionMap.put("rItemList", ".ipa");
        resourceToFileExtensionMap.put("rJobBaseParam", ".jobbase");
        resourceToFileExtensionMap.put("rJobCustomParam", ".jcp");
        resourceToFileExtensionMap.put("rJobLevelUpTbl2", ".jlt2");
        resourceToFileExtensionMap.put("rJobMasterCtrl", ".jmc");
        resourceToFileExtensionMap.put("rJobTutorialQuestList", ".jtq");
        resourceToFileExtensionMap.put("rJointEx2", ".jex2");
        resourceToFileExtensionMap.put("rJointInfo", ".jnt_info");
        resourceToFileExtensionMap.put("rJointOrder", ".jnt_order");
        resourceToFileExtensionMap.put("rJukeBoxItem", ".jbi");
        resourceToFileExtensionMap.put("rJumpParamTbl", ".jmp");
        resourceToFileExtensionMap.put("rKeyCommand", ".kcm");
        resourceToFileExtensionMap.put("rKeyConfigTextTable", ".kctt");
        resourceToFileExtensionMap.put("rKeyCustomParam", ".kcp");
        resourceToFileExtensionMap.put("rkThinkData", ".pen");
        resourceToFileExtensionMap.put("rLandInfo", ".lai");
        resourceToFileExtensionMap.put("rLanguageResIDConverter", ".lrc");
        resourceToFileExtensionMap.put("rLargeCameraParam", ".lcp");
        resourceToFileExtensionMap.put("rLayout", ".lot");
        resourceToFileExtensionMap.put("rLayoutGroupParam", ".lgp");
        resourceToFileExtensionMap.put("rLayoutGroupParamList", ".gpl");
        resourceToFileExtensionMap.put("rLayoutPreset", ".lop");
        resourceToFileExtensionMap.put("rLegCtrl", ".leg_ctrl");
        resourceToFileExtensionMap.put("rLineBuilder", ".mlb");
        resourceToFileExtensionMap.put("rLinkageEnemy", ".lae");
        resourceToFileExtensionMap.put("rLinkageEnemyXml", ".lae.xml");
        resourceToFileExtensionMap.put("rLoadingParam", ".ldp");
        resourceToFileExtensionMap.put("rLocationData", ".lcd");
        resourceToFileExtensionMap.put("rMagicChantParam", ".chant");
        resourceToFileExtensionMap.put("rMagicCommandList", ".mgcc");
        resourceToFileExtensionMap.put("rMagicCommandWord", ".mcw");
        resourceToFileExtensionMap.put("rMandraActionParam", ".map");
        resourceToFileExtensionMap.put("rMandraCharaMake", ".mcm");
        resourceToFileExtensionMap.put("rMandraMotCombine", ".mmc");
        resourceToFileExtensionMap.put("rMandraReaction", ".mdr");
        resourceToFileExtensionMap.put("rMapSpotData", ".msd");
        resourceToFileExtensionMap.put("rMapSpotStageList", ".msl");
        resourceToFileExtensionMap.put("rMaterial", ".mrl");
        resourceToFileExtensionMap.put("rModel", ".mod");
        resourceToFileExtensionMap.put("rMotionFilter", ".mot_filter");
        resourceToFileExtensionMap.put("rMotionList", ".lmt");
        resourceToFileExtensionMap.put("rMotionParam", ".motparam");
        resourceToFileExtensionMap.put("rMovieOnDisk", ".wmv");
        resourceToFileExtensionMap.put("rMovieOnDiskInterMediate", ".wmv");
        resourceToFileExtensionMap.put("rMovieOnMemory", ".mem.wmv");
        resourceToFileExtensionMap.put("rMovieOnMemoryInterMediate", ".mem.wmv");
        resourceToFileExtensionMap.put("rMsgSet", ".mss");
        resourceToFileExtensionMap.put("rMyRoomActParam", ".mra");
        resourceToFileExtensionMap.put("rNamedParam", ".ndp");
        resourceToFileExtensionMap.put("rNavConnect", ".nvc");
        resourceToFileExtensionMap.put("rNavigationMesh", ".nav");
        resourceToFileExtensionMap.put("rNpcConstItem", ".nci");
        resourceToFileExtensionMap.put("rNpcCustomSkill", ".ncs");
        resourceToFileExtensionMap.put("rNpcEditData", ".ned");
        resourceToFileExtensionMap.put("rNPCEmoMyRoom", ".nem");
        resourceToFileExtensionMap.put("rNpcIsNoSetPS3", ".nsp");
        resourceToFileExtensionMap.put("rNpcIsUseJobParamEx", ".ujp");
        resourceToFileExtensionMap.put("rNpcLedgerList", ".nll");
        resourceToFileExtensionMap.put("rNpcMeetingPlace", ".nmp");
        resourceToFileExtensionMap.put("rNPCMotionSet", ".nms");
        resourceToFileExtensionMap.put("rNPCMotMyRoom", ".nmm");
        resourceToFileExtensionMap.put("rNulls", ".nls");
        resourceToFileExtensionMap.put("rObjCollision", ".col");
        resourceToFileExtensionMap.put("rOccluder", ".occ");
        resourceToFileExtensionMap.put("rOccluderEx", ".oce");
        resourceToFileExtensionMap.put("rOcdElectricParam", ".eoc");
        resourceToFileExtensionMap.put("rOcdImmuneParamRes", ".oIp");
        resourceToFileExtensionMap.put("rOcdIrAdj", ".ir_adj");
        resourceToFileExtensionMap.put("rOcdIrAdjPL", ".ir_adj_pl");
        resourceToFileExtensionMap.put("rOcdPriorityParam", ".opp");
        resourceToFileExtensionMap.put("rOcdStatusParamRes", ".osp");
        resourceToFileExtensionMap.put("rOmKey", ".omk");
        resourceToFileExtensionMap.put("rOmLoadList", ".oll");
        resourceToFileExtensionMap.put("rOmParam", ".omp");
        resourceToFileExtensionMap.put("rOmParamEx", ".ompe");
        resourceToFileExtensionMap.put("rOmParamPart", ".ompp");
        resourceToFileExtensionMap.put("rOutfitInfo", ".ofi");
        resourceToFileExtensionMap.put("rOutlineParamList", ".olp");
        resourceToFileExtensionMap.put("rPackageQuestInfo", ".pqi");
        resourceToFileExtensionMap.put("rParentRegionStatusParam", ".prs");
        resourceToFileExtensionMap.put("rPartnerPawnTalk", ".ppt");
        resourceToFileExtensionMap.put("rPartnerReactParam", ".ppr");
        resourceToFileExtensionMap.put("rPartsCtrlTable", ".ptc");
        resourceToFileExtensionMap.put("rPawnAIAction", ".paa");
        resourceToFileExtensionMap.put("rPawnQuestTalk", ".pqt");
        resourceToFileExtensionMap.put("rPawnSpSkillCategoryUI", ".pssc");
        resourceToFileExtensionMap.put("rPawnSpSkillLevelUI", ".pssl");
        resourceToFileExtensionMap.put("rPawnThinkControl", ".ptc");
        resourceToFileExtensionMap.put("rPawnThinkLevelUp", ".plu");
        resourceToFileExtensionMap.put("rPCSimpleDebuggerTarget", ".pdd");
        resourceToFileExtensionMap.put("rPhoteNGItem", ".pni");
        resourceToFileExtensionMap.put("rPlanetariumItem", ".planet");
        resourceToFileExtensionMap.put("rPlantTree", ".plt");
        resourceToFileExtensionMap.put("rPlayerExpTable", ".exp");
        resourceToFileExtensionMap.put("rPlPartsInfo", ".psi");
        resourceToFileExtensionMap.put("rPriorityThink", ".ptk");
        resourceToFileExtensionMap.put("rPrologueHmStatus", ".phs");
        resourceToFileExtensionMap.put("rPushRate", ".push_rate");
        resourceToFileExtensionMap.put("rQuestHistoryData", ".qhd");
        resourceToFileExtensionMap.put("rQuestList", ".qst");
        resourceToFileExtensionMap.put("rQuestMarkerInfo", ".qmi");
        resourceToFileExtensionMap.put("rQuestSequenceList", ".qsq");
        resourceToFileExtensionMap.put("rQuestTextData", ".qtd");
        resourceToFileExtensionMap.put("rRagdoll", ".rdd");
        resourceToFileExtensionMap.put("rRageTable", ".rag");
        resourceToFileExtensionMap.put("rReaction", ".rac");
        resourceToFileExtensionMap.put("rRecommendDragonSkill", ".rds");
        resourceToFileExtensionMap.put("rRegionBreakInfo", ".erb");
        resourceToFileExtensionMap.put("rRegionStatusCtrlTable", ".rsc");
        resourceToFileExtensionMap.put("rRenderTargetTexture", ".rtex");
        resourceToFileExtensionMap.put("rReplaceWardGmdList", ".repgmdlist");
        resourceToFileExtensionMap.put("rRigidBody", ".rbd");
        resourceToFileExtensionMap.put("rRoomWearParam", ".rwr");
        resourceToFileExtensionMap.put("rScenario", ".sce");
        resourceToFileExtensionMap.put("rSceneTexture", ".stex");
        resourceToFileExtensionMap.put("rScheduler", ".sdl");
        resourceToFileExtensionMap.put("rShader2", ".mfx");
        resourceToFileExtensionMap.put("rShaderCache", ".sch");
        resourceToFileExtensionMap.put("rShaderPackage", ".spkg");
        resourceToFileExtensionMap.put("rShakeCtrl", ".shake_ctrl");
        resourceToFileExtensionMap.put("rShlLimit", ".slm");
        resourceToFileExtensionMap.put("rShlParamList", ".shl");
        resourceToFileExtensionMap.put("rShopGoods", ".spg_tbl");
        resourceToFileExtensionMap.put("rShotReqInfo", ".sri");
        resourceToFileExtensionMap.put("rShotReqInfo2", ".sri2");
        resourceToFileExtensionMap.put("rShrinkBlowValue", ".sbv");
        resourceToFileExtensionMap.put("rSimpleCom::rChatComData", ".ccd");
        resourceToFileExtensionMap.put("rSitePack", ".sit");
        resourceToFileExtensionMap.put("rSituationMsgCtrl", ".smc");
        resourceToFileExtensionMap.put("rSky", ".sky");
        resourceToFileExtensionMap.put("rSndPitchLimit", ".spl");
        resourceToFileExtensionMap.put("rSoundAreaInfo", ".sar");
        resourceToFileExtensionMap.put("rSoundAttributeSe", ".aser");
        resourceToFileExtensionMap.put("rSoundBank", ".sbkr");
        resourceToFileExtensionMap.put("rSoundBossBgm", ".sbb");
        resourceToFileExtensionMap.put("rSoundCurveSet", ".scsr");
        resourceToFileExtensionMap.put("rSoundCurveXml", ".scvr.xml");
        resourceToFileExtensionMap.put("rSoundDirectionalCurveXml", ".sdcr.xml");
        resourceToFileExtensionMap.put("rSoundDirectionalSet", ".sdsr");
        resourceToFileExtensionMap.put("rSoundEQ", ".equr");
        resourceToFileExtensionMap.put("rSoundHitInfo", ".shi");
        resourceToFileExtensionMap.put("rSoundMotionSe", ".mser");
        resourceToFileExtensionMap.put("rSoundOptData", ".sot");
        resourceToFileExtensionMap.put("rSoundParamOfs", ".spo");
        resourceToFileExtensionMap.put("rSoundPhysicsJoint", ".spjr");
        resourceToFileExtensionMap.put("rSoundPhysicsList", ".splr");
        resourceToFileExtensionMap.put("rSoundPhysicsRigidBody", ".sprr");
        resourceToFileExtensionMap.put("rSoundPhysicsSoftBody", ".spsr");
        resourceToFileExtensionMap.put("rSoundRangeEqSet", ".sreq");
        resourceToFileExtensionMap.put("rSoundRequest", ".srqr");
        resourceToFileExtensionMap.put("rSoundReverb", ".revr");
        resourceToFileExtensionMap.put("rSoundSequenceSe", ".ssqr");
        resourceToFileExtensionMap.put("rSoundSimpleCurve", ".sscr");
        resourceToFileExtensionMap.put("rSoundSourceMSADPCM", ".xsew");
        resourceToFileExtensionMap.put("rSoundSourceOggVorbis", ".sngw");
        resourceToFileExtensionMap.put("rSoundSourcePC", ".rSoundSourcePC");
        resourceToFileExtensionMap.put("rSoundSpeakerSetXml", ".sssr.xml");
        resourceToFileExtensionMap.put("rSoundStreamRequest", ".stqr");
        resourceToFileExtensionMap.put("rSoundSubMixer", ".smxr");
        resourceToFileExtensionMap.put("rSoundSubMixerSet", ".sms");
        resourceToFileExtensionMap.put("rStageAdjoinList", ".sal");
        resourceToFileExtensionMap.put("rStageAdjoinList2", ".sal2");
        resourceToFileExtensionMap.put("rStageConnect", ".scc");
        resourceToFileExtensionMap.put("rStageCustom", ".sca");
        resourceToFileExtensionMap.put("rStageCustomParts", ".scp");
        resourceToFileExtensionMap.put("rStageCustomPartsEx", ".scpx");
        resourceToFileExtensionMap.put("rStageInfo", ".sti");
        resourceToFileExtensionMap.put("rStageJoint", ".sja");
        resourceToFileExtensionMap.put("rStageList", ".slt");
        resourceToFileExtensionMap.put("rStageMap", ".smp");
        resourceToFileExtensionMap.put("rStageToSpot", ".sts");
        resourceToFileExtensionMap.put("rStaminaDecTbl", ".sdt");
        resourceToFileExtensionMap.put("rStarCatalog", ".stc");
        resourceToFileExtensionMap.put("rStartPos", ".stp");
        resourceToFileExtensionMap.put("rStartPos::Info", ".stp_Info");
        resourceToFileExtensionMap.put("rStartPosArea", ".sta");
        resourceToFileExtensionMap.put("rStatusCheck", ".sck");
        resourceToFileExtensionMap.put("rStatusGainTable", ".sg_tbl");
        resourceToFileExtensionMap.put("rSwingModel", ".swm");
        resourceToFileExtensionMap.put("rTable", ".rTable");
        resourceToFileExtensionMap.put("rTargetCursorOffset", ".tco");
        resourceToFileExtensionMap.put("rTbl2Base", ".rTbl2Base");
        resourceToFileExtensionMap.put("rTbl2ChatMacro", ".tcm");
        resourceToFileExtensionMap.put("rTbl2ClanEmblemTextureId", ".ceti_tbl");
        resourceToFileExtensionMap.put("rTbl2ItemIconId", ".tii");
        resourceToFileExtensionMap.put("rTblMenuComm", ".tmc");
        resourceToFileExtensionMap.put("rTblMenuOption", ".tmo");
        resourceToFileExtensionMap.put("rTblMenuOption::cCaption", ".rTblMenuOption_cCaption");
        resourceToFileExtensionMap.put("rTblMenuOption::cCtgr", ".rTblMenuOption_cCtgr");
        resourceToFileExtensionMap.put("rTblMenuOption::cData", ".rTblMenuOption_cData");
        resourceToFileExtensionMap.put("rTblMenuOption::cPulldown", ".rTblMenuOption_cPulldown");
        resourceToFileExtensionMap.put("rTblMenuOption::cTab", ".rTblMenuOption_cTab");
        resourceToFileExtensionMap.put("rTexDetailEdit", ".tde");
        resourceToFileExtensionMap.put("rTexDetailEdit::DetailParam", ".tde_DetailParam");
        resourceToFileExtensionMap.put("rTexture", ".tex");
        resourceToFileExtensionMap.put("rTextureJpeg", ".tex");
        resourceToFileExtensionMap.put("rTextureMemory", ".tex");
        resourceToFileExtensionMap.put("rTexturePNG", ".tex");
        resourceToFileExtensionMap.put("rThinkParamRange", ".thp_range");
        resourceToFileExtensionMap.put("rThinkParamTimer", ".thp_timer");
        resourceToFileExtensionMap.put("rTutorialDialogMessage", ".tdm");
        resourceToFileExtensionMap.put("rTutorialList", ".tlt");
        resourceToFileExtensionMap.put("rTutorialQuestGroup", ".tqg");
        resourceToFileExtensionMap.put("rTutorialTargetList", ".ttl");
        resourceToFileExtensionMap.put("rVertices", ".vts");
        resourceToFileExtensionMap.put("rVfxLightInfluence", ".eli");
        resourceToFileExtensionMap.put("rVibration", ".vib");
        resourceToFileExtensionMap.put("rWarpLocation", ".wal");
        resourceToFileExtensionMap.put("rWaypoint", ".wpt");
        resourceToFileExtensionMap.put("rWaypoint2", ".wp2");
        resourceToFileExtensionMap.put("rWeaponOffset", ".wpn_ofs");
        resourceToFileExtensionMap.put("rWeaponResTable", ".wrt");
        resourceToFileExtensionMap.put("rWeatherEffectParam", ".wep");
        resourceToFileExtensionMap.put("rWeatherFogInfo", ".wtf");
        resourceToFileExtensionMap.put("rWeatherInfoTbl", ".wta");
        resourceToFileExtensionMap.put("rWeatherParamEfcInfo", ".wte");
        resourceToFileExtensionMap.put("rWeatherParamInfoTbl", ".wtl");
        resourceToFileExtensionMap.put("rWeatherStageInfo", ".wsi");
        resourceToFileExtensionMap.put("rWepCateResTbl", ".wcrt");
        resourceToFileExtensionMap.put("rZone", ".zon");

        resourceToFileExtensionMap.forEach((key, value) -> {
            long id = FrameworkResourcesUtil.convertDataTypeStringToDataTypeId(key);
            jamCrcToResourceMap.put(id, key);
            jamCrcToFileExtensionMap.put(id, value);
        });
    }

    private FrameworkResourcesUtil() {

    }

    public static String getFileExtension(String resourceDataTypeName) {
        String fileExtension = resourceToFileExtensionMap.get(resourceDataTypeName);
        if (fileExtension == null) {
            fileExtension = "." + resourceDataTypeName;
            log.warn("Unable to determine file extension for resource class '{}', defaulting to '{}'.", resourceDataTypeName, fileExtension);
        }
        return fileExtension;
    }

    public static String getFileExtension(long crc) {
        String fileExtension = jamCrcToFileExtensionMap.getOrDefault(crc, String.valueOf(crc));
        if (StringUtil.isNumeric(fileExtension)) {
            log.warn("File extension for JamCRC '{}' could not be found", crc);
        }
        return fileExtension;
    }

    public static String getFrameworkResourceClassNameByCrc(long crc) {
        String className = jamCrcToResourceMap.getOrDefault(crc, String.valueOf(crc));
        if (StringUtil.isNumeric(className)) {
            log.warn("Class name for JamCRC '{}' could not be found", crc);
        }
        return className;
    }

    public static BigInteger convertToResourceId(String dataTypeName, String path) {
        return convertToResourceId(CrcUtil.jamCrc32(dataTypeName), path);
    }

    public static BigInteger convertToResourceId(long dataTypeId, String path) {
        return BigInteger.valueOf(dataTypeId).shiftLeft(32).or(BigInteger.valueOf(CrcUtil.frameworkCrc32(path)));
    }

    public static long convertResourceIdToPathId(BigInteger resourceId) {
        return resourceId.longValueExact() & 0xFFFF_FFFFL;
    }

    public static long convertResourceIdToTagId(BigInteger resourceId) {
        return resourceId.longValueExact() >> 32;
    }

    /**
     * @return an DTI->mID equivalent
     */
    public static long convertDataTypeStringToDataTypeId(String dataTypeName) {
        return CrcUtil.jamCrc32(dataTypeName);
    }

    /**
     * @return an ARC_TAGID equivalent
     */
    public static long convertResourceStringToTagId(String resourceName) {
        return CrcUtil.frameworkCrc32(resourceName);
    }

    /**
     * @return an ARC_SEARCHID equivalent
     */
    public static long convertResourceStringToSearchId(String resourceName) {
        return CrcUtil.frameworkCrc32(resourceName);
    }

    public static long convertResourcePathToPathId(String path) {
        return CrcUtil.frameworkCrc32(path);
    }

    /**
     * @return a number corresponding to an ALA file name
     */
    public static long convertTagIdToTargetTagNumber(long tagId) {
        return tagId & 0x7F;
    }
}
