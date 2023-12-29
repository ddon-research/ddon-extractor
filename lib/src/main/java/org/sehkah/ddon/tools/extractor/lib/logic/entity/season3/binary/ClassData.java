package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.binary;

import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
