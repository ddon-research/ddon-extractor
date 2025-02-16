package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.texture;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.DirectDrawSurface;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.DirectDrawSurfaceHeader;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.DirectDrawSurfacePixelFormat;

import java.nio.file.Path;
import java.util.List;

@Slf4j
public class DirectDrawSurfaceDeserializer extends ClientResourceFileDeserializer<DirectDrawSurface> {

    public static DirectDrawSurfacePixelFormat readDirectDrawSurfacePixelFormat(BufferReader bufferReader) {
        long Size = bufferReader.readUnsignedInteger();
        long Flags = bufferReader.readUnsignedInteger();
        long FourCC = bufferReader.readUnsignedInteger();
        long RGBBitCount = bufferReader.readUnsignedInteger();
        long RBitMask = bufferReader.readUnsignedInteger();
        long GBitMask = bufferReader.readUnsignedInteger();
        long BBitMask = bufferReader.readUnsignedInteger();
        long ABitMask = bufferReader.readUnsignedInteger();
        return new DirectDrawSurfacePixelFormat(Size, Flags, FourCC, RGBBitCount, RBitMask, GBitMask, BBitMask, ABitMask);
    }

    public static DirectDrawSurfaceHeader readDirectDrawSurfaceHeader(BufferReader bufferReader) {
        long Flags = bufferReader.readUnsignedInteger();
        long Height = bufferReader.readUnsignedInteger();
        long Width = bufferReader.readUnsignedInteger();
        long PitchOrLinearSize = bufferReader.readUnsignedInteger();
        long Depth = bufferReader.readUnsignedInteger();
        long MipMapCount = bufferReader.readUnsignedInteger();
        List<Integer> Reserved = bufferReader.readFixedLengthArray(11, BufferReader::readUnsignedByte);
        DirectDrawSurfacePixelFormat ddspf = readDirectDrawSurfacePixelFormat(bufferReader);
        long Caps = bufferReader.readUnsignedInteger();
        long Caps2 = bufferReader.readUnsignedInteger();
        long Caps3 = bufferReader.readUnsignedInteger();
        long Caps4 = bufferReader.readUnsignedInteger();
        long Reserved2 = bufferReader.readUnsignedInteger();

        return new DirectDrawSurfaceHeader(Flags, Height, Width, PitchOrLinearSize, Depth, MipMapCount, Reserved, ddspf, Caps, Caps2, Caps3, Caps4, Reserved2);
    }

    @Override
    protected DirectDrawSurface parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        DirectDrawSurfaceHeader Header = readDirectDrawSurfaceHeader(bufferReader);
        List<Byte> Data = bufferReader.readFixedLengthArray(bufferReader.getRemainingCount(), BufferReader::readSignedByte);

        return new DirectDrawSurface(Header, Data);
    }
}
