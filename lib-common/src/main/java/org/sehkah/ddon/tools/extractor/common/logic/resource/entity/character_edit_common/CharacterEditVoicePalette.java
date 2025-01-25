package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CharacterEditVoicePalette extends CharacterEditPaletteBase {
    private long UID;
    private long VoiceFlag;
    private int NameIndex;

    public CharacterEditVoicePalette(CharacterEditPaletteBase base, long UID, long voiceFlag, int nameIndex) {
        this(base.getIconNo(), base.getReleaseVersion(), base.getFlag(), UID, voiceFlag, nameIndex);
    }

    public CharacterEditVoicePalette(long IconNo, long ReleaseVersion, long Flag, long UID, long voiceFlag, int nameIndex) {
        super(IconNo, ReleaseVersion, Flag);
        this.UID = UID;
        VoiceFlag = voiceFlag;
        NameIndex = nameIndex;
    }
}
