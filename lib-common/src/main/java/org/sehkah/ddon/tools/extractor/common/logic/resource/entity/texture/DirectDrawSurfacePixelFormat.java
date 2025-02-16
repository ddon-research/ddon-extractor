package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
/**
 * https://learn.microsoft.com/en-us/windows/win32/direct3ddds/dds-pixelformat
 */
public class DirectDrawSurfacePixelFormat {
    private long Size;
    private long Flags;
    private long FourCC;
    private long RGBBitCount;
    private long RBitMask;
    private long GBitMask;
    private long BBitMask;
    private long ABitMask;
}
