package org.sehkah.ddon.tools.extractor.api.logic.resource;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ResourceCache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class ResourceMetadataLookupUtil {
    protected final ResourceCache cache;
    private final Map<String, Map<Integer, GMDTranslation>> translationMap;

    protected ResourceMetadataLookupUtil(Path clientRootFolder, Path clientTranslationFile) {
        cache = new ResourceCache(clientRootFolder);
        translationMap = loadTranslationMap(clientTranslationFile);
    }

    private static List<GMDTranslation> loadTranslation(Path filePath) {
        GMDTranslationSerializer translationSerializer = GMDTranslationSerializer.get();
        try {
            String gmdTranslationContent = Files.readString(filePath);
            return translationSerializer.deserialize(gmdTranslationContent);
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }

    private Map<String, Map<Integer, GMDTranslation>> loadTranslationMap(Path filePath) {
        List<GMDTranslation> deserialized = loadTranslation(filePath);
        Map<String, Map<Integer, GMDTranslation>> result = HashMap.newHashMap(6000);
        deserialized.forEach(gmdTranslation -> {
            String gmdFilePath = (gmdTranslation.getArcPath().substring(1).replace(".arc", "") + '/' + gmdTranslation.getGmdPath()).replace('\\', '/');
            Map<Integer, GMDTranslation> gmdIndexTranslationMap = result.getOrDefault(gmdFilePath, HashMap.newHashMap(21504));
            gmdIndexTranslationMap.put(gmdTranslation.getReadIndex(), gmdTranslation);
            result.putIfAbsent(gmdFilePath, gmdIndexTranslationMap);
        });
        return result;
    }

    public Translation getMessageTranslation(String gmdFilePath, int msgGmdIdx) {
        Map<Integer, GMDTranslation> gmdTranslationMap = translationMap.get(gmdFilePath);
        if (gmdTranslationMap == null) {
            log.warn("Missing translation file for {}.", gmdFilePath);
            return null;
        } else {
            GMDTranslation messageTranslation = gmdTranslationMap.get(msgGmdIdx);
            if (messageTranslation == null) {
                log.warn("Missing translation for ID {} in file {}.", msgGmdIdx, gmdFilePath);
                return null;
            }
            return new Translation(messageTranslation.getMsgJp(), messageTranslation.getMsgEn());
        }
    }

    public Translation getMessageTranslation(String gmdFilePath, String key) {
        Map<Integer, GMDTranslation> gmdTranslationMap = translationMap.get(gmdFilePath);
        if (gmdTranslationMap == null) {
            log.warn("Missing translation file for {}.", gmdFilePath);
            return null;
        } else {
            Collection<GMDTranslation> values = gmdTranslationMap.values();
            for (GMDTranslation value : values) {
                if (value.getKey().equals(key)) {
                    return new Translation(value.getMsgJp(), value.getMsgEn());
                }
            }
            log.warn("Missing translation for key {} in file {}.", key, gmdFilePath);
            return null;
        }
    }

    public String getMessageTranslationKey(String gmdFilePath, int msgGmdIdx) {
        Map<Integer, GMDTranslation> gmdTranslationMap = translationMap.get(gmdFilePath);
        if (gmdTranslationMap == null) {
            log.warn("Missing translation file for {}.", gmdFilePath);
            return null;
        } else {
            GMDTranslation messageTranslation = gmdTranslationMap.get(msgGmdIdx);
            return messageTranslation.getKey();
        }
    }

    public abstract Translation getNpcName(long npcId);

    public abstract Translation getStageNameByStageNo(int stageNo);

    public abstract Translation getStageNameByStageId(int stageId);

    public abstract Translation getItemName(long itemId);
}
