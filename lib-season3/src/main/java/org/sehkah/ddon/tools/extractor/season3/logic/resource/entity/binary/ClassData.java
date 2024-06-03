package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.binary;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ClassData {
    private long ID;
    @MetaInformation
    private String resourceName;
    private long classParam;
    @MetaInformation
    private int propNum;
    @MetaInformation
    private int init;
    @MetaInformation
    private int reserved;
    private List<PropertyHeader> properties;
}
