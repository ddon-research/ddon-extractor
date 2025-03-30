package org.sehkah.ddon.tools.extractor.common.logic.resource.serialization.texture;

import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BinaryWriter;
import org.sehkah.ddon.tools.extractor.api.io.BufferWriter;
import org.sehkah.ddon.tools.extractor.api.logic.resource.serialization.ClientResourceFileSerializer;
import org.sehkah.ddon.tools.extractor.api.logic.resource.serialization.FileHeaderSerializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.DrawTexture;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.Texture;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.TextureHeader;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.TextureSphericalHarmonicsFactor;

import java.util.List;

public class TextureSerializer extends ClientResourceFileSerializer<Texture> {
    private static void writeTextureSphericalHarmonicsFactor(TextureSphericalHarmonicsFactor sphericalHarmonicsFactor, BufferWriter bufferWriter) {
        bufferWriter.writeFixedLengthArray(sphericalHarmonicsFactor.getR(), () -> bufferWriter::writeFloat);
        bufferWriter.writeFixedLengthArray(sphericalHarmonicsFactor.getG(), () -> bufferWriter::writeFloat);
        bufferWriter.writeFixedLengthArray(sphericalHarmonicsFactor.getB(), () -> bufferWriter::writeFloat);
    }

    public static void writeTextureHeader(TextureHeader header, long versionNumber, BufferWriter bufferWriter) {
        long header4 = (versionNumber & 0xFFFF)
                | ((header.getAttr() & 0xFF) << 16)
                | ((header.getPrebias() & 0x0F) << 24)
                | ((header.getType() & 0x0F) << 28);
        bufferWriter.writeUnsignedInteger(header4);

        long header8 = ((header.getHeight() & 0x1FFF) << 19)
                | ((header.getWidth() & 0x1FFF) << 6)
                | header.getLevelCount() & 0x3F;
        bufferWriter.writeUnsignedInteger(header8);

        long header12 = (header.getArrayCount() & 0xFF)
                | ((header.getFormat() & 0xFF) << 8)
                | ((header.getDepth() & 0x1FFF) << 16)
                | (((header.isAutoResize() ? 1 : 0) & 0x1) << 29)
                | (((header.isRenderTarget() ? 1 : 0) & 0x1) << 30)
                | (((header.isUseVtf() ? 1 : 0) & 0x1) << 31);
        bufferWriter.writeUnsignedInteger(header12);
    }

    @Override
    protected void serializeClientResourceFile(Texture clientResource, BufferWriter bufferWriter) {
        writeTextureHeader(clientResource.getHeader(), clientResource.getFileHeader().versionNumber(), bufferWriter);
        if (clientResource.getHeader().isHasSphericalHarmonicsFactors()) {
            writeTextureSphericalHarmonicsFactor(clientResource.getSphericalHarmonics(), bufferWriter);
        }

        bufferWriter.writeFixedLengthArray(clientResource.getMipLevelOffset(), () -> bufferWriter::writeUnsignedInteger);

        for (List<DrawTexture> drawTextures : clientResource.getTextureArray()) {
            for (DrawTexture drawTexture : drawTextures) {
                bufferWriter.writeFixedLengthArray(drawTexture.getData(), () -> bufferWriter::writeSignedByte);
            }
        }
    }

    /**
     * Overwrite parent to avoid writing the version twice.
     */
    @Override
    public byte[] serializeResource(Texture clientResource) {
        BufferWriter bufferWriter = new BinaryWriter(clientResource.getFileSize());
        if (clientResource.getFileHeader().magicBytesLength() > 0) {
            FileHeaderSerializer.writeMagicString(bufferWriter, clientResource.getFileHeader().magicString());
        }
        serializeClientResourceFile(clientResource, bufferWriter);
        if (bufferWriter.getPosition() != clientResource.getFileSize()) {
            throw new TechnicalException("The written bytes '%s' do not match up with the expected size '%s'!".formatted(bufferWriter.getPosition(), clientResource.getFileSize()));
        }
        return bufferWriter.getBytes();
    }
}
