package org.sehkah.ddon.tools.extractor.season3.resource.entity.binary;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

import java.util.List;

public record ClassData(
        long ID,
        @MetaInformation
        String resourceName,
        long classParam,
        @MetaInformation
        int propNum,
        @MetaInformation
        int init,
        @MetaInformation
        int reserved,
        List<PropertyHeader> properties
) {

}
