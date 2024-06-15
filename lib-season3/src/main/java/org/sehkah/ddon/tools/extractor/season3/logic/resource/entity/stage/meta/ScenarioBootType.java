package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.meta;


import java.util.Arrays;

public enum ScenarioBootType {
    SCENARIO_BOOT_NO_AREA(0x0),
    SCENARIO_BOOT_LATER(0x1),
    SCENARIO_BOOT_DURING(0x2),
    SCENARIO_BOOT_ONCE(0x3),
    SCENARIO_BOOT_TRIGGER(0x4),
    SCENARIO_BOOT_BTN(0x5),
    SCENARIO_BOOT_BTN_ONCE(0x6);

    public final long value;

    ScenarioBootType(long value) {
        this.value = value;
    }

    public static ScenarioBootType of(long value) {
        return Arrays.stream(ScenarioBootType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
