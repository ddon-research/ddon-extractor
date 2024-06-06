package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Color;

import java.math.BigInteger;
import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageCustomPartsExInfoEx {
    private String Model;
    private String ScrSbc1;
    private String EffSbc1;
    private String ScrSbc2;
    private String EffSbc2;
    private String ScrSbc3;
    private String EffSbc3;
    private String Light;
    private String NaviMesh;
    private String Epv;
    private String Occluder;

    private int AreaNo;
    private int Type;
    private long Size;
    private float OffsetZ;
    private int EpvIndexAlways;
    private int EpvIndexDay;
    private int EpvIndexNight;
    private Color Color;

    private BigInteger EfcColorZone;
    private BigInteger EfcCtrlZone;
    private BigInteger IndoorZoneScr;
    private BigInteger IndoorZoneEfc;
    private BigInteger LightAndFogZone;
    private BigInteger SoundAreaInfo;
    private List<BigInteger> ZoneUnitCtrl;
    private BigInteger ZoneStatus;

    private String Comment;

    private long AddVersion;
    private List<StageCustomPartsExAreaParam> AreaParamList;

    public StageCustomPartsExInfoEx(String model, String scrSbc1, String effSbc1, String scrSbc2, String effSbc2, String scrSbc3, String effSbc3, String light, String naviMesh, String epv, String occluder, int areaNo, int type, long size, float offsetZ, int epvIndexAlways, int epvIndexDay, int epvIndexNight, org.sehkah.ddon.tools.extractor.api.datatype.Color color, BigInteger efcColorZone, BigInteger efcCtrlZone, BigInteger indoorZoneScr, BigInteger indoorZoneEfc, BigInteger lightAndFogZone, BigInteger soundAreaInfo, List<BigInteger> zoneUnitCtrl, BigInteger zoneStatus, String comment, List<StageCustomPartsExAreaParam> areaParamList) {
        this(model, scrSbc1, effSbc1, scrSbc2, effSbc2, scrSbc3, effSbc3, light, naviMesh, epv, occluder, areaNo, type, size, offsetZ, epvIndexAlways, epvIndexDay, epvIndexNight, color, efcColorZone, efcCtrlZone, indoorZoneScr, indoorZoneEfc, lightAndFogZone, soundAreaInfo, zoneUnitCtrl, zoneStatus, comment, areaParamList.size(), areaParamList);
    }
}
