package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.meta;

import java.util.Arrays;

/**
 * https://learn.microsoft.com/en-us/windows/win32/api/ddraw/ns-ddraw-ddsurfacedesc
 * DDSD_CAPS 	Required in every .dds file. 	0x1
 * DDSD_HEIGHT 	Required in every .dds file. 	0x2
 * DDSD_WIDTH 	Required in every .dds file. 	0x4
 * DDSD_PITCH 	Required when pitch is provided for an uncompressed texture. 	0x8
 * DDSD_PIXELFORMAT 	Required in every .dds file. 	0x1000
 * DDSD_MIPMAPCOUNT 	Required in a mipmapped texture. 	0x20000
 * DDSD_LINEARSIZE 	Required when pitch is provided for a compressed texture. 	0x80000
 * DDSD_DEPTH 	Required in a depth texture. 	0x800000
 * <p>
 * The DDS_HEADER_FLAGS_TEXTURE flag, which is defined in Dds.h, is a bitwise-OR combination of the DDSD_CAPS, DDSD_HEIGHT, DDSD_WIDTH, and DDSD_PIXELFORMAT flags.
 * The DDS_HEADER_FLAGS_MIPMAP flag, which is defined in Dds.h, is equal to the DDSD_MIPMAPCOUNT flag.
 * The DDS_HEADER_FLAGS_VOLUME flag, which is defined in Dds.h, is equal to the DDSD_DEPTH flag.
 * The DDS_HEADER_FLAGS_PITCH flag, which is defined in Dds.h, is equal to the DDSD_PITCH flag.
 * The DDS_HEADER_FLAGS_LINEARSIZE flag, which is defined in Dds.h, is equal to the DDSD_LINEARSIZE flag.
 */
public enum DirectDrawSurfaceDescriptionFlags {
    DDSD_CAPS(0x1),
    DDSD_HEIGHT(0x2),
    DDSD_WIDTH(0x4),
    DDSD_PITCH(0x8),
    DDSD_PIXELFORMAT(0x1000),//13
    DDSD_MIPMAPCOUNT(0x20000),//18
    DDSD_LINEARSIZE(0x80000),//20
    DDSD_DEPTH(0x800000);//24

    public final long value;

    DirectDrawSurfaceDescriptionFlags(long value) {
        this.value = value;
    }

    public static DirectDrawSurfaceDescriptionFlags of(long value) {
        return Arrays.stream(DirectDrawSurfaceDescriptionFlags.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
