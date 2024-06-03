package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class GUIMessageIndex {
    public long Index;
    public long KeyCrcHashDouble;
    public long KeyCrcHashTriple;
    public long LinkOffset;
    public long KeyOffset;
    public String Key;
    @MetaInformation
    public long MessageIndex;
    public String Message;
}
