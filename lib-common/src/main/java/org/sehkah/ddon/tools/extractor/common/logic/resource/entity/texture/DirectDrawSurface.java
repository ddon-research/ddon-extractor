package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;

/**
 * Not an actual DDON resource, but the MtFramework makes use of compressed DirectX textures in the PC client,
 * so it's useful to be able to translate it from the custom format into something that is more usable.
 * <a href="https://learn.microsoft.com/en-us/windows/win32/direct3ddds/dds-file-layout-for-cubic-environment-maps">...</a>
 * <a href="https://learn.microsoft.com/en-us/windows/win32/direct3ddds/dds-file-layout-for-textures">...</a>
 * <a href="https://github.com/microsoft/Windows-classic-samples/blob/main/Samples/DirectXTextureConverter/Cpp/DDS.h">...</a>
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class DirectDrawSurface extends Resource {
    private DirectDrawSurfaceHeader Header;
    private List<Byte> Data;
}
