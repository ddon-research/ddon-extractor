package org.sehkah.ddon.tools.extractor.common.logic.resource.serialization.texture;

import org.sehkah.ddon.tools.extractor.api.io.BufferWriter;
import org.sehkah.ddon.tools.extractor.api.logic.resource.serialization.ClientResourceFileSerializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.DirectDrawSurface;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.DirectDrawSurfacePixelFormat;

public class DirectDrawSurfaceSerializer extends ClientResourceFileSerializer<DirectDrawSurface> {
    public static void writeDirectDrawSurfacePixelFormat(DirectDrawSurfacePixelFormat pixelFormat, BufferWriter bufferWriter) {
        bufferWriter.writeUnsignedInteger(pixelFormat.getSize());
        bufferWriter.writeUnsignedInteger(pixelFormat.getFlags());
        bufferWriter.writeUnsignedInteger(pixelFormat.getFourCC());
        bufferWriter.writeUnsignedInteger(pixelFormat.getRGBBitCount());
        bufferWriter.writeUnsignedInteger(pixelFormat.getRBitMask());
        bufferWriter.writeUnsignedInteger(pixelFormat.getGBitMask());
        bufferWriter.writeUnsignedInteger(pixelFormat.getBBitMask());
        bufferWriter.writeUnsignedInteger(pixelFormat.getABitMask());
    }

    public static void writeHeader(DirectDrawSurface texture, BufferWriter bufferWriter) {
        bufferWriter.writeUnsignedInteger(texture.getHeader().getFlags());
        bufferWriter.writeUnsignedInteger(texture.getHeader().getHeight());
        bufferWriter.writeUnsignedInteger(texture.getHeader().getWidth());
        bufferWriter.writeUnsignedInteger(texture.getHeader().getPitchOrLinearSize());
        bufferWriter.writeUnsignedInteger(texture.getHeader().getDepth());
        bufferWriter.writeUnsignedInteger(texture.getHeader().getMipMapCount());
        bufferWriter.writeFixedLengthArray(texture.getHeader().getReserved1(), () -> bufferWriter::writeSignedInteger);
        writeDirectDrawSurfacePixelFormat(texture.getHeader().getDdspf(), bufferWriter);
        bufferWriter.writeUnsignedInteger(texture.getHeader().getCaps());
        bufferWriter.writeUnsignedInteger(texture.getHeader().getCaps2());
        bufferWriter.writeUnsignedInteger(texture.getHeader().getCaps3());
        bufferWriter.writeUnsignedInteger(texture.getHeader().getCaps4());
        bufferWriter.writeUnsignedInteger(texture.getHeader().getReserved2());
    }

    @Override
    protected void serializeClientResourceFile(DirectDrawSurface clientResource, BufferWriter bufferWriter) {
        writeHeader(clientResource, bufferWriter);

        bufferWriter.writeFixedLengthArray(clientResource.getData(), () -> bufferWriter::writeSignedByte);
    }
}
