package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.binary;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.binary.meta.PropertyType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class PropertyHeader {
    private String name;
    // offset from base
    private long propertyNameOffset;
    // bitfield FieldFlag { type : 8; attr : 8; bytes : 15; disable : 1; };
    private long propertyParam;
    @MetaInformation
    private int propertyParamType;
    @MetaInformation
    private PropertyType propertyParamTypeName;
    @MetaInformation
    private int propertyParamAttr;
    @MetaInformation
    private int propertyParamBytes;
    @MetaInformation
    private boolean propertyParamDisable;
    private long unknown1;
    private long unknown2;
    private long unknown3;
    private long unknown4;
}
