package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Color4l;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector4f;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CharacterEditColorDef extends CharacterEditPaletteBase {
    private boolean Use;
    private Vector4f ColorValue;
    private Color4l UIColor;

    public CharacterEditColorDef(CharacterEditPaletteBase base, boolean use, Vector4f colorValue, Color4l UIColor) {
        this(base.getIconNo(), base.getReleaseVersion(), base.getFlag(), use, colorValue, UIColor);
    }

    public CharacterEditColorDef(long IconNo, long ReleaseVersion, long Flag, boolean use, Vector4f colorValue, Color4l UIColor) {
        super(IconNo, ReleaseVersion, Flag);
        Use = use;
        ColorValue = colorValue;
        this.UIColor = UIColor;
    }
}
