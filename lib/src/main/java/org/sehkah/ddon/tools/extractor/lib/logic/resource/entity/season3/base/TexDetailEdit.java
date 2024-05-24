package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary.BinaryHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary.TexDetailEditBinaryBody;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class TexDetailEdit extends TopLevelClientResource {
    @MetaInformation
    private final BinaryHeader binaryHeader;
    private final TexDetailEditBinaryBody binaryBody;
}
