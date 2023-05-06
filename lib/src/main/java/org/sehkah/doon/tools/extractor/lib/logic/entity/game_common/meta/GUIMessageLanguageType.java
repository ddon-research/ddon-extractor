package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.meta;

import java.util.Arrays;

public enum GUIMessageLanguageType {
    LANGUAGE_JAPANESE(0x0),
    LANGUAGE_ENGLISH(0x1),
    LANGUAGE_FRENCH(0x2),
    LANGUAGE_SPANISH(0x3),
    LANGUAGE_GERMAN(0x4),
    LANGUAGE_ITALIAN(0x5);


    public final long value;

    GUIMessageLanguageType(long value) {
        this.value = value;
    }

    public static GUIMessageLanguageType of(long value) {
        return Arrays.stream(GUIMessageLanguageType.values()).filter(guiMessageLanguageType -> guiMessageLanguageType.value == value).findFirst().orElse(null);
    }
}
