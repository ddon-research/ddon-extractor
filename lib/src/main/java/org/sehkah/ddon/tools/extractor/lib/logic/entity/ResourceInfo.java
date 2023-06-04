package org.sehkah.ddon.tools.extractor.lib.logic.entity;

import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFileExtension;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.meta.ArchiveQuality;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

public record ResourceInfo(
        String Path,
        long Type,
        @MetaInformation
        ClientResourceFileExtension TypeName,
        long DataSize,
        long OriginalSize,
        long Quality,
        @MetaInformation
        ArchiveQuality QualityName,
        long Offset
) {
    public ResourceInfo(String path, long type, long dataSize, long orgSize, long quality, long offset) {
        this(
                path,
                type, ClientResourceFileExtension.getClientResourceFileExtensionByCrc(type),
                dataSize,
                orgSize,
                quality, ArchiveQuality.of(quality),
                offset);
    }
}
