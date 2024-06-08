package org.sehkah.ddon.tools.extractor.common.logic.resource.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;
import java.util.Map;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Archive extends org.sehkah.ddon.tools.extractor.api.entity.Resource {
    private int ResourceNum;
    private List<ResourceInfo> Resource;
    @JsonIgnore
    private Map<String, byte[]> ResourceFiles;

    @JsonIgnore
    public Map<String, byte[]> getResourceFiles() {
        return ResourceFiles;
    }
}
