package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta;


import java.util.Arrays;

public enum AreaHitShapeType {
    AREAHIT_SHAPE_TYPE_NONE(0x0),
    AREAHIT_SHAPE_TYPE_BOX(0x1),
    AREAHIT_SHAPE_TYPE_SPHERE(0x2),
    AREAHIT_SHAPE_TYPE_CYLINDER(0x3),
    AREAHIT_SHAPE_TYPE_DUMMY_04(0x4),
    AREAHIT_SHAPE_TYPE_DUMMY_05(0x5),
    AREAHIT_SHAPE_TYPE_CONE(0x6),
    AREAHIT_SHAPE_TYPE_DUMMY_07(0x7),
    AREAHIT_SHAPE_TYPE_AABB(0x8),
    AREAHIT_SHAPE_TYPE_OBB(0x9);

    public long value;

    AreaHitShapeType(long value) {
        this.value = value;
    }

    public static AreaHitShapeType of(long value) {
        return Arrays.stream(AreaHitShapeType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
