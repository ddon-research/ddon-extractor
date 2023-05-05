package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.GUIMessage;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.GUIMessageIndex;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GUIMessageDeserializer extends FileDeserializer {
    public GUIMessageDeserializer(FileReader fileReader) {
        super(ExtensionMap.rGUIMessage, fileReader);
    }


    @Override
    protected Object readObject() {
        long LanguageId = fileReader.readUnsignedInteger();
        BigInteger UpdateTime = fileReader.readUnsignedLong();
        long IndexNum = fileReader.readUnsignedInteger();
        long MessageNum = fileReader.readUnsignedInteger();
        long IndexNameBufferSize = fileReader.readUnsignedInteger();
        long BufferSize = fileReader.readUnsignedInteger();
        String PackageName = fileReader.readMtString();

        long maxEntries = Math.max(IndexNum, MessageNum);
        List<GUIMessageIndex> indices = new ArrayList<>((int) maxEntries);
        for (int i = 0; i < maxEntries; i++) {
            indices.add(new GUIMessageIndex());
        }

        long[] hashTable = new long[256];
        if (IndexNum > 0) {
            for (int i = 0; i < IndexNum; i++) {
                GUIMessageIndex index = indices.get(i);
                index.Index = fileReader.readUnsignedInteger();
                index.CrcHashDouble = fileReader.readUnsignedInteger();
                index.CrcHashTriple = fileReader.readUnsignedInteger();
                index.Offset = fileReader.readUnsignedInteger();
                index.LinkOffset = fileReader.readUnsignedInteger();
            }

            for (int i = 0; i < hashTable.length; i++) {
                hashTable[i] = fileReader.readUnsignedInteger();
            }

            for (int i = 0; i < IndexNum; i++) {
                indices.get(i).Key = fileReader.readNullTerminatedString();
            }
        }

        for (int i = 0; i < MessageNum; i++) {
            GUIMessageIndex index = indices.get(i);
            index.Message = fileReader.readNullTerminatedString(StandardCharsets.UTF_8);
            index.MessageIndex = i;
        }

        return new GUIMessage(version, LanguageId, UpdateTime, IndexNum, MessageNum, IndexNameBufferSize, BufferSize, PackageName, indices, hashTable);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
