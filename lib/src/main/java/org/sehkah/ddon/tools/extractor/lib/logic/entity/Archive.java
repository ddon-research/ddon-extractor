package org.sehkah.ddon.tools.extractor.lib.logic.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
    @MetaInformation
    private final Map<String, byte[]> ResourceFiles;
}
