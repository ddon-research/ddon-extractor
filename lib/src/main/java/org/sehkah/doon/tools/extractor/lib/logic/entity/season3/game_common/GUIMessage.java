package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.meta.GUIMessageLanguageType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.math.BigInteger;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class GUIMessage extends TopLevelClientResource {
    private final long LanguageId;
    @MetaInformation
    private final GUIMessageLanguageType Language;
    private final BigInteger UpdateTime;
    private final long IndexNum;
    private final long MessageNum;
    private final long IndexNameBufferSize;
    private final long BufferSize;
    private final String PackageName;
    private final List<GUIMessageIndex> Indices;
    private final long[] HashTable;

    public GUIMessage(long languageId, BigInteger updateTime, long indexNum, long messageNum, long indexNameBufferSize, long bufferSize, String packageName, List<GUIMessageIndex> indices, long[] hashTable) {
        this(
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
