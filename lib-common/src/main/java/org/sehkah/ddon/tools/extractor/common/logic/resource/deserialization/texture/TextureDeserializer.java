package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.texture;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.DrawTexture;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.Texture;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.TextureHeader;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.TextureSphericalHarmonicsFactor;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.meta.FormatType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.meta.TextureType;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TextureDeserializer extends ClientResourceFileDeserializer<Texture> {
    private static TextureSphericalHarmonicsFactor readTextureSphericalHarmonicsFactor(BufferReader bufferReader) {
        return new TextureSphericalHarmonicsFactor(
                bufferReader.readFixedLengthArray(9, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(9, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(9, BufferReader::readFloat)
        );
    }

    private static DrawTexture readDrawTexture(BufferReader bufferReader, int mipLevel, long dataBufferSize) {
        return new DrawTexture(mipLevel, bufferReader.readFixedLengthArray(dataBufferSize, BufferReader::readSignedByte));
    }

    public static TextureHeader readTextureHeader(BufferReader bufferReader) {
        long header4 = bufferReader.readUnsignedInteger();
        long header8 = bufferReader.readUnsignedInteger();
        long header12 = bufferReader.readUnsignedInteger();

        long Version = BitUtil.extractInt(header4, 0, 15);
        long Attr = BitUtil.extractInt(header4, 16, 23);
        long Prebias = BitUtil.extractInt(header4, 24, 27);
        long Type = BitUtil.extractInt(header4, 28, 31); // DDON only makes use of 2D & Cube
        TextureType TypeName = TextureType.of(Type);

        long LevelCount = BitUtil.extractInt(header8, 0, 5);
        long Width = BitUtil.extractInt(header8, 6, 18);
        long Height = BitUtil.extractInt(header8, 19, 31);

        long ArrayCount = BitUtil.extractInt(header12, 0, 7);
        long Format = BitUtil.extractInt(header12, 8, 15);
        FormatType FormatName = FormatType.of(Format);
        long Depth = BitUtil.extractInt(header12, 16, 28);
        boolean AutoResize = BitUtil.extractBoolean(header12, 29);
        boolean RenderTarget = BitUtil.extractBoolean(header12, 30);
        boolean UseVtf = BitUtil.extractBoolean(header12, 31);
        boolean HasSphericalHarmonicsFactors = (header4 & 0xF0000000L) == 0x60000000; // Always true for Cube and no other types
        long MipLevelCount = ArrayCount * LevelCount;
        long PitchOrLinearSize = 0;

        return new TextureHeader(Attr, Prebias, Type, TypeName, LevelCount, Width, Height, ArrayCount,
                Format, FormatName, Depth, AutoResize, RenderTarget, UseVtf, HasSphericalHarmonicsFactors, MipLevelCount, PitchOrLinearSize);
    }

    @Override
    protected Texture parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        // Version will be read in twice to make processing easier.
        bufferReader.setPosition(bufferReader.getPosition() - 2);

        TextureHeader Header = readTextureHeader(bufferReader);
        TextureSphericalHarmonicsFactor SphericalHarmonics = null;
        if (Header.isHasSphericalHarmonicsFactors()) {
            SphericalHarmonics = readTextureSphericalHarmonicsFactor(bufferReader);
        }
        List<Long> MipLevelOffset = bufferReader.readFixedLengthArray(Header.getMipLevelCount(), BufferReader::readUnsignedInteger);
        List<List<DrawTexture>> TextureArray = new ArrayList<>((int) Header.getArrayCount());

        // For DDON this is fine, because there are only 2D & CubeMap textures, which means either there is an array of size 1 or 6 and for cube maps all faces will share the same size.
        if (Header.getLevelCount() == 1) {
            Header.setPitchOrLinearSize(bufferReader.getLimit() - MipLevelOffset.getFirst());
        } else if (Header.getLevelCount() > 1) {
            Header.setPitchOrLinearSize(MipLevelOffset.get(1) - MipLevelOffset.getFirst());
        }

        switch (Header.getTypeName()) {
            case TEXTURE_TYPE_2D, TEXTURE_TYPE_CUBE -> {
                for (int texture = 0; texture < Header.getArrayCount(); texture++) {
                    TextureArray.add(new ArrayList<>((int) Header.getLevelCount()));

                    int mipLevel = 0;
                    if (Header.getLevelCount() > 1) {
                        for (mipLevel = 0; mipLevel < Header.getLevelCount() - 1; mipLevel++) {
                            int offsetIndex = (int) (texture * Header.getLevelCount() + mipLevel);
                            long currentOffset = MipLevelOffset.get(offsetIndex);
                            long nextOffset = MipLevelOffset.get(offsetIndex + 1);
                            long length = nextOffset - currentOffset;
                            TextureArray.get(texture).add(readDrawTexture(bufferReader, mipLevel, length));
                        }
                        int offsetIndex = (int) (texture * Header.getLevelCount() + mipLevel);
                        long currentOffset = MipLevelOffset.get(offsetIndex);
                        long nextOffset;
                        if (offsetIndex == Header.getMipLevelCount() - 1) {
                            nextOffset = bufferReader.getLimit();
                        } else {
                            nextOffset = MipLevelOffset.get(offsetIndex + 1);
                        }
                        long length = nextOffset - currentOffset;
                        TextureArray.get(texture).add(readDrawTexture(bufferReader, mipLevel, length));
                    } else {
                        TextureArray.get(texture).add(readDrawTexture(bufferReader, mipLevel, bufferReader.getLimit() - MipLevelOffset.get((int) ((texture * Header.getLevelCount()) + mipLevel))));
                    }
                }
            }
            default -> {
                log.error("Unsupported texture type, skipping: {}", Header.getTypeName());
                bufferReader.setPosition(bufferReader.getLimit());
            }
        }

        return new Texture(Header, SphericalHarmonics, MipLevelOffset, TextureArray);
    }
}
