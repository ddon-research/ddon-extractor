package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class GUIMessageIndex {
    private long Index;
    private long KeyCrcHashDouble;
    private long KeyCrcHashTriple;
    private long LinkOffset;
    private long KeyOffset;
    private String Key;
    @MetaInformation
    private long MessageIndex;
    private String Message;
}
