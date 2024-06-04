package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.launcher;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ArchiveListArrayHeader {
    private long Version;
    private long MagicNo;
    private long ConvHash;
    private int TagNum;
    private int TargetTagNo;
    private List<ArchiveListTag> Tag;
}
