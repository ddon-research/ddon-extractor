package org.sehkah.ddon.tools.extractor.season2.logic.resource;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.GUIMessage;

import java.nio.file.Path;

/**
 * This is a util class which supports looking up message-related meta information via entity classes.
 */
@Slf4j
@Setter
public class ResourceMetadataLookupUtilSeason2 extends ResourceMetadataLookupUtil {
    private final ClientResourceFile<GUIMessage> GUIMessageResourceFile;

    public ResourceMetadataLookupUtilSeason2(Path clientRootFolder, ClientResourceFile<GUIMessage> GUIMessageResourceFile) {
        super(clientRootFolder);
        this.GUIMessageResourceFile = GUIMessageResourceFile;
    }

    @Override
    public String getMessage(String filePath, long messageIndex) {
        GUIMessage resource = cache.getResource(filePath, GUIMessageResourceFile);
        return resource.getMessageByIndex(messageIndex);
    }

    @Override
    public String getMessageKey(String filePath, long messageIndex) {
        GUIMessage resource = cache.getResource(filePath, GUIMessageResourceFile);
        return resource.getMessageKeyByIndex(messageIndex);
    }

    @Override
    public String getMessage(String filePath, String key) {
        GUIMessage resource = cache.getResource(filePath, GUIMessageResourceFile);
        return resource.getMessageByKey(key);
    }
}
