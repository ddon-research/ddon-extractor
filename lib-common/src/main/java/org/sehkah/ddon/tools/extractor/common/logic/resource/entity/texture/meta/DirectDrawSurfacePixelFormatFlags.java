package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.meta;

import java.util.Arrays;

/**
 * https://learn.microsoft.com/en-us/windows/win32/api/ddraw/ns-ddraw-ddsurfacedesc
 * DDPF_ALPHAPIXELS 	Texture contains alpha data; dwRGBAlphaBitMask contains valid data. 	0x1
 * DDPF_ALPHA 	Used in some older DDS files for alpha channel only uncompressed data (dwRGBBitCount contains the alpha channel bitcount; dwABitMask contains valid data) 	0x2
 * DDPF_FOURCC 	Texture contains compressed RGB data; dwFourCC contains valid data. 	0x4
 * DDPF_RGB 	Texture contains uncompressed RGB data; dwRGBBitCount and the RGB masks (dwRBitMask, dwGBitMask, dwBBitMask) contain valid data. 	0x40
 * DDPF_YUV 	Used in some older DDS files for YUV uncompressed data (dwRGBBitCount contains the YUV bit count; dwRBitMask contains the Y mask, dwGBitMask contains the U mask, dwBBitMask contains the V mask) 	0x200
 * DDPF_LUMINANCE 	Used in some older DDS files for single channel color uncompressed data (dwRGBBitCount contains the luminance channel bit count; dwRBitMask contains the channel mask). Can be combined with DDPF_ALPHAPIXELS for a two channel DDS file. 	0x20000
 */
public enum DirectDrawSurfacePixelFormatFlags {
    DDPF_ALPHAPIXELS(0x1),
    DDPF_ALPHA(0x2),
    DDPF_FOURCC(0x4),
    DDPF_RGB(0x40),
    DDPF_YUV(0x200),
    DDPF_LUMINANCE(0x20000);

    public final long value;

    DirectDrawSurfacePixelFormatFlags(long value) {
        this.value = value;
    }

    public static DirectDrawSurfacePixelFormatFlags of(long value) {
        return Arrays.stream(DirectDrawSurfacePixelFormatFlags.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
