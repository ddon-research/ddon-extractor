package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage;

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
public class AIPathBaseHierarchyArea {
    private int ID;
    private String Name;
    private long Attribute;
    private int NumberOfGeometry;
    private List<MtGeometry> GeometryList;
    private int FirstIndex;
    private int LastIndex;
    private short ParentID;
    private int NumberOfChild;
    private List<Integer> Child;
    private int NumberOfLink;
    private List<Integer> Link;
}
