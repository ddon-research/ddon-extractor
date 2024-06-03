package org.sehkah.ddon.tools.extractor.season3.logic.resource.serialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferWriter;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization.ClientResourceFileSerializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.GUIMessage;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.GUIMessageIndex;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class GUIMessageSerializer extends ClientResourceFileSerializer<GUIMessage> {
    @Override
    protected void serializeClientResourceFile(GUIMessage clientResource, BufferWriter bufferWriter) {
        bufferWriter.writeUnsignedInteger(clientResource.getLanguageId());
        bufferWriter.writeUnsignedLong(clientResource.getUpdateTime());
        bufferWriter.writeUnsignedInteger(clientResource.getIndexNum());
        bufferWriter.writeUnsignedInteger(clientResource.getMessageNum());
        bufferWriter.writeUnsignedInteger(clientResource.getKeyBufferSize());
        bufferWriter.writeUnsignedInteger(clientResource.getMessageBufferSize());
        bufferWriter.writeMtString(clientResource.getPackageName());

        List<GUIMessageIndex> indices = clientResource.getIndices();
        if (clientResource.getIndexNum() > 0) {
            for (int i = 0; i < clientResource.getIndexNum(); i++) {
                GUIMessageIndex index = indices.get(i);
                bufferWriter.writeUnsignedInteger(index.getIndex());
                bufferWriter.writeUnsignedInteger(index.getKeyCrcHashDouble());
                bufferWriter.writeUnsignedInteger(index.getKeyCrcHashTriple());
                bufferWriter.writeUnsignedInteger(index.getKeyOffset());
                bufferWriter.writeUnsignedInteger(index.getLinkOffset());
            }

            for (long hash : clientResource.getHashTable()) {
                bufferWriter.writeUnsignedInteger(hash);
            }

            for (int i = 0; i < clientResource.getIndexNum(); i++) {
                bufferWriter.writeNullTerminatedString(indices.get(i).getKey());
            }
        }

        for (int i = 0; i < clientResource.getMessageNum(); i++) {
            bufferWriter.writeNullTerminatedString(indices.get(i).getMessage(), StandardCharsets.UTF_8);
        }

    }
}
