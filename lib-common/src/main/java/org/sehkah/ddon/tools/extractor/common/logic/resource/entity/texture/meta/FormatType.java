package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.meta;

import java.util.Arrays;

public enum FormatType {
    FORMAT_UNKNOWN(0x0),
    FORMAT_R32G32B32A32_FLOAT(0x1),
    FORMAT_R16G16B16A16_FLOAT(0x2),
    FORMAT_R16G16B16A16_UNORM(0x3),
    FORMAT_R16G16B16A16_SNORM(0x4),
    FORMAT_R32G32_FLOAT(0x5),
    FORMAT_R10G10B10A2_UNORM(0x6),
    FORMAT_R8G8B8A8_UNORM(0x7),
    FORMAT_R8G8B8A8_SNORM(0x8),
    FORMAT_R8G8B8A8_UNORM_SRGB(0x9),
    FORMAT_B4G4R4A4_UNORM(0xA),
    FORMAT_R16G16_FLOAT(0xB),
    FORMAT_R16G16_UNORM(0xC),
    FORMAT_R16G16_SNORM(0xD),
    FORMAT_R32_FLOAT(0xE),
    FORMAT_D24_UNORM_S8_UINT(0xF),
    FORMAT_R16_FLOAT(0x10),
    FORMAT_R16_UNORM(0x11),
    FORMAT_A8_UNORM(0x12),
    FORMAT_BC1_UNORM(0x13),
    FORMAT_BC1_UNORM_SRGB(0x14),
    FORMAT_BC2_UNORM(0x15),
    FORMAT_BC2_UNORM_SRGB(0x16),
    FORMAT_BC3_UNORM(0x17),
    FORMAT_BC3_UNORM_SRGB(0x18),
    // custom
    FORMAT_BCX_GRAYSCALE(0x19),
    // custom
    FORMAT_BCX_ALPHA(0x1A),
    FORMAT_BC5_SNORM(0x1B),
    FORMAT_B5G6R5_UNORM(0x1C),
    FORMAT_B5G5R5A1_UNORM(0x1D),
    // custom
    FORMAT_BCX_NM1(0x1E),
    // custom
    FORMAT_BCX_NM2(0x1F),
    // custom
    FORMAT_BCX_RGBI(0x20),
    // custom
    FORMAT_BCX_RGBY(0x21),
    FORMAT_B8G8R8X8_UNORM(0x22),
    // custom
    FORMAT_BCX_RGBI_SRGB(0x23),
    // custom
    FORMAT_BCX_RGBY_SRGB(0x24),
    // custom
    FORMAT_BCX_NH(0x25),
    FORMAT_R11G11B10_FLOAT(0x26),
    FORMAT_B8G8R8A8_UNORM(0x27),
    FORMAT_B8G8R8A8_UNORM_SRGB(0x28),
    // custom
    FORMAT_BCX_RGBNL(0x29),
    // custom
    FORMAT_BCX_YCCA(0x2A),
    // custom
    FORMAT_BCX_YCCA_SRGB(0x2B),
    FORMAT_R8_UNORM(0x2C),
    FORMAT_B8G8R8A8_UNORM_LE(0x2D),
    FORMAT_B10G10R10A2_UNORM_LE(0x2E),
    // custom
    FORMAT_BCX_SRGBA(0x2F),
    FORMAT_BC7_UNORM(0x30),
    FORMAT_BC7_UNORM_SRGB(0x31),
    FORMAT_SE5M9M9M9(0x32),
    FORMAT_R10G10B10A2_FLOAT(0x33),
    // custom
    FORMAT_YVU420P2_CSC1(0x34),
    FORMAT_R8A8_UNORM(0x35),
    FORMAT_A8_UNORM_WHITE(0x36);

    public final long value;

    FormatType(long value) {
        this.value = value;
    }

    public static FormatType of(long value) {
        return Arrays.stream(FormatType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
