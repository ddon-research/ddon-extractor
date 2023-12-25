package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.GUIMessageLanguageType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class GUIMessage extends TopLevelClientResource {
    private long LanguageId;
    @MetaInformation
    private GUIMessageLanguageType Language;
    private BigInteger UpdateTime;
    private long IndexNum;
    private long MessageNum;
    private long KeyBufferSize;
    private long MessageBufferSize;
    private String PackageName;
    private List<GUIMessageIndex> Indices;
    private long[] HashTable;

    public GUIMessage(long languageId, BigInteger updateTime, long indexNum, long messageNum, long keyBufferSize, long messageBufferSize, String packageName, List<GUIMessageIndex> indices, long[] hashTable) {
        this(
                languageId, GUIMessageLanguageType.of(languageId),
                updateTime,
                indexNum,
                messageNum,
                keyBufferSize,
                messageBufferSize,
                packageName,
                indices,
                hashTable);
    }

    public void updateMessage(String key, String message) {
        GUIMessageIndex messageIndex = Indices.stream().filter(guiMessageIndex -> guiMessageIndex.Key.equals(key)).findFirst().orElse(null);
        MessageBufferSize -= messageIndex.Message.length();
        MessageBufferSize += message.length();
        messageIndex.Message = message;
    }

    public void updateMessages(Map<String, String> keyMessageMap) {
        keyMessageMap.forEach(this::updateMessage);
    }

    @MetaInformation
    public GUIMessageLanguageType getLanguage() {
        return Language;
    }
}
