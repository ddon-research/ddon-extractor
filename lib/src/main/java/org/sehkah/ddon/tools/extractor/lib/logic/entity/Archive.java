package org.sehkah.ddon.tools.extractor.lib.logic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;
import java.util.Map;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Archive extends TopLevelClientResource {
    private final int ResourceNum;
    private final List<ResourceInfo> Resource;
    @JsonIgnore
    private final Map<String, byte[]> ResourceFiles;

    @JsonIgnore
    public Map<String, byte[]> getResourceFiles() {
        return ResourceFiles;
    }
}
