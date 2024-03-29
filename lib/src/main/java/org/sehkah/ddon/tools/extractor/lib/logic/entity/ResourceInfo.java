package org.sehkah.ddon.tools.extractor.lib.logic.entity;

import org.sehkah.ddon.tools.extractor.lib.logic.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.meta.ArchiveQuality;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.math.BigInteger;

public record ResourceInfo(
        String Path,
        @MetaInformation
        long PathCRC,
        @MetaInformation
        BigInteger ResourceId,
        long Type,
        @MetaInformation
        String TypeName,
        @MetaInformation
        String TypeExtension,
        long DataSize,
        long OriginalSize,
        long Quality,
        @MetaInformation
        ArchiveQuality QualityName,
        long Offset
) {
    public ResourceInfo(String path, long type, long dataSize, long orgSize, long quality, long offset) {
        this(
                path, FrameworkResourcesUtil.convertResourcePathToPathId(path), FrameworkResourcesUtil.convertToResourceId(type, path),
                type, FrameworkResourcesUtil.getFrameworkResourceClassNameByCrc(type), FrameworkResourcesUtil.getFileExtension(type),
                dataSize,
                orgSize,
                quality, ArchiveQuality.of(quality),
                offset);
    }
}
