package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.meta.FormatType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.meta.TextureType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class TextureHeader {
    private long Attr;// 8
    private long Prebias;// 4
    private long Type;// 4
    @MetaInformation
    private TextureType TypeName;
    private long LevelCount;// 6
    private long Width;//13
    private long Height;//13
    private long ArrayCount;// 8
    private long Format;// 8
    @MetaInformation
    private FormatType FormatName;
    private long Depth;//13
    private boolean AutoResize;// 1
    private boolean RenderTarget;// 1
    private boolean UseVtf;// 1
    private boolean HasSphericalHarmonicsFactors;
    private long MipLevelCount;
    @MetaInformation
    private long PitchOrLinearSize;
}
