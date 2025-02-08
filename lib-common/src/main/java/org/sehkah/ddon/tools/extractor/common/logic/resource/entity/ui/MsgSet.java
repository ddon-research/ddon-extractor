package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class MsgSet extends Resource {
    private long NativeMsgGroupArrayNum;
    private long NativeMsgDataArrayNum;
    private List<MsgGroup> NativeMsgGroupArray;

    public MsgData findMessageById(long msgSerial) {
        return findMessageByIdNaive(msgSerial);
    }

    private MsgData findMessageByIdNaive(long msgSerial) {
        return NativeMsgGroupArray.stream()
                .flatMap(msgGroup -> msgGroup.getMsgData().stream())
                .filter(msgData -> msgData.getMsgSerial() == msgSerial)
                .findFirst()
                .orElse(null);
    }

    public MsgGroup findMessageGroupById(long msgGroupSerial) {
        return findMessageGroupByIdNaive(msgGroupSerial);
    }

    private MsgGroup findMessageGroupByIdNaive(long msgGroupSerial) {
        return NativeMsgGroupArray.stream()
                .filter(msgGroup -> msgGroup.getGroupSerial() == msgGroupSerial)
                .findFirst()
                .orElse(null);
    }
}
