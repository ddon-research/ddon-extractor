package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

@RequiredArgsConstructor
@JsonPropertyOrder(alphabetic = true)
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
