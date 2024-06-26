package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.meta.GUIMessageLanguageType;

import java.math.BigInteger;
import java.util.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class GUIMessage extends Resource {
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

    public void updateMessage(String key, String message) {
        GUIMessageIndex messageIndex = Indices.stream().filter(guiMessageIndex -> guiMessageIndex.getKey().equals(key)).findFirst().orElse(null);
        int oldMessageLength = messageIndex.getMessage().length();
        int newMessageLength = message.length();
        MessageBufferSize -= oldMessageLength;
        FileSize -= oldMessageLength;
        MessageBufferSize += newMessageLength;
        FileSize += newMessageLength;
        messageIndex.setMessage(message);
    }

    public void updateMessages(Map<String, String> keyMessageMap) {
        keyMessageMap.forEach(this::updateMessage);
    }

    public String getMessageByKey(String key) {
        Optional<GUIMessageIndex> optionalIndex = Indices.stream().filter(guiMessageIndex -> guiMessageIndex.getKey().equals(key)).findFirst();
        return optionalIndex.map(GUIMessageIndex::getMessage).orElse(null);
    }

    public String getMessageByIndex(long index) {
        return getMessageByIndexNaive(index);
    }

    public String getMessageKeyByIndex(long index) {
        return getMessageKeyByIndexNaive(index);
    }

    public String getMessageByIndexBinarySearch(long index) {
        GUIMessageIndex tmp = new GUIMessageIndex();
        tmp.setMessageIndex(index);
        int idx = Collections.binarySearch(Indices, tmp, Comparator.comparingLong(GUIMessageIndex::getMessageIndex));
        return Indices.get(idx).getMessage();
    }

    public String getMessageByIndexNaive(long index) {
        Optional<GUIMessageIndex> optionalIndex = Indices.stream().filter(i -> i.getMessageIndex() == index).findFirst();
        return optionalIndex.map(GUIMessageIndex::getMessage).orElse(null);
    }

    public String getMessageKeyByIndexNaive(long index) {
        Optional<GUIMessageIndex> optionalIndex = Indices.stream().filter(i -> i.getMessageIndex() == index).findFirst();
        return optionalIndex.map(GUIMessageIndex::getKey).orElse(null);
    }
}
