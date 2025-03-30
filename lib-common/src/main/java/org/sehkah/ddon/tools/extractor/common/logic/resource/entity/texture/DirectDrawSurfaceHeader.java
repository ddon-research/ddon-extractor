package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

/**
 * https://learn.microsoft.com/en-us/windows/win32/direct3ddds/dds-header
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class DirectDrawSurfaceHeader {
    private long Flags;
    private long Height;
    private long Width;
    private long PitchOrLinearSize;
    private long Depth;
    private long MipMapCount;
    private List<Integer> Reserved1;//11
    private DirectDrawSurfacePixelFormat ddspf;
    private long Caps;
    private long Caps2;
    private long Caps3;
    private long Caps4;
    private long Reserved2;
}
