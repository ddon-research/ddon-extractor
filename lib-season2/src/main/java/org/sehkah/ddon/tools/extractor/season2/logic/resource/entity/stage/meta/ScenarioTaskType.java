package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.meta;


import java.util.Arrays;

public enum ScenarioTaskType {
    SCENARIO_TASK_SCE(0x0),
    SCENARIO_TASK_DOOR(0x1),
    SCENARIO_TASK_FSM(0x2),
    SCENARIO_TASK_CUSTOM(0x3),
    SCENARIO_TASK_MAX(0x4),
    SCENARIO_TASK_ERROR(0x5);

    public final long value;

    ScenarioTaskType(long value) {
        this.value = value;
    }

    public static ScenarioTaskType of(long value) {
        return Arrays.stream(ScenarioTaskType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
