package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.texture;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.RenderTargetTexture;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.TextureHeader;

import java.nio.file.Path;


@Slf4j
public class RenderTargetTextureDeserializer extends ClientResourceFileDeserializer<RenderTargetTexture> {
    @Override
    protected RenderTargetTexture parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        // Version will be read in twice to make processing easier.
        bufferReader.setPosition(bufferReader.getPosition() - 2);

        TextureHeader Header = TextureDeserializer.readTextureHeader(bufferReader);

        return new RenderTargetTexture(Header);
    }
}
