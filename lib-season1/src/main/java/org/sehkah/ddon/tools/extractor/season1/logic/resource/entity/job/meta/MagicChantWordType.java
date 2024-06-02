package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job.meta;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MagicChantWordType {
    MAGIC_WORD_NONE(0x0),
    MAGIC_WORD_A(0x1),
    MAGIC_WORD_B(0x2),
    MAGIC_WORD_C(0x3),
    MAGIC_WORD_D(0x4),
    MAGIC_WORD_E(0x5),
    MAGIC_WORD_F(0x6),
    MAGIC_WORD_G(0x7),
    MAGIC_WORD_H(0x8),
    MAGIC_WORD_I(0x9),
    MAGIC_WORD_J(0xA),
    MAGIC_WORD_K(0xB),
    MAGIC_WORD_L(0xC),
    MAGIC_WORD_M(0xD),
    MAGIC_WORD_N(0xE),
    MAGIC_WORD_O(0xF),
    MAGIC_WORD_P(0x10),
    MAGIC_WORD_Q(0x11),
    MAGIC_WORD_R(0x12),
    MAGIC_WORD_S(0x13),
    MAGIC_WORD_T(0x14),
    MAGIC_WORD_U(0x15),
    MAGIC_WORD_V(0x16),
    MAGIC_WORD_W(0x17),
    MAGIC_WORD_X(0x18),
    MAGIC_WORD_Y(0x19),
    MAGIC_WORD_Z(0x1A);

    public final long value;

    MagicChantWordType(long value) {
        this.value = value;
    }

    public static MagicChantWordType of(long value) {
        return Arrays.stream(MagicChantWordType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }

    public static String toString(List<Integer> word) {
        return word.stream().filter(i -> i != 0).map(i -> String.valueOf((char) (i + 64))).collect(Collectors.joining());
    }
}
