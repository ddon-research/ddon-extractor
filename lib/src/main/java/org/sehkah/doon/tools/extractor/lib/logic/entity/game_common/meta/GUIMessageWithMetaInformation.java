package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.meta;

import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.GUIMessage;

import java.math.BigInteger;
import java.util.List;

public record GUIMessageWithMetaInformation(
        long Version,
        long LanguageId,
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
    public GUIMessageWithMetaInformation(GUIMessage guiMessage) {
        this(
                guiMessage.Version(),
                guiMessage.LanguageId(), GUIMessageLanguageType.of(guiMessage.LanguageId()),
                guiMessage.UpdateTime(),
                guiMessage.IndexNum(),
                guiMessage.MessageNum(),
                guiMessage.IndexNameBufferSize(),
                guiMessage.BufferSize(),
                guiMessage.PackageName(),
                guiMessage.Indices(),
                guiMessage.HashTable()
        );
    }
}
