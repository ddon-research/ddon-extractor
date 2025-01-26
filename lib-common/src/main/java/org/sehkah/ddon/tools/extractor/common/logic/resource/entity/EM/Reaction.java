package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM;

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
public class Reaction {
    private ReactionTrigger ReactTrigger;
    private List<ReactionCondition> ReactCondition; // [4];
    private boolean mAllCondition;
    private List<ReactionAction> mReactAction; //[4];
    private long ForceReaction;
    private long OptionFlg;
}
