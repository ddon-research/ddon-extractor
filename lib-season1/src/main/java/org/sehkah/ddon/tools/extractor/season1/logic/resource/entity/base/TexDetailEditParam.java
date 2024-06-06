package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.TexDetailEditDetailType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class TexDetailEditParam {
    private String Path;
    private long Form;
    private long Type;
    @MetaInformation
    private TexDetailEditDetailType TypeName;

    public TexDetailEditParam(String path, long form, long type) {
        this(
                path,
                form,
                type, TexDetailEditDetailType.of(type)
        );
    }
}
