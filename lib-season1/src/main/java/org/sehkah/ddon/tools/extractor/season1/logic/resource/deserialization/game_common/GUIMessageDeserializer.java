package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.GUIMessage;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.GUIMessageIndex;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GUIMessageDeserializer extends ClientResourceFileDeserializer {
    public GUIMessageDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    @Override
    protected GUIMessage parseClientResourceFile(BufferReader bufferReader) {
        long languageId = bufferReader.readUnsignedInteger();
        BigInteger updateTime = bufferReader.readUnsignedLong();
        long indexNum = bufferReader.readUnsignedInteger();
        long messageNum = bufferReader.readUnsignedInteger();
        long indexNameBufferSize = bufferReader.readUnsignedInteger();
        long bufferSize = bufferReader.readUnsignedInteger();
        String packageName = bufferReader.readMtString();

        long maxEntries = Math.max(indexNum, messageNum);
        List<GUIMessageIndex> indices = new ArrayList<>((int) maxEntries);
        for (int i = 0; i < maxEntries; i++) {
            indices.add(new GUIMessageIndex());
        }

        long[] hashTable = new long[256];
        if (indexNum > 0) {
            for (int i = 0; i < indexNum; i++) {
                GUIMessageIndex index = indices.get(i);
                index.setIndex(bufferReader.readUnsignedInteger());
                index.setKeyCrcHashDouble(bufferReader.readUnsignedInteger());
                index.setKeyCrcHashTriple(bufferReader.readUnsignedInteger());
                index.setKeyOffset(bufferReader.readUnsignedInteger());
                index.setLinkOffset(bufferReader.readUnsignedInteger());
            }

            for (int i = 0; i < hashTable.length; i++) {
                hashTable[i] = bufferReader.readUnsignedInteger();
            }

            for (int i = 0; i < indexNum; i++) {
                indices.get(i).setKey(bufferReader.readNullTerminatedString());
            }
        }

        for (int i = 0; i < messageNum; i++) {
            GUIMessageIndex index = indices.get(i);
            index.setMessage(bufferReader.readNullTerminatedString(StandardCharsets.UTF_8));
            index.setMessageIndex(i);
        }

        return new GUIMessage(languageId, updateTime, indexNum, messageNum, indexNameBufferSize, bufferSize, packageName, indices, hashTable);
    }
}
