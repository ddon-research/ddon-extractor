package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import java.util.Arrays;
import java.util.List;

public enum ClientResourceFile34 {
    rCycleContentsSortieInfo(".csi", new FileHeader("csi\0", 111, 4)),
    rDamageCounterInfo(".counter_Adj", new FileHeader("counter_Adj\0", 111, 4)),
    rDarkSkyParam(".dsp", new FileHeader("dsp\0", 111, 4)),
    rDragonSkillColorParam(".dscp", new FileHeader("dscp\0", 111, 4)),
    rDragonSkillEnhanceParam(".dse", new FileHeader("dse\0", 111, 4)),
    rDragonSkillLevelParam(".dsl", new FileHeader("dsl\0", 111, 4)),
    rDragonSkillParam(".dsd", new FileHeader("dsd\0", 111, 4)),
    rEmparam(".emparam", new FileHeader("emparam\0", 111, 4)),
    rEndContentsSortieInfo(".esi", new FileHeader("esi\0", 111, 4)),
    rEnhancedParamList(".epl", new FileHeader("epl\0", 111, 4)),
    rEventResTable(".evtr", new FileHeader("evtr\0", 111, 4)),
    rEventViewerList(".evlst", new FileHeader("evlst\0", 111, 4)),
    rEventViewerSetInfo(".evsi", new FileHeader("evsi\0", 111, 4)),
    rEvidenceList(".evd", new FileHeader("evd\0", 111, 4)),
    rFurnitureAccessories(".fad", new FileHeader("fad\0", 111, 4)),
    rHideNpcNameInfo(".hni", new FileHeader("hni\0", 111, 4)),
    rItemEquipJobInfoList(".eir", new FileHeader("eir\0", 111, 4)),
    rJobCustomParam(".jcp", new FileHeader("jcp\0", 111, 4)),
    rJukeBoxItem(".jbi", new FileHeader("jbi\0", 111, 4)),
    rKeyCommand(".kcm", new FileHeader("kcm\0", 111, 4)),
    rMandraActionParam(".map", new FileHeader("map\0", 111, 4)),
    rMandraCharaMake(".mcm", new FileHeader("mcm\0", 111, 4)),
    rMandraMotCombine(".mmc", new FileHeader("mmc\0", 111, 4)),
    rMandraReaction(".mdr", new FileHeader("mdr\0", 111, 4)),
    rNavConnect(".nvc", new FileHeader("nvc\0", 111, 4)),
    rOmParamEx(".ompe", new FileHeader("ompe\0", 111, 4)),
    rOmParamPart(".ompp", new FileHeader("ompp\0", 111, 4)),
    rOutfitInfo(".ofi", new FileHeader("ofi\0", 111, 4)),
    rPackageQuestInfo(".pqi", new FileHeader("pqi\0", 111, 4)),
    rPawnSpSkillCategoryUI(".pssc", new FileHeader("pssc\0", 111, 4)),
    rPawnSpSkillLevelUI(".pssl", new FileHeader("pssl\0", 111, 4)),
    rPawnThinkControl(".ptc", new FileHeader("ptc\0", 111, 4)),
    rPawnThinkLevelUp(".plu", new FileHeader("plu\0", 111, 4)),
    rPlanetariumItem(".planet", new FileHeader("planet\0", 111, 4)),
    rRecommendDragonSkill(".rds", new FileHeader("rds\0", 111, 4)),
    rSitePack(".sit", new FileHeader("sit\0", 111, 4)),
    rStageAdjoinList2(".sal2", new FileHeader("sal2\0", 111, 4));

    public final String fileExtension;
    public final FileHeader fileHeader;

    ClientResourceFile34(String fileExtension, FileHeader fileHeader) {
        this.fileExtension = fileExtension;
        this.fileHeader = fileHeader;
    }

    public static ClientResourceFile findByFileExtension(String fileExtension) {
        return Arrays.stream(ClientResourceFile.values()).filter(value -> fileExtension.equals(value.fileExtension)).findFirst().orElse(null);
    }

    public static List<String> getSupportedFileExtensions() {
        return Arrays.stream(ClientResourceFile.values()).map(extensionMap -> extensionMap.fileExtension).toList();
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
