package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import java.util.Arrays;
import java.util.List;

public enum ClientResourceFileUnknown {
    rAI(".ais", new FileHeader("ais\0", 111, 4)),
    rAIConditionTree(".cdt", new FileHeader("cdt\0", 111, 4)),
    rAIDynamicLayout(".dpth", new FileHeader("dpth\0", 111, 4)),
    rAIFSMList(".fsl", new FileHeader("fsl\0", 111, 4)),
    rAIPathBase(".are", new FileHeader("are\0", 111, 4)),
    rAIWayPoint(".way", new FileHeader("way\0", 111, 4)),
    rAIWayPointGraph(".gway", new FileHeader("gway\0", 111, 4)),
    rArchiveImport(".aimp", new FileHeader("aimp\0", 111, 4)),
    rAreaHitShape(".ahs", new FileHeader("ahs\0", 111, 4)),
    rAtDfRateRaid(".atdf_raid", new FileHeader("atdf_raid\0", 111, 4)),
    rBrowserUITableData(".but", new FileHeader("but\0", 111, 4)),
    rCharacterEditPersonalityPalette(".edt_personality_pal", new FileHeader("edt_personality_pal\0", 111, 4)),
    rCharacterEditTalkLvPalette(".edt_talk_pal", new FileHeader("edt_talk_pal\0", 111, 4)),
    rCnsJointOffset(".jof", new FileHeader("jof\0", 111, 4)),
    rCnsLookAt(".lat", new FileHeader("lat\0", 111, 4)),
    rCnsMatrix(".mtx", new FileHeader("mtx\0", 111, 4)),
    rCnsTinyIK(".tik", new FileHeader("tik\0", 111, 4)),
    rCollGeom(".coll_geom", new FileHeader("coll_geom\0", 111, 4)),
    rCollIndex(".coll_idx", new FileHeader("coll_idx\0", 111, 4)),
    rCollNode(".coll_node", new FileHeader("coll_node\0", 111, 4)),
    rCollisionHeightField(".sbch", new FileHeader("sbch\0", 111, 4)),
    rCollisionObj(".obc", new FileHeader("obc\0", 111, 4)),
    rConstModelParam(".cmp", new FileHeader("cmp\0", 111, 4)),
    rConvexHull(".hul", new FileHeader("hul\0", 111, 4)),
    rCycleContentsSortieInfo(".csi", new FileHeader("csi\0", 111, 4)),
    rDDOBenchmark(".bmk", new FileHeader("bmk\0", 111, 4)),
    rDamageCounterInfo(".counter_Adj", new FileHeader("counter_Adj\0", 111, 4)),
    rDarkSkyParam(".dsp", new FileHeader("dsp\0", 111, 4)),
    rDragonSkillColorParam(".dscp", new FileHeader("dscp\0", 111, 4)),
    rDragonSkillEnhanceParam(".dse", new FileHeader("dse\0", 111, 4)),
    rDragonSkillLevelParam(".dsl", new FileHeader("dsl\0", 111, 4)),
    rDragonSkillParam(".dsd", new FileHeader("dsd\0", 111, 4)),
    rDynamicSbc(".dsc", new FileHeader("dsc\0", 111, 4)),
    rEditConvert(".edc", new FileHeader("edc\0", 111, 4)),
    rEmCategory(".ecg", new FileHeader("ecg\0", 111, 4)),
    rEmMsgTable(".emt", new FileHeader("emt\0", 111, 4)),
    rEndContentsSortieInfo(".esi", new FileHeader("esi\0", 111, 4)),
    rEnhancedParamList(".epl", new FileHeader("epl\0", 111, 4)),
    rEnumDef(".edf", new FileHeader("edf\0", 111, 4)),
    rEquipCaptureList(".ecl", new FileHeader("ecl\0", 111, 4)),
    rEventResTable(".evtr", new FileHeader("evtr\0", 111, 4)),
    rEventViewerList(".evlst", new FileHeader("evlst\0", 111, 4)),
    rEventViewerSetInfo(".evsi", new FileHeader("evsi\0", 111, 4)),
    rEvidenceList(".evd", new FileHeader("evd\0", 111, 4)),
    rFunctionList(".ftl", new FileHeader("ftl\0", 111, 4)),
    rFurnitureAccessories(".fad", new FileHeader("fad\0", 111, 4)),
    rGUIPhotoFrame(".pho", new FileHeader("pho\0", 111, 4)),
    rGeometry2(".geo2", new FileHeader("geo2\0", 111, 4)),
    rGeometry2Group(".geog", new FileHeader("geog\0", 111, 4)),
    rGeometry3(".geo3", new FileHeader("geo3\0", 111, 4)),
    rGraphPatch(".gpt", new FileHeader("gpt\0", 111, 4)),
    rGrass2(".gr2", new FileHeader("gr2\0", 111, 4)),
    rGrass2Setting(".gr2s", new FileHeader("gr2s\0", 111, 4)),
    rHideNpcNameInfo(".hni", new FileHeader("hni\0", 111, 4)),
    rISC(".isc", new FileHeader("isc\0", 111, 4)),
    rImplicitSurface(".is", new FileHeader("is\0", 111, 4)),
    rIniLocal(".ini", new FileHeader("ini\0", 111, 4)),
    rIsEquipOneOfSeveral(".ieo", new FileHeader("ieo\0", 111, 4)),
    rItemEquipJobInfoList(".eir", new FileHeader("eir\0", 111, 4)),
    rJobCustomParam(".jcp", new FileHeader("jcp\0", 111, 4)),
    rJukeBoxItem(".jbi", new FileHeader("jbi\0", 111, 4)),
    rKeyCommand(".kcm", new FileHeader("kcm\0", 111, 4)),
    rLineBuilder(".mlb", new FileHeader("mlb\0", 111, 4)),
    rMandraActionParam(".map", new FileHeader("map\0", 111, 4)),
    rMandraCharaMake(".mcm", new FileHeader("mcm\0", 111, 4)),
    rMandraMotCombine(".mmc", new FileHeader("mmc\0", 111, 4)),
    rMandraReaction(".mdr", new FileHeader("mdr\0", 111, 4)),
    rMovieOnDisk(".wmv", new FileHeader("wmv\0", 111, 4)),
    rMovieOnDiskInterMediate(".wmv", new FileHeader("wmv\0", 111, 4)),
    rMovieOnMemory(".mem.wmv", new FileHeader("mem.wmv\0", 111, 4)),
    rMovieOnMemoryInterMediate(".mem.wmv", new FileHeader("mem.wmv", 111, 4)),
    rNavConnect(".nvc", new FileHeader("nvc\0", 111, 4)),
    rNulls(".nls", new FileHeader("nls\0", 111, 4)),
    rOmLoadList(".oll", new FileHeader("oll\0", 111, 4)),
    rOmParamEx(".ompe", new FileHeader("ompe\0", 111, 4)),
    rOmParamPart(".ompp", new FileHeader("ompp\0", 111, 4)),
    rOutfitInfo(".ofi", new FileHeader("ofi\0", 111, 4)),
    rPCSimpleDebuggerTarget(".pdd", new FileHeader("pdd\0", 111, 4)),
    rPackageQuestInfo(".pqi", new FileHeader("pqi\0", 111, 4)),
    rPawnSpSkillCategoryUI(".pssc", new FileHeader("pssc\0", 111, 4)),
    rPawnSpSkillLevelUI(".pssl", new FileHeader("pssl\0", 111, 4)),
    rPawnThinkControl(".ptc", new FileHeader("ptc\0", 111, 4)),
    rPawnThinkLevelUp(".plu", new FileHeader("plu\0", 111, 4)),
    rPhoteNGItem(".pni", new FileHeader("pni\0", 111, 4)),
    rPlanetariumItem(".planet", new FileHeader("planet\0", 111, 4)),
    rRagdoll(".rdd", new FileHeader("rdd\0", 111, 4)),
    rRecommendDragonSkill(".rds", new FileHeader("rds\0", 111, 4)),
    rRegionBreakInfo(".erb", new FileHeader("erb\0", 111, 4)),
    rRegionStatusCtrlTable(".rsc", new FileHeader("rsc\0", 111, 4)),
    rSceneTexture(".stex", new FileHeader("stex\0", 111, 4)),
    rShader2(".mfx", new FileHeader("mfx\0", 111, 4)),
    rShaderCache(".sch", new FileHeader("sch\0", 111, 4)),
    rShaderPackage(".spkg", new FileHeader("spkg\0", 111, 4)),
    rSimpleComrChatComData(".ccd", new FileHeader("ccd\0", 111, 4)),
    rSitePack(".sit", new FileHeader("sit\0", 111, 4)),
    rSoundPhysicsJoint(".spjr", new FileHeader("spjr\0", 111, 4)),
    rSoundPhysicsList(".splr", new FileHeader("splr\0", 111, 4)),
    rSoundPhysicsRigidBody(".sprr", new FileHeader("sprr\0", 111, 4)),
    rSoundPhysicsSoftBody(".spsr", new FileHeader("spsr\0", 111, 4)),
    rSoundRangeEqSet(".sreq", new FileHeader("sreq\0", 111, 4)),
    rSoundSimpleCurve(".sscr", new FileHeader("sscr\0", 111, 4)),
    rSoundSourceOggVorbis(".sngw", new FileHeader("sngw\0", 111, 4)),
    rStageAdjoinList2(".sal2", new FileHeader("sal2\0", 111, 4)),
    rTbl2ClanEmblemTextureId(".ceti_tbl", new FileHeader("ceti_tbl\0", 111, 4)),
    rTbl2ItemIconId(".tii", new FileHeader("tii\0", 111, 4)),
    rTextureJpeg(".tex", new FileHeader("tex\0", 111, 4)),
    rTextureMemory(".tex", new FileHeader("tex\0", 111, 4)),
    rTexturePNG(".tex", new FileHeader("tex\0", 111, 4)),
    rThinkParamRange(".thp_range", new FileHeader("thp_range\0", 111, 4)),
    rThinkParamTimer(".thp_timer", new FileHeader("thp_timer\0", 111, 4)),
    rTutorialTargetList(".ttl", new FileHeader("ttl\0", 111, 4)),
    rVertices(".vts", new FileHeader("vts\0", 111, 4)),
    rVfxLightInfluence(".eli", new FileHeader("eli\0", 111, 4)),
    rVibration(".vib", new FileHeader("vib\0", 111, 4)),
    rkThinkData(".pen", new FileHeader("pen\0", 111, 4)),
    uSoundSubMixerCurrentSubMixer(".smxr", new FileHeader("smxr\0", 111, 4));

    public final String fileExtension;
    public final FileHeader fileHeader;

    ClientResourceFileUnknown(String fileExtension, FileHeader fileHeader) {
        this.fileExtension = fileExtension;
        this.fileHeader = fileHeader;
    }

    public static ClientResourceFileUnknown findByFileExtension(String fileExtension) {
        return Arrays.stream(ClientResourceFileUnknown.values()).filter(value -> fileExtension.equals(value.fileExtension)).findFirst().orElse(null);
    }

    public static List<String> getSupportedFileExtensions() {
        return Arrays.stream(ClientResourceFileUnknown.values()).map(extensionMap -> extensionMap.fileExtension).toList();
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"#\": " + ordinal() + ",\n"
                + "\"fileExtension\": \"" + fileExtension + "\",\n"
                + (fileHeader.magicString != null ? "\"magic\": \"" + fileHeader.magicString + "\",\n" : "")
                + "\"version\": " + fileHeader.versionNumber
                + "\n}";
    }
}
