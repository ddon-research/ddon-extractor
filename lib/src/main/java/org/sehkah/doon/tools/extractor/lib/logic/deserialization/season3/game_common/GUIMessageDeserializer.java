package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.GUIMessage;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.GUIMessageIndex;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GUIMessageDeserializer extends ClientResourceFileDeserializer {
    public GUIMessageDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    @Override
    protected GUIMessage parseClientResourceFile(FileReader fileReader) {
        long languageId = fileReader.readUnsignedInteger();
        BigInteger updateTime = fileReader.readUnsignedLong();
        long indexNum = fileReader.readUnsignedInteger();
        long messageNum = fileReader.readUnsignedInteger();
        long indexNameBufferSize = fileReader.readUnsignedInteger();
        long bufferSize = fileReader.readUnsignedInteger();
        String packageName = fileReader.readMtString();

        long maxEntries = Math.max(indexNum, messageNum);
        List<GUIMessageIndex> indices = new ArrayList<>((int) maxEntries);
        for (int i = 0; i < maxEntries; i++) {
            indices.add(new GUIMessageIndex());
        }

        long[] hashTable = new long[256];
        if (indexNum > 0) {
            for (int i = 0; i < indexNum; i++) {
                GUIMessageIndex index = indices.get(i);
                index.index = fileReader.readUnsignedInteger();
                index.crcHashDouble = fileReader.readUnsignedInteger();
                index.crcHashTriple = fileReader.readUnsignedInteger();
                index.offset = fileReader.readUnsignedInteger();
                index.linkOffset = fileReader.readUnsignedInteger();
            }

            for (int i = 0; i < hashTable.length; i++) {
                hashTable[i] = fileReader.readUnsignedInteger();
            }

            for (int i = 0; i < indexNum; i++) {
                indices.get(i).key = fileReader.readNullTerminatedString();
            }
        }

        for (int i = 0; i < messageNum; i++) {
            GUIMessageIndex index = indices.get(i);
            index.message = fileReader.readNullTerminatedString(StandardCharsets.UTF_8);
            index.messageIndex = i;
        }

        return new GUIMessage(clientResourceFile.fileHeader.versionNumber, languageId, updateTime, indexNum, messageNum, indexNameBufferSize, bufferSize, packageName, indices, hashTable);
    }
}
