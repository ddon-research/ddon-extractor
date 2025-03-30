package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.meta;

import java.util.Arrays;

/**
 * https://learn.microsoft.com/en-us/windows/win32/api/ddraw/ns-ddraw-ddsurfacedesc
 * DDSCAPS_COMPLEX 	Optional; must be used on any file that contains more than one surface (a mipmap, a cubic environment map, or mipmapped volume texture). 	0x8
 * DDSCAPS_MIPMAP 	Optional; should be used for a mipmap. 	0x400000
 * DDSCAPS_TEXTURE 	Required 	0x1000
 * <p>
 * The DDS_SURFACE_FLAGS_MIPMAP flag, which is defined in Dds.h, is a bitwise-OR combination of the DDSCAPS_COMPLEX and DDSCAPS_MIPMAP flags.
 * The DDS_SURFACE_FLAGS_TEXTURE flag, which is defined in Dds.h, is equal to the DDSCAPS_TEXTURE flag.
 * The DDS_SURFACE_FLAGS_CUBEMAP flag, which is defined in Dds.h, is equal to the DDSCAPS_COMPLEX flag.
 */
public enum DirectDrawSurfaceCapsFlags {
    DDSCAPS_COMPLEX(0x8),
    DDSCAPS_TEXTURE(0x1000),//13
    DDSCAPS_MIPMAP(0x400000),//23
    DDS_SURFACE_FLAGS_MIPMAP(0x8 + 0x1000 + 0x400000L),
    ;

    public final long value;

    DirectDrawSurfaceCapsFlags(long value) {
        this.value = value;
    }

    public static DirectDrawSurfaceCapsFlags of(long value) {
        return Arrays.stream(DirectDrawSurfaceCapsFlags.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
