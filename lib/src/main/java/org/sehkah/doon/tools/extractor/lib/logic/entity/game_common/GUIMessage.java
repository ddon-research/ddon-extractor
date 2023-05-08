package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common;

import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.meta.GUIMessageIndex;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.meta.GUIMessageLanguageType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.math.BigInteger;
import java.util.List;

public record GUIMessage(
        long Version,
        long LanguageId,
        @MetaInformation
        GUIMessageLanguageType Language,
        BigInteger UpdateTime,
        long IndexNum,
        long MessageNum,
        long IndexNameBufferSize,
        long BufferSize,
        String PackageName,
        List<GUIMessageIndex> Indices,
        long[] HashTable
) {
    public GUIMessage(long version, long languageId, BigInteger updateTime, long indexNum, long messageNum, long indexNameBufferSize, long bufferSize, String packageName, List<GUIMessageIndex> indices, long[] hashTable) {
        this(
                version,
                languageId, GUIMessageLanguageType.of(languageId),
                updateTime,
                indexNum,
                messageNum,
                indexNameBufferSize,
                bufferSize,
                packageName,
                indices,
                hashTable);
    }
}
