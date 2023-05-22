package org.sehkah.ddon.tools.extractor.lib.common.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.EnemyGroupList;

/**
 * This is a 'marker' interface to support generic deserializers.
 * Any class implementing this interface denotes a top-level client resource which should be eligible for deserialization or serialization.
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "enemyGroupList", value = EnemyGroupList.class)
})
public abstract class TopLevelClientResource {
    protected int FileSize;
    protected String MagicString;
    protected long VersionNumber;
}
