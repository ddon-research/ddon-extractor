package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.GUIMessage;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.meta.GUIMessageIndex;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GUIMessageDeserializer extends FileDeserializer {
    public GUIMessageDeserializer(FileReader fileReader) {
        super(ExtensionMap.rGUIMessage, fileReader);
    }

    private static GUIMessage readEntity(FileReader fileReader, Long version) {
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

        return new GUIMessage(version, languageId, updateTime, indexNum, messageNum, indexNameBufferSize, bufferSize, packageName, indices, hashTable);
    }

    @Override
    protected Object readObject() {
        return readEntity(fileReader, extension.fileHeader.versionNumber);
    }
}
