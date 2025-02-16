package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
/**
 * For now it looks like all rtex files are just headers, probably because they are accompanied by the actual texture files side by side.
 */
public class RenderTargetTexture extends Resource {
    private TextureHeader Header;
}
