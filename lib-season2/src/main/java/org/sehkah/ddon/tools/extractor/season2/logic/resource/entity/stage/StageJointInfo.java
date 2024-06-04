package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Color;

import java.math.BigInteger;
import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class StageJointInfo {
    private String Model;
    // TODO calculate pathCRC for all of these
    private String ScrSbc0;
    private String EffSbc0;
    private String ScrSbc1;
    private String EffSbc1;
    private String ScrSbc2;
    private String EffSbc2;
    private String Light;
    private String NaviMesh;
    private String PlantTree;
    private String SndInfo;
    private List<Byte> Joint;
    private Color Color;
    private String Epv;
    private int EpvIndexAlways;
    private int EpvIndexDay;
    private int EpvIndexNight;
    // TODO extract metainfo out of these resource IDs
    private BigInteger EfcColorZoneResId;
    private BigInteger EfcCtrlZoneResId;
    private BigInteger IndoorZoneScrResId;
    private BigInteger IndoorZoneEfcResId;
    private BigInteger LightAndFogZoneResId;
    private List<BigInteger> ZoneUnitCtrlResId;
    private BigInteger ZoneStatusResId;
    private String Comment;
}
