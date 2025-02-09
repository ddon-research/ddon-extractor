package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta;


import java.util.Arrays;

public enum NavigationMeshType {
    TYPE_MESH(0x0),
    TYPE_POINT_2(0x1);

    public long value;

    NavigationMeshType(long value) {
        this.value = value;
    }

    public static NavigationMeshType of(long value) {
        return Arrays.stream(NavigationMeshType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
