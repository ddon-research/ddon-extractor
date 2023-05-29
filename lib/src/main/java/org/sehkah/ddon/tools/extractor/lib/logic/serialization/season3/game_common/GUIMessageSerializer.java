package org.sehkah.ddon.tools.extractor.lib.logic.serialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileWriter;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.GUIMessage;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.GUIMessageIndex;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.ClientResourceFileSerializer;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class GUIMessageSerializer extends ClientResourceFileSerializer<GUIMessage> {
    public GUIMessageSerializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    @Override
    protected void serializeClientResourceFile(GUIMessage clientResource, FileWriter fileWriter) {
        fileWriter.writeUnsignedInteger(clientResource.getLanguageId());
        fileWriter.writeUnsignedLong(clientResource.getUpdateTime());
        fileWriter.writeUnsignedInteger(clientResource.getIndexNum());
        fileWriter.writeUnsignedInteger(clientResource.getMessageNum());
        fileWriter.writeUnsignedInteger(clientResource.getKeyBufferSize());
        fileWriter.writeUnsignedInteger(clientResource.getMessageBufferSize());
        fileWriter.writeMtString(clientResource.getPackageName());

        List<GUIMessageIndex> indices = clientResource.getIndices();
        if (clientResource.getIndexNum() > 0) {
            for (int i = 0; i < clientResource.getIndexNum(); i++) {
                GUIMessageIndex index = indices.get(i);
                fileWriter.writeUnsignedInteger(index.Index);
                fileWriter.writeUnsignedInteger(index.KeyCrcHashDouble);
                fileWriter.writeUnsignedInteger(index.KeyCrcHashTriple);
                fileWriter.writeUnsignedInteger(index.KeyOffset);
                fileWriter.writeUnsignedInteger(index.LinkOffset);
            }

            for (long hash : clientResource.getHashTable()) {
                fileWriter.writeUnsignedInteger(hash);
            }

            for (int i = 0; i < clientResource.getIndexNum(); i++) {
                fileWriter.writeNullTerminatedString(indices.get(i).Key);
            }
        }

        for (int i = 0; i < clientResource.getMessageNum(); i++) {
            fileWriter.writeNullTerminatedString(indices.get(i).Message, StandardCharsets.UTF_8);
        }

    }
}
