package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum AreaMasterNpcId {
    None(0),
    HidellPlains(1313),
    BreyaCoast(1205),
    MysreeForest(1412),
    VoldenMines(1604),
    DoweValley(1508),
    MysreeGrove(4506),
    BetlandPlains(4508),
    DeenanWoods(1905),
    NorthernBetlandPlains(1701),
    ZandoraWastelands(4507),
    EasternZandora(1811),
    MergodaRuins(2301),
    BloodbaneIsle(549),
    ElanWaterGrove(4509),
    FaranaPlains(2501),
    MorrowForest(2600),
    KingalCanyon(2700),
    RathniteFoothills(2800),
    FeryanaWilderness(3050),
    MegadosysPlateau(3200),
    UrtecaMountains(4512);

    private static final Map<Integer, AreaMasterNpcId> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(AreaMasterNpcId::ordinal, Function.identity()));
    public final long NpcId;

    AreaMasterNpcId(long NpcId) {
        this.NpcId = NpcId;
    }

    public static AreaMasterNpcId of(Integer n) {
        return ordinalMap.get(n);
    }
}
