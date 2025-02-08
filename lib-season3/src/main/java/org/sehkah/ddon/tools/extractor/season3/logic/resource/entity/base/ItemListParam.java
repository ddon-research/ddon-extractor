package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemListParam {
    private short KindType;
    @MetaInformation
    private String KindTypeName;
    private Map<String, Integer> Parameters;

    public ItemListParam(short kindType, String kindTypeName, List<Integer> parameters) {
        KindType = kindType;
        KindTypeName = kindTypeName;
        Parameters = HashMap.newHashMap(parameters.size());
        for (int i = 0; i < parameters.size(); i++) {
            Parameters.put("Param" + i, parameters.get(i));
        }
    }
}
