package org.sehkah.ddon.tools.extractor.api.logic.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GMDTranslation {
    @JsonProperty("#Index")
    private String Index;

    @JsonProperty("Key")
    private String Key;

    @JsonProperty("MsgJp")
    private String MsgJp;

    @JsonProperty("MsgEn")
    private String MsgEn;

    @JsonProperty("GmdPath")
    private String GmdPath;

    @JsonProperty("ArcPath")
    private String ArcPath;

    @JsonProperty("ArcName")
    private String ArcName;

    @JsonProperty("ReadIndex")
    private int ReadIndex;
}
