---
sidebar_position: 6
title: Extension Mapping
description: Comprehensive mapping of file extensions to resource types, DTI.txt, and FrameworkResourcesUtil.
---

# Extension Mapping

## Overview

`ddon-extractor` uses a multi-layered mapping system to associate file extensions with deserializers:

1. **`ClientResourceFileExtension`** enum — maps extension strings to symbolic resource type names.
2. **`ClientResourceFileManager`** — maps `(extension, FileHeader)` pairs to `ClientResourceFile` objects containing
   deserializers. Note: This is due to the fact that the extension by itself is not enough, since across seasons the
   extension might become deprecated and re-used. There are also some file headers that are not enough by themselves,
   especially generic table-derivatives that only contain version information - only in combination with the file
   extension do they become uniquely identifiable.
3. **`FrameworkResourcesUtil`** / `DTI.txt` — maps MT Framework resource class names to file extensions (e.g.,
   `rGUIMessage` → `.gmd`).

## File Extension → Resource Type Mapping

The `ClientResourceFileExtension` enum's static initializer defines ~200 extension-to-resource mappings. These are the
file types for which ddon-extractor has implemented or registered deserializers. The complete table:

| Extension        | Resource Type                  | Description                                  |
|------------------|--------------------------------|----------------------------------------------|
| `.2EA55F30`      | `rPlayerExpTable`              | Player experience table (JamCRC fallback)    |
| `.3FD51519`      | `rCraftSkillGain`              | Craft skill gain (JamCRC fallback)           |
| `.4BB8A7C5`      | `rCraftSkillBurst`             | Craft skill burst (JamCRC fallback)          |
| `.46ECE09C`      | `rCraftSkillStr`               | Craft skill strength (JamCRC fallback)       |
| `.5362A636`      | `rPartsCtrlTable`              | Parts control table (JamCRC fallback)        |
| `.5810D1F1`      | `rCraftRecipe`                 | Craft recipe (JamCRC fallback)               |
| `.60BA5E0B`      | `rCraftWepQualityParam`        | Craft weapon quality param (JamCRC fallback) |
| `.767645BE`      | `rCraftArmQualityParam`        | Craft armor quality param (JamCRC fallback)  |
| `.aad`           | `rAbilityAddData`              | Ability add data                             |
| `.abd`           | `rAbilityData`                 | Ability data                                 |
| `.abl`           | `rAbilityList`                 | Ability list                                 |
| `.ach`           | `rAchievementHeader`           | Achievement header                           |
| `.acv`           | `rAchievement`                 | Achievement                                  |
| `.ajp`           | `rAdjustParam`                 | Job adjust parameters                        |
| `.ala`           | `rArchiveListArray`            | Archive list array                           |
| `.alp`           | `rAdjLimitParam`               | Adjust limit parameters                      |
| `.aml`           | `rAnimalData`                  | Animal data                                  |
| `.amr`           | `rAreaMasterRankData`          | Area master rank data                        |
| `.ams`           | `rAreaMasterSpotData`          | Area master spot data                        |
| `.amsd`          | `rAreaMasterSpotDetailData`    | Area master spot detail data                 |
| `.aps`           | `rAIPawnSkillParamTbl`         | AI pawn skill param table                    |
| `.arc`           | `rArchive`                     | Archive (encrypted ARCC or reference ARCS)   |
| `.ari`           | `rAreaInfo`                    | Area info                                    |
| `.arj`           | `rAreaInfoJointArea`           | Area info joint area                         |
| `.ars`           | `rAreaInfoStage`               | Area info stage                              |
| `.bjt`           | `rBakeJoint`                   | Bake joint table                             |
| `.blow_save`     | `rBlowSaveEmLvParam`           | Blow save enemy level param                  |
| `.btb`           | `rBitTable`                    | Bit table                                    |
| `.caip`          | `rCaughtInfoParam`             | Caught info param                            |
| `.ccp`           | `rCraftCapPass`                | Craft cap pass                               |
| `.cda`           | `rCalcDamageAtdmAdj`           | Calc damage atdm adjust                      |
| `.cdarate`       | `rCalcDamageAtdmAdjRate`       | Calc damage atdm adjust rate                 |
| `.cdl`           | `rCalcDamageLvAdj`             | Calc damage level adjust                     |
| `.cdrr`          | `rCaughtDamageRateRefTbl`      | Caught damage rate ref table                 |
| `.cdrt`          | `rCaughtDamageRateTbl`         | Caught damage rate table                     |
| `.cee`           | `rCraftElementExp`             | Craft element exp                            |
| `.chant`         | `rMagicChantParam`             | Magic chant parameters                       |
| `.cip`           | `rCatchInfoParam`              | Catch info param                             |
| `.ckb`           | `rCraftSkillBurst`             | Craft skill burst                            |
| `.ckc`           | `rCraftSkillCost`              | Craft skill cost                             |
| `.ckg`           | `rCraftSkillGain`              | Craft skill gain                             |
| `.cks`           | `rCraftSkillSpd`               | Craft skill speed                            |
| `.ckst`          | `rCraftSkillStr`               | Craft skill strength                         |
| `.cpe`           | `rCharParamEnemy`              | Character param enemy                        |
| `.cqa`           | `rCraftArmQualityParam`        | Craft armor quality param                    |
| `.cqi`           | `rCycleQuestInfo`              | Cycle quest info                             |
| `.cqr`           | `rCraftQuality`                | Craft quality                                |
| `.cqw`           | `rCraftWepQualityParam`        | Craft weapon quality param                   |
| `.crs`           | `rChildRegionStatusParam`      | Child region status param                    |
| `.csd`           | `rCustomSkillData`             | Custom skill data                            |
| `.csi`           | `rCycleContentsSortieInfo`     | Cycle contents sortie info                   |
| `.cuex`          | `rCraftUpGradeExp`             | Craft upgrade exp                            |
| `.dds`           | `DirectDrawSurface`            | DDS texture                                  |
| `.dgm`           | `rGUIDogmaOrb`                 | GUI dogma orb                                |
| `.dmi`           | `rDungeonMarker`               | Dungeon marker                               |
| `.dtt`           | `rEmDmgTimerTbl`               | Enemy damage timer table                     |
| `.ebi_sv`        | `rEmBaseInfoSv`                | Enemy base info (server)                     |
| `.ebs`           | `rEnemyBloodStain`             | Enemy blood stain                            |
| `.edt_color_def` | `rCharacterEditColorDef`       | Character edit color definition              |
| `.edt_tex_pal`   | `rCharacterEditTexturePalette` | Character edit texture palette               |
| `.edt_voice_pal` | `rCharacterEditVoicePalette`   | Character edit voice palette                 |
| `.edv`           | `rEmDamageDirInfo`             | Enemy damage direction info                  |
| `.eir`           | `rItemEquipJobInfoList`        | Item equip job info list (S3)                |
| `.ele`           | `rEnemyLocalEst`               | Enemy local EST                              |
| `.eli`           | `rVfxLightInfluence`           | VFX light influence                          |
| `.ema`           | `rEnemyMaterialTable`          | Enemy material table                         |
| `.emg`           | `rEnemyGroup`                  | Enemy group                                  |
| `.eoc`           | `rOcdElectricParam`            | OCD electric param                           |
| `.epl`           | `rEnhancedParamList`           | Enhanced param list (S3)                     |
| `.equip_preset`  | `rEquipPreset`                 | Equipment preset                             |
| `.era`           | `rEnemyReactResEx`             | Enemy react res ex                           |
| `.esi`           | `rEndContentsSortieInfo`       | End contents sortie info                     |
| `.esl`           | `rEmScaleTable`                | Enemy scale table                            |
| `.esn`           | `rEmSoundTable`                | Enemy sound table                            |
| `.esp`           | `rEditStageParam`              | Edit stage param                             |
| `.est`           | `rEnemyStatusChange`           | Enemy status change                          |
| `.evd`           | `rEvidenceList`                | Evidence list (S3)                           |
| `.evl`           | `rEvaluationTable`             | Evaluation table                             |
| `.evp`           | `rEventParam`                  | Event param                                  |
| `.evsi`          | `rEventViewerSetInfo`          | Event viewer set info                        |
| `.ewk`           | `rEmWorkRateTable`             | Enemy work rate table                        |
| `.ewp`           | `rEmWarpParam`                 | Enemy warp param                             |
| `.exp`           | `rPlayerExpTable`              | Player experience table                      |
| `.faa`           | `rFieldAreaAdjoinList`         | Field area adjoin list                       |
| `.fal`           | `rFieldAreaList`               | Field area list                              |
| `.fmd`           | `rFieldMapData`                | Field map data                               |
| `.fmi`           | `rFieldAreaMarkerInfo`         | Field area marker info                       |
| `.fnd`           | `rFurnitureData`               | Furniture data (S2+)                         |
| `.fng`           | `rFurnitureGroup`              | Furniture group (S2+)                        |
| `.fni`           | `rFurnitureItem`               | Furniture item (S2+)                         |
| `.fnl`           | `rFurnitureLayout`             | Furniture layout (S2+)                       |
| `.fsm`           | `rAIFSM`                       | AI FSM                                       |
| `.gat`           | `rGatheringItem`               | Gathering item                               |
| `.gmd`           | `rGUIMessage`                  | GUI message data                             |
| `.gmp`           | `rGUIMapSetting`               | GUI map setting                              |
| `.gpl`           | `rLayoutGroupParamList`        | Layout group param list                      |
| `.hmcs`          | `rHumanEnemyCustomSkill`       | Human enemy custom skill                     |
| `.hmeq`          | `rHumanEnemyEquip`             | Human enemy equipment                        |
| `.ipa`           | `rItemList`                    | Item list                                    |
| `.jbi`           | `rJukeBoxItem`                 | Jukebox item (S3)                            |
| `.jlt2`          | `rJobLevelUpTbl2`              | Job level up table                           |
| `.jmc`           | `rJobMasterCtrl`               | Job master control                           |
| `.jmp`           | `rJumpParamTbl`                | Jump param table                             |
| `.jnt_info`      | `rJointInfo`                   | Joint info                                   |
| `.jnt_order`     | `rJointOrder`                  | Joint order                                  |
| `.jobbase`       | `rJobBaseParam`                | Job base parameters                          |
| `.jtq`           | `rJobTutorialQuestList`        | Job tutorial quest list                      |
| `.kctt`          | `rKeyConfigTextTable`          | Key config text table                        |
| `.lai`           | `rLandInfo`                    | Land info                                    |
| `.lcd`           | `rLocationData`                | Location data                                |
| `.lcp`           | `rLargeCameraParam`            | Large camera param                           |
| `.lop`           | `rLayoutPreset`                | Layout preset                                |
| `.lot`           | `rLayout`                      | Layout                                       |
| `.lup`           | `rEmLvUpParam`                 | Enemy level up param                         |
| `.map`           | `rMandraActionParam`           | Mandra action param                          |
| `.mcw`           | `rMagicCommandWord`            | Magic command word                           |
| `.mgcc`          | `rMagicCommandList`            | Magic command list                           |
| `.mra`           | `rMyRoomActParam`              | My room act param                            |
| `.msd`           | `rMapSpotData`                 | Map spot data                                |
| `.msl`           | `rMapSpotStageList`            | Map spot stage list                          |
| `.mss`           | `rMsgSet`                      | Message set                                  |
| `.nav`           | `rNavigationMesh`              | Navigation mesh                              |
| `.nci`           | `rNpcConstItem`                | NPC const item                               |
| `.ncs`           | `rNpcCustomSkill`              | NPC custom skill                             |
| `.ndp`           | `rNamedParam`                  | Named param                                  |
| `.nll`           | `rNpcLedgerList`               | NPC ledger list                              |
| `.nmp`           | `rNpcMeetingPlace`             | NPC meeting place                            |
| `.nsd`           | `rNormalSkillData`             | Normal skill data                            |
| `.nsp`           | `rNpcIsNoSetPS3`               | NPC is no set PS3                            |
| `.oIp`           | `rOcdImmuneParamRes`           | OCD immune param res                         |
| `.omk`           | `rOmKey`                       | OM key                                       |
| `.omp`           | `rOmParam`                     | OM param (S1/S2)                             |
| `.ompp`          | `rOmParamPart`                 | OM param part (S3)                           |
| `.osp`           | `rOcdStatusParamRes`           | OCD status param res                         |
| `.pam`           | `rAIPawnAutoMotionTbl`         | AI pawn auto motion table                    |
| `.pao`           | `rAIPawnOrder`                 | AI pawn order                                |
| `.pas`           | `rAIPawnActNoSwitch`           | AI pawn act no switch                        |
| `.paw`           | `rAIPawnAutoWordTbl`           | AI pawn auto word table                      |
| `.pep`           | `rAIPawnEmParam`               | AI pawn enemy param                          |
| `.phs`           | `rPrologueHmStatus`            | Prologue HM status                           |
| `.planet`        | `rPlanetariumItem`             | Planetarium item (S3)                        |
| `.ppr`           | `rPartnerReactParam`           | Partner react param                          |
| `.ppt`           | `rPartnerPawnTalk`             | Partner pawn talk                            |
| `.pqi`           | `rPackageQuestInfo`            | Package quest info                           |
| `.pqt`           | `rPawnQuestTalk`               | Pawn quest talk                              |
| `.prs`           | `rParentRegionStatusParam`     | Parent region status param                   |
| `.psi`           | `rPlPartsInfo`                 | Player parts info                            |
| `.ptc`           | `rPartsCtrlTable`              | Parts control table                          |
| `.push_rate`     | `rPushRate`                    | Push rate                                    |
| `.qhd`           | `rQuestHistoryData`            | Quest history data                           |
| `.qmi`           | `rQuestMarkerInfo`             | Quest marker info                            |
| `.qsq`           | `rQuestSequenceList`           | Quest sequence list                          |
| `.qst`           | `rQuestList`                   | Quest list                                   |
| `.qtd`           | `rQuestTextData`               | Quest text data                              |
| `.rac`           | `rReaction`                    | Reaction                                     |
| `.rag`           | `rRageTable`                   | Rage table                                   |
| `.rcp`           | `rCraftRecipe`                 | Craft recipe                                 |
| `.repgmdlist`    | `rReplaceWardGmdList`          | Replace ward GMD list                        |
| `.rsl`           | `rChildRegionStatusParamList`  | Child region status param list               |
| `.rtex`          | `rRenderTargetTexture`         | Render target texture                        |
| `.rwr`           | `rRoomWearParam`               | Room wear param                              |
| `.sal`           | `rStageAdjoinList`             | Stage adjoin list                            |
| `.sal2`          | `rStageAdjoinList2`            | Stage adjoin list 2                          |
| `.sbb`           | `rSoundBossBgm`                | Sound boss BGM                               |
| `.sbv`           | `rShrinkBlowValue`             | Shrink blow value                            |
| `.sca`           | `rStageCustom`                 | Stage custom                                 |
| `.scc`           | `rStageConnect`                | Stage connect                                |
| `.sce`           | `rScenario`                    | Scenario                                     |
| `.sck`           | `rStatusCheck`                 | Status check                                 |
| `.scp`           | `rStageCustomParts`            | Stage custom parts (S1/S2)                   |
| `.scpx`          | `rStageCustomPartsEx`          | Stage custom parts ex (S2/S3)                |
| `.sdl`           | `rScheduler`                   | Scheduler                                    |
| `.sdt`           | `rStaminaDecTbl`               | Stamina decrease table                       |
| `.sg_tbl`        | `rStatusGainTable`             | Status gain table                            |
| `.sja`           | `rStageJoint`                  | Stage joint                                  |
| `.slt`           | `rStageList`                   | Stage list                                   |
| `.smc`           | `rSituationMsgCtrl`            | Situation message control                    |
| `.smp`           | `rStageMap`                    | Stage map                                    |
| `.sn2`           | `rAISensor`                    | AI sensor                                    |
| `.sot`           | `rSoundOptData`                | Sound option data                            |
| `.spg_tbl`       | `rShopGoods`                   | Shop goods                                   |
| `.sri`           | `rShotReqInfo`                 | Shot req info                                |
| `.sri2`          | `rShotReqInfo2`                | Shot req info 2                              |
| `.sta`           | `rStartPosArea`                | Start position area                          |
| `.sti`           | `rStageInfo`                   | Stage info                                   |
| `.stp`           | `rStartPos`                    | Start position                               |
| `.sts`           | `rStageToSpot`                 | Stage to spot                                |
| `.tcm`           | `rTbl2ChatMacro`               | Table 2 chat macro                           |
| `.tco`           | `rTargetCursorOffset`          | Target cursor offset                         |
| `.tde`           | `rTexDetailEdit`               | Tex detail edit                              |
| `.tdm`           | `rTutorialDialogMessage`       | Tutorial dialog message                      |
| `.tex`           | `rTexture`                     | Texture                                      |
| `.tlt`           | `rTutorialList`                | Tutorial list                                |
| `.tqg`           | `rTutorialQuestGroup`          | Tutorial quest group                         |
| `.ujp`           | `rNpcIsUseJobParamEx`          | NPC is use job param ex                      |
| `.wal`           | `rWarpLocation`                | Warp location                                |
| `.wcrt`          | `rWepCateResTbl`               | Weapon category res table                    |
| `.wp2`           | `rWaypoint2`                   | Waypoint 2                                   |
| `.wpn_ofs`       | `rWeaponOffset`                | Weapon offset                                |
| `.wpt`           | `rWaypoint`                    | Waypoint                                     |
| `.wrt`           | `rWeaponResTable`              | Weapon res table                             |
| `.wsi`           | `rWeatherStageInfo`            | Weather stage info                           |
| `.wtf`           | `rWeatherFogInfo`              | Weather fog info                             |
| `.wtl`           | `rWeatherParamInfoTbl`         | Weather param info table                     |

## MtDTI, DTI.txt, and FrameworkResourcesUtil

### Background: MtDTI in the MT Framework

Capcom's **MT Framework** engine uses a runtime type system called **MtDTI** (Data Type Information). Every class in the
engine — resources, entities, collision shapes, packet structures, etc. — has a `MtDTI`, which provides:

- A **class name** string (e.g., `rGUIMessage`, `CDataItemList`, `nZone::ShapeInfoArea`)
- A **class CRC** (`MtDTI::mID`) — a JamCRC32 hash of the class name, used as a compact identifier in binary formats
- Support for **dynamic instantiation** (the engine can construct objects by CRC at runtime)
- An **inheritance hierarchy** (nested classes use `::` syntax, e.g., `rAcquirement::rAbilityAddData`)

Whenever a binary resource file embeds a reference to another class — such as an archive entry storing a resource type,
or an XFS file declaring its class structure — it either uses the **class CRC** or the string name.

### DTI.txt

The file `lib-api/src/main/resources/DTI.txt` is a **reverse-engineered collection of all class names** found across:

- **DWARF debug symbols** from the PS4 client binary (recorded in the `ddon-data` repository)
- **Symbol dumps** from the unpacked PC client executable

It contains **13,468 class entries**, one per line. These span the entire MT Framework class hierarchy:

| Prefix / Pattern         | Count | Examples                                                       |
|--------------------------|-------|----------------------------------------------------------------|
| `CData*`                 | ~509  | `CDataItemList`, `CDataAbilityParam`, `CDataQuestProcessState` |
| `r*` (resource classes)  | ~885  | `rGUIMessage`, `rTexture`, `rArchive`, `rAreaInfo`             |
| `Mt*` (engine internals) | ~200+ | `MtArray`, `MtObject`, `MtCollisionUtil::MtDtiObject`          |
| Nested (`::`)            | ~200+ | `rAI::TaskPerformanceInfo::LOD`, `AHShapePolygon::PosUnit`     |

Sample entries:

```
AHShapeBox
CDataAbilityParam
CDataItemList
MtCollisionUtil::MtDtiObject
nZone::ShapeInfoArea
rAI::TaskPerformanceInfo::LOD
rAcquirement::rAbilityAddData
rArchive
rGUIMessage
rTexture
```

### FrameworkResourcesUtil

At startup, `FrameworkResourcesUtil` loads all 13,468 entries from `DTI.txt` and builds three lookup maps:

#### 1. `resourceToFileExtensionMap` (class name → file extension)

**Default rule:** Every DTI entry gets a default extension of `"." + className.replace("::", "_")`.

For example, `rAI::TaskPerformanceInfo` → `.rAI_TaskPerformanceInfo`.

**Manual overrides:** ~420 entries have explicit file extension mappings that override the default. These are the known,
human-readable extensions derived from the PS4 debug symbols and game client analysis:

```java
resourceToFileExtensionMap.put("rGUIMessage", ".gmd");
resourceToFileExtensionMap.put("rArchive", ".arc");
resourceToFileExtensionMap.put("rTexture", ".tex");
resourceToFileExtensionMap.put("rAcquirement::rAbilityAddData", ".aad");
// ... ~420 total overrides
```

#### 2. `jamCrcToResourceMap` (CRC → class name)

Maps the JamCRC32 hash of every DTI class name to its string form. Used to resolve class references embedded in binary
files:

```
0x242BB29A → "rGUIMessage"
0x73850D05 → "rTexture"
0x4F3D2D3E → "CDataItemList"
```

#### 3. `jamCrcToFileExtensionMap` (CRC → file extension)

Maps JamCRC hashes directly to file extensions. A convenience shortcut that combines maps 1 and 2.

### Where Class CRCs Appear in Binary Formats

The DTI CRC lookup is essential for several binary format parsing tasks:

**Archive entries** (`.arc`): Each packed resource's `Type` field is a JamCRC of the class name (e.g., `0x242BB29A` =
`rGUIMessage`). Resolution: `getFrameworkResourceClassNameByCrc(type)` → class name → `getFileExtension()` → `.gmd`.

**XFS files** (binary XML): The `ClassData.ID` field is a JamCRC identifying the class whose properties follow.
Resolution: `getFrameworkResourceClassNameByCrc(ID)` → resolves to e.g., `cSetInfoOmCtrl`.

**Resource IDs**: A 64-bit composite value where the upper 32 bits are the JamCRC of the class name and the lower 32
bits are the framework CRC32 of the path. Resolution: `convertResourceIdToTagId()` extracts the class CRC;
`convertResourceIdToPathId()` extracts the path CRC.

**Archive List Arrays** (`.ala`): File name hashing uses `convertTagIdToTargetTagNumber()` to derive archive indices
from `frameworkCrc32(path)`.

### JamCRC vs. Framework CRC

`CrcUtil` provides two CRC variants, both based on standard CRC32 with different final XOR masks:

| Function               | Formula                     | Bits   | Usage                                    |
|------------------------|-----------------------------|--------|------------------------------------------|
| `jamCrc32(name)`       | `~CRC32(name) & 0x7FFFFFFF` | 31-bit | `MtDTI::mID` — class type identification |
| `frameworkCrc32(path)` | `~CRC32(path) & 0xFFFFFFFF` | 32-bit | Path hashing for resource lookup         |

### JamCRC Fallback Extensions

Some older ARC unpackers couldn't reliably determine all file extensions, so for historic reasons some S1 or S2
extensions are documented via their JamCRC as well.

```
.2EA55F30 → rPlayerExpTable     (JamCRC of "rPlayerExpTable" = 0x2EA55F30)
.5810D1F1 → rCraftRecipe        (JamCRC of "rCraftRecipe"    = 0x5810D1F1)
.3FD51519 → rCraftSkillGain     (JamCRC of "rCraftSkillGain" = 0x3FD51519)
```
