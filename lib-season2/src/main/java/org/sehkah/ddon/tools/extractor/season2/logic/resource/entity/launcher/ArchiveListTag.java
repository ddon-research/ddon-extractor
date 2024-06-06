package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.launcher;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ArchiveListTag {
    @MetaInformation
    private long ArcPathPointer;
    private String ArcPath;
    private long TagId;
    private long Group;
    private long Type;
    private long NodeNum;
    @MetaInformation
    private long NodeArrayPointer;
    private List<ArchiveListNode> NodeArray;
}
