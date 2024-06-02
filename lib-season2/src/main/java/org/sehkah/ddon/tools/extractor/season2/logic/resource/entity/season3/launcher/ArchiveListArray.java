package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.launcher;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class ArchiveListArray extends TopLevelClientResource {
    private final long MagicNo;
    private final long ConvHash;
    private final int TagNum;
    // name of ALA file
    private final int TargetTagNo;
    private final List<ArchiveListTag> Tag;
}
