package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.om;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class OmKeyOmKey {
    private int OmId;
    private long KeyType;
    private Vector3f Pos;
    private boolean Horizontal;
}
