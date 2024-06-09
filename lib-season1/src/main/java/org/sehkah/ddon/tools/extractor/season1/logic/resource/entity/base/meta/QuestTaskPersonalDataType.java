package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum QuestTaskPersonalDataType {
    PERSONAL_DATA_TYPE_MYSELF(0x0),// Solo activity
    PERSONAL_DATA_TYPE_PARTY(0x1),
    PERSONAL_DATA_TYPE_LEADER(0x2);


    public final long value;

    QuestTaskPersonalDataType(long value) {
        this.value = value;
    }

    public static QuestTaskPersonalDataType of(long value) {
        return Arrays.stream(QuestTaskPersonalDataType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
