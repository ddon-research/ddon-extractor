package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.meta;


import java.util.Arrays;

public enum ScenarioStatusType {
    SCENARIO_STATUS_NONE(0x0),
    SCENARIO_STATUS_HIT(0x1),
    SCENARIO_STATUS_DEAD(0x2),
    SCENARIO_STATUS_SLEEP(0x4),
    SCENARIO_STATUS_DONE(0x8),
    SCENARIO_STATUS_DO(0x10),
    SCENARIO_STATUS_BURIAL(0x20),
    SCENARIO_STATUS_DEL_EV_START(0x40),
    SCENARIO_STATUS_INIT(0x80),
    SCENARIO_STATUS_GAME_STOP(0x100);

    public final long value;

    ScenarioStatusType(long value) {
        this.value = value;
    }

    public static ScenarioStatusType of(long value) {
        return Arrays.stream(ScenarioStatusType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
