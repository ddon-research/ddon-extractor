package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class DrawTexture {
    @MetaInformation
    private long MipLevel;
    @JsonIgnore
    // Ignore data for now as it would blow up the repository too much.
    private List<Byte> Data;
}
