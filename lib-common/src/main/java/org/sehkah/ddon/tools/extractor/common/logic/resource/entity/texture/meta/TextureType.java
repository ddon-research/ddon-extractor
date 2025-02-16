package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.meta;

import java.util.Arrays;

public enum TextureType {
    TEXTURE_TYPE_UNDEFINED(0x0),
    TEXTURE_TYPE_1D(0x1),
    TEXTURE_TYPE_2D(0x2),
    TEXTURE_TYPE_3D(0x3),
    TEXTURE_TYPE_1DARRAY(0x4),
    TEXTURE_TYPE_2DARRAY(0x5),
    TEXTURE_TYPE_CUBE(0x6),
    TEXTURE_TYPE_CUBEARRAY(0x7),
    TEXTURE_TYPE_2DMS(0x8),
    TEXTURE_TYPE_2DMSARRAY(0x9);

    public final long value;

    TextureType(long value) {
        this.value = value;
    }

    public static TextureType of(long value) {
        return Arrays.stream(TextureType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
