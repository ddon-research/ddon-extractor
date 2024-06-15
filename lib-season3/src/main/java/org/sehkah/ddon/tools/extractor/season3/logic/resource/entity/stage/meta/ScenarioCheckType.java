package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.meta;


import java.util.Arrays;

public enum ScenarioCheckType {
    SCENARIO_CHECK_OR(0x0),
    SCENARIO_CHECK_AND(0x1),
    SCENARIO_CHECK_EACH(0x2);

    public final long value;

    ScenarioCheckType(long value) {
        this.value = value;
    }

    public static ScenarioCheckType of(long value) {
        return Arrays.stream(ScenarioCheckType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
