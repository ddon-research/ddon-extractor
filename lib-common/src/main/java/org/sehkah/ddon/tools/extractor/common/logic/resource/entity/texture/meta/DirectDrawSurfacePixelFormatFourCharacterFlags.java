package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.meta;

import java.util.Arrays;

/**
 * https://learn.microsoft.com/en-us/windows/win32/direct3ddds/dds-pixelformat
 * <p>
 * Four-character codes for specifying compressed or custom formats.
 * Possible values include: DXT1, DXT2, DXT3, DXT4, or DXT5.
 * A FourCC of DX10 indicates the prescense of the DDS_HEADER_DXT10 extended header,
 * and the dxgiFormat member of that structure indicates the true format.
 * When using a four-character code, dwFlags must include DDPF_FOURCC.
 */
public enum DirectDrawSurfacePixelFormatFourCharacterFlags {
    DXT1(0x31_545844),//BC1_UNORM
    DXT2(0x32_545844),
    DXT3(0x33_545844),//BC2_UNORM
    DXT4(0x34_545844),
    DXT5(0x35_545844),//BC3_UNORM
    DX10(0x30_315844),
    BC4U(0x55_344342),//BC4_UNORM
    BC4S(0x53_344342),//BC4_SNORM
    ATI2(0x32_495441),//BC5_UNORM
    BC5S(0x53_354342),//BC5_SNORM
    ;

    public final long value;

    DirectDrawSurfacePixelFormatFourCharacterFlags(long value) {
        this.value = value;
    }

    public static DirectDrawSurfacePixelFormatFourCharacterFlags of(long value) {
        return Arrays.stream(DirectDrawSurfacePixelFormatFourCharacterFlags.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
