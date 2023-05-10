package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

public enum ExtensionMapTarget34 {
    rCycleContentsSortieInfo("csi", "csi\0", 0, null),
    rDamageCounterInfo("counter_Adj", "counter_Adj\0", 0, null),
    rDarkSkyParam("dsp", "dsp\0", 0, null),
    rDragonSkillColorParam("dscp", "dscp\0", 0, null),
    rDragonSkillEnhanceParam("dse", "dse\0", 0, null),
    rDragonSkillLevelParam("dsl", "dsl\0", 0, null),
    rDragonSkillParam("dsd", "dsd\0", 0, null),
    rEmparam("emparam", "emparam\0", 0, null),
    rEndContentsSortieInfo("esi", "esi\0", 0, null),
    rEnhancedParamList("epl", "epl\0", 0, null),
    rEventResTable("evtr", "evtr\0", 0, null),
    rEventViewerList("evlst", "evlst\0", 0, null),
    rEventViewerSetInfo("evsi", "evsi\0", 0, null),
    rEvidenceList("evd", "evd\0", 0, null),
    rFurnitureAccessories("fad", "fad\0", 0, null),
    rHideNpcNameInfo("hni", "hni\0", 0, null),
    rItemEquipJobInfoList("eir", "eir\0", 0, null),
    rJobCustomParam("jcp", "jcp\0", 0, null),
    rJukeBoxItem("jbi", "jbi\0", 0, null),
    rKeyCommand("kcm", "kcm\0", 0, null),
    rMandraActionParam("map", "map\0", 0, null),
    rMandraCharaMake("mcm", "mcm\0", 0, null),
    rMandraMotCombine("mmc", "mmc\0", 0, null),
    rMandraReaction("mdr", "mdr\0", 0, null),
    rNavConnect("nvc", "nvc\0", 0, null),
    rOmParamEx("ompe", "ompe\0", 0, null),
    rOmParamPart("ompp", "ompp\0", 0, null),
    rOutfitInfo("ofi", "ofi\0", 0, null),
    rPackageQuestInfo("pqi", "pqi\0", 0, null),
    rPawnSpSkillCategoryUI("pssc", "pssc\0", 0, null),
    rPawnSpSkillLevelUI("pssl", "pssl\0", 0, null),
    rPawnThinkControl("ptc", "ptc\0", 0, null),
    rPawnThinkLevelUp("plu", "plu\0", 0, null),
    rPlanetariumItem("planet", "planet\0", 0, null),
    rRecommendDragonSkill("rds", "rds\0", 0, null),
    rSitePack("sit", "sit\0", 0, null),
    rStageAdjoinList2("sal2", "sal2\0", 0, null);

    public final String fileExtension;
    public final String magic;
    public final long version;
    public final Class<? extends Deserializer> deserializer;

    ExtensionMapTarget34(String fileExtension, String magic, long version, Class<? extends Deserializer> deserializer) {
        this.fileExtension = fileExtension;
        this.magic = magic;
        this.version = version;
        this.deserializer = deserializer;
    }

    @Override
    public String toString() {
        return "{\n\"fileExtension\": \"" + fileExtension + "\",\n"
                + (magic != null ? "\"magic\": \"" + magic + "\",\n" : "")
                + "\"version\": " + version + "\n}";
    }
}
