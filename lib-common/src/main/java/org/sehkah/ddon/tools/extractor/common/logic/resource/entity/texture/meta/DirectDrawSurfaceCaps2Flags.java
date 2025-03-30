package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.meta;

import java.util.Arrays;

/**
 * https://learn.microsoft.com/en-us/windows/win32/api/ddraw/ns-ddraw-ddsurfacedesc
 * DDSCAPS2_CUBEMAP 	Required for a cube map. 	0x200
 * DDSCAPS2_CUBEMAP_POSITIVEX 	Required when these surfaces are stored in a cube map. 	0x400
 * DDSCAPS2_CUBEMAP_NEGATIVEX 	Required when these surfaces are stored in a cube map. 	0x800
 * DDSCAPS2_CUBEMAP_POSITIVEY 	Required when these surfaces are stored in a cube map. 	0x1000
 * DDSCAPS2_CUBEMAP_NEGATIVEY 	Required when these surfaces are stored in a cube map. 	0x2000
 * DDSCAPS2_CUBEMAP_POSITIVEZ 	Required when these surfaces are stored in a cube map. 	0x4000
 * DDSCAPS2_CUBEMAP_NEGATIVEZ 	Required when these surfaces are stored in a cube map. 	0x8000
 * DDSCAPS2_VOLUME 	Required for a volume texture. 	0x200000
 * <p>
 * The DDS_CUBEMAP_POSITIVEX flag, which is defined in Dds.h, is a bitwise-OR combination of the DDSCAPS2_CUBEMAP and DDSCAPS2_CUBEMAP_POSITIVEX flags.
 * The DDS_CUBEMAP_NEGATIVEX flag, which is defined in Dds.h, is a bitwise-OR combination of the DDSCAPS2_CUBEMAP and DDSCAPS2_CUBEMAP_NEGATIVEX flags.
 * The DDS_CUBEMAP_POSITIVEY flag, which is defined in Dds.h, is a bitwise-OR combination of the DDSCAPS2_CUBEMAP and DDSCAPS2_CUBEMAP_POSITIVEY flags.
 * The DDS_CUBEMAP_NEGATIVEY flag, which is defined in Dds.h, is a bitwise-OR combination of the DDSCAPS2_CUBEMAP and DDSCAPS2_CUBEMAP_NEGATIVEY flags.
 * The DDS_CUBEMAP_POSITIVEZ flag, which is defined in Dds.h, is a bitwise-OR combination of the DDSCAPS2_CUBEMAP and DDSCAPS2_CUBEMAP_POSITIVEZ flags.
 * The DDS_CUBEMAP_NEGATIVEZ flag, which is defined in Dds.h, is a bitwise-OR combination of the DDSCAPS2_CUBEMAP and DDSCAPS2_CUBEMAP_NEGATIVEZ flags.
 * The DDS_CUBEMAP_ALLFACES flag, which is defined in Dds.h, is a bitwise-OR combination of the DDS_CUBEMAP_POSITIVEX, DDS_CUBEMAP_NEGATIVEX, DDS_CUBEMAP_POSITIVEY, DDS_CUBEMAP_NEGATIVEY, DDS_CUBEMAP_POSITIVEZ, and DDSCAPS2_CUBEMAP_NEGATIVEZ flags.
 * The DDS_FLAGS_VOLUME flag, which is defined in Dds.h, is equal to the DDSCAPS2_VOLUME flag.
 */
public enum DirectDrawSurfaceCaps2Flags {
    DDSCAPS2_CUBEMAP(0x200),
    DDSCAPS2_CUBEMAP_POSITIVEX(0x400),
    DDSCAPS2_CUBEMAP_NEGATIVEX(0x800),
    DDSCAPS2_CUBEMAP_POSITIVEY(0x1000),
    DDSCAPS2_CUBEMAP_NEGATIVEY(0x2000),
    DDSCAPS2_CUBEMAP_POSITIVEZ(0x4000),
    DDSCAPS2_CUBEMAP_NEGATIVEZ(0x8000),
    DDS_CUBEMAP_ALLFACES(0x200 + 0x400 + 0x800 + 0x1000 + 0x4000 + 0x2000 + 0x8000L),
    DDSCAPS2_VOLUME(0x200000);

    public final long value;

    DirectDrawSurfaceCaps2Flags(long value) {
        this.value = value;
    }

    public static DirectDrawSurfaceCaps2Flags of(long value) {
        return Arrays.stream(DirectDrawSurfaceCaps2Flags.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
