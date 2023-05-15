package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import java.util.Arrays;

public enum ItemListEmPhylogenyKind {
    EM_PHYLOGENY_KIND_NONE(0x0),
    EM_PHYLOGENY_KIND_DEMI_HUMAN(0x1),
    EM_PHYLOGENY_KIND_BEAST(0x2),
    EM_PHYLOGENY_KIND_KIZIN(0x3),
    EM_PHYLOGENY_KIND_ZOMBIE(0x4),
    EM_PHYLOGENY_KIND_SKELETON(0x5),
    EM_PHYLOGENY_KIND_WINGED(0x6),
    EM_PHYLOGENY_KIND_GIANT(0x7),
    EM_PHYLOGENY_KIND_SOFT_BODY(0x8),
    EM_PHYLOGENY_KIND_GHOST(0x9),
    EM_PHYLOGENY_KIND_CURSE(0xA),
    EM_PHYLOGENY_KIND_ART_EVIL(0xB),
    EM_PHYLOGENY_KIND_HUMAN(0xC),
    EM_PHYLOGENY_KIND_ALCHEMY(0xD),
    EM_PHYLOGENY_KIND_DRAGON(0xE),
    EM_PHYLOGENY_KIND_EVIL(0xF),
    EM_PHYLOGENY_KIND_EROSION(0x10),
    EM_PHYLOGENY_KIND_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListEmPhylogenyKind(long value) {
        this.value = value;
    }

    public static ItemListEmPhylogenyKind of(long value) {
        return Arrays.stream(ItemListEmPhylogenyKind.values()).filter(itemListEmPhylogenyKind -> itemListEmPhylogenyKind.value == value).findFirst().orElse(EM_PHYLOGENY_KIND_UNKNOWN);
    }
}
