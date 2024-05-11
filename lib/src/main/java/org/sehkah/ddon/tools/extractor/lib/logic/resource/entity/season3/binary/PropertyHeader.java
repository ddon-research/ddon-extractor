package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary;

import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

@RequiredArgsConstructor
public class PropertyHeader {
    public String name;
    // offset from base
    public long propertyNameOffset;
    // bitfield FieldFlag { type : 8; attr : 8; bytes : 15; disable : 1; };
    public long propertyParam;
    @MetaInformation
    public int propertyParamType;
    @MetaInformation
    public int propertyParamAttr;
    @MetaInformation
    public int propertyParamBytes;
    @MetaInformation
    public int propertyParamDisable;
    public long unk1;
    public long unk2;
    public long unk3;
    public long unk4;
}
