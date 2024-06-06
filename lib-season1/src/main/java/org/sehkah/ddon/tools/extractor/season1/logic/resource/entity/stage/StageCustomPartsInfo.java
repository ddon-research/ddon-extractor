package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage;

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
public class StageCustomPartsInfo {
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
    private String Layout;

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
    private List<BigInteger> ZoneUnitCtrl; //[3],
    private BigInteger ZoneStatus;

    private String Comment;
}
