package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common;

import org.sehkah.doon.tools.extractor.lib.common.error.TechnicalException;

import java.math.BigInteger;
import java.util.List;

public record GUIMessage(
        long Version,
        long LanguageId,
        BigInteger UpdateTime,
        long IndexNum,
        long MessageNum,
        long IndexNameBufferSize,
        long BufferSize,
        String PackageName,
        List<GUIMessageIndex> Indices,
        long[] HashTable
) {
}
