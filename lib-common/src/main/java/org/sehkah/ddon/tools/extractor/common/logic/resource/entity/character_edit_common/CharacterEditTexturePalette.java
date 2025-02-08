package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.math.BigInteger;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CharacterEditTexturePalette extends CharacterEditPaletteBase {
    private long UID;
    private BigInteger TextureResPath;
    private long Random;

    public CharacterEditTexturePalette(CharacterEditPaletteBase base, long UID, BigInteger textureResPath, long random) {
        this(base.getIconNo(), base.getReleaseVersion(), base.getFlag(), UID, textureResPath, random);
    }

    public CharacterEditTexturePalette(long IconNo, long ReleaseVersion, long Flag, long UID, BigInteger textureResPath, long random) {
        super(IconNo, ReleaseVersion, Flag);
        this.UID = UID;
        TextureResPath = textureResPath;
        Random = random;
    }
}
