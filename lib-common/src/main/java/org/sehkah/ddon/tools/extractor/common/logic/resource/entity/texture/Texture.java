package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.meta.*;

import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Texture extends Resource {
    private TextureHeader Header;
    // Null for 2D, only present for Cubes
    private TextureSphericalHarmonicsFactor SphericalHarmonics;
    private List<Long> MipLevelOffset;
    private List<List<DrawTexture>> TextureArray;

    private static DirectDrawSurface toDirectDrawSurface(Texture texture) {
        DirectDrawSurfaceHeader Header = new DirectDrawSurfaceHeader();
        Header.setFlags(getDDSDFlags(texture.getHeader()));
        Header.setHeight(texture.getHeader().getHeight());
        Header.setWidth(texture.getHeader().getWidth());
        Header.setPitchOrLinearSize(getPitchOrLinearSize(texture.getHeader()));
        Header.setMipMapCount(texture.getHeader().getLevelCount());
        Header.setReserved1(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        Header.setDdspf(getDirectDrawSurfacePixelFormat(texture.getHeader()));
        Header.setCaps(getDDSCapsFlags(texture.getHeader()));
        Header.setCaps2(getDDSCaps2Flags(texture.getHeader()));

        List<Byte> Data = new ArrayList<>(texture.FileSize);
        // TODO: Probably have to re-integrate the spherical harmonics for cube maps?
        texture.getTextureArray().forEach(t -> t.forEach(mip -> Data.addAll(mip.getData())));

        DirectDrawSurface dds = new DirectDrawSurface(Header, Data);
        FileHeader fileHeader = new FileHeader("DDS ", 124, 4);
        dds.setFileHeader(fileHeader);
        dds.setFileSize(128 + Data.size());
        return dds;
    }

    private static long getDDSCapsFlags(TextureHeader header) {
        long capsFlags = DirectDrawSurfaceCapsFlags.DDSCAPS_TEXTURE.value;
        // Mip Map
        if (header.getLevelCount() > 1) {
            capsFlags |= DirectDrawSurfaceCapsFlags.DDSCAPS_MIPMAP.value;
        }
        // Cube Map
        if (header.getTypeName() == TextureType.TEXTURE_TYPE_CUBE) {
            capsFlags |= DirectDrawSurfaceCapsFlags.DDSCAPS_COMPLEX.value;
        }
        return capsFlags;
    }

    private static long getDDSCaps2Flags(TextureHeader header) {
        long caps2Flags = 0;
        if (header.getTypeName() == TextureType.TEXTURE_TYPE_CUBE) {
            caps2Flags |= DirectDrawSurfaceCaps2Flags.DDS_CUBEMAP_ALLFACES.value;
        }
        return caps2Flags;
    }

    private static long getDDSDFlags(TextureHeader header) {
        long ddsdFlags = DirectDrawSurfaceDescriptionFlags.DDSD_CAPS.value
                | DirectDrawSurfaceDescriptionFlags.DDSD_HEIGHT.value
                | DirectDrawSurfaceDescriptionFlags.DDSD_WIDTH.value
                | DirectDrawSurfaceDescriptionFlags.DDSD_PIXELFORMAT.value;
        if (header.getLevelCount() > 1) {
            ddsdFlags |= DirectDrawSurfaceDescriptionFlags.DDSD_MIPMAPCOUNT.value;
        }
        // Assume any BC-derivative is compressed and some form of FOURCC DXT1-5 style format
        if (header.getFormatName().toString().startsWith("FORMAT_BC")) {
            ddsdFlags |= DirectDrawSurfaceDescriptionFlags.DDSD_LINEARSIZE.value;
        } else {
            ddsdFlags |= DirectDrawSurfaceDescriptionFlags.DDSD_PITCH.value;
        }
        return ddsdFlags;
    }

    private static long getPitchOrLinearSize(TextureHeader header) {
        // For compressed textures the linear size is equal to the first non-mip-mapped face
        if (header.getFormatName().toString().startsWith("FORMAT_BC")) {
            return header.getPitchOrLinearSize();
        } else {
            // For non-compressed textures the linear size is equal to channels * total bits
            return switch (header.getFormatName()) {
                case FORMAT_B8G8R8A8_UNORM, FORMAT_B8G8R8A8_UNORM_SRGB -> 128;
                case FORMAT_R32_FLOAT -> 32;
                case FORMAT_B4G4R4A4_UNORM -> 64;
                default -> throw new TechnicalException("Unsupported format: " + header.getFormatName());
            };
        }
    }

    private static DirectDrawSurfacePixelFormat getDirectDrawSurfacePixelFormat(TextureHeader header) {
        DirectDrawSurfacePixelFormat ddspf = new DirectDrawSurfacePixelFormat();
        ddspf.setSize(32);
        if (
                header.getFormatName() == FormatType.FORMAT_BC1_UNORM
                        || header.getFormatName() == FormatType.FORMAT_BC1_UNORM_SRGB
                        || header.getFormatName() == FormatType.FORMAT_BCX_GRAYSCALE
        ) {
            ddspf.setFlags(DirectDrawSurfacePixelFormatFlags.DDPF_FOURCC.value);
            ddspf.setFourCC(DirectDrawSurfacePixelFormatFourCharacterFlags.DXT1.value);
        } else if (
                header.getFormatName() == FormatType.FORMAT_BC2_UNORM_SRGB
        ) {
            ddspf.setFlags(DirectDrawSurfacePixelFormatFlags.DDPF_FOURCC.value);
            ddspf.setFourCC(DirectDrawSurfacePixelFormatFourCharacterFlags.DXT3.value);
        } else if (
                header.getFormatName() == FormatType.FORMAT_BC3_UNORM_SRGB
                        || header.getFormatName() == FormatType.FORMAT_BCX_NH
                        || header.getFormatName() == FormatType.FORMAT_BCX_NM2
                        || header.getFormatName() == FormatType.FORMAT_BCX_YCCA_SRGB
        ) {
            ddspf.setFlags(DirectDrawSurfacePixelFormatFlags.DDPF_FOURCC.value);
            ddspf.setFourCC(DirectDrawSurfacePixelFormatFourCharacterFlags.DXT5.value);
        } else if (
                header.getFormatName() == FormatType.FORMAT_B8G8R8A8_UNORM
                        || header.getFormatName() == FormatType.FORMAT_B8G8R8A8_UNORM_SRGB
                        || header.getFormatName() == FormatType.FORMAT_R32_FLOAT
        ) {
            ddspf.setFlags(DirectDrawSurfacePixelFormatFlags.DDPF_ALPHAPIXELS.value | DirectDrawSurfacePixelFormatFlags.DDPF_RGB.value);
            ddspf.setFourCC(0);
            ddspf.setRGBBitCount(32);
            ddspf.setBBitMask(0xFF_00_00_00L);
            ddspf.setGBitMask(0x00_FF_00_00);
            ddspf.setRBitMask(0x00_00_FF_00);
            ddspf.setABitMask(0x00_00_00_FF);
        } else if (
                header.getFormatName() == FormatType.FORMAT_B4G4R4A4_UNORM
        ) {
            ddspf.setFlags(DirectDrawSurfacePixelFormatFlags.DDPF_ALPHAPIXELS.value | DirectDrawSurfacePixelFormatFlags.DDPF_RGB.value);
            ddspf.setFourCC(0);
            ddspf.setRGBBitCount(16);
            ddspf.setBBitMask(0b1111_0000_0000_0000);
            ddspf.setGBitMask(0b0000_1111_0000_0000);
            ddspf.setRBitMask(0b0000_0000_1111_0000);
            ddspf.setABitMask(0b0000_0000_0000_1111);
        }
        return ddspf;
    }

    public DirectDrawSurface toDirectDrawSurface() {
        return Texture.toDirectDrawSurface(this);
    }
}
