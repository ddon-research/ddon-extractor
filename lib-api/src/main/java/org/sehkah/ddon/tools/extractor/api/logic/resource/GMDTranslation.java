package org.sehkah.ddon.tools.extractor.api.logic.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "#Index",
        "Key",
        "MsgJp",
        "MsgEn",
        "GmdPath",
        "ArcPath",
        "ArcName",
        "ReadIndex"
})
public class GMDTranslation {
    @JsonProperty(value = "#Index")
    private String Index;

    @JsonProperty(value = "Key")
    private String Key;

    @JsonProperty(value = "MsgJp")
    private String MsgJp;

    @JsonProperty(value = "MsgEn")
    private String MsgEn;

    @JsonProperty(value = "GmdPath")
    private String GmdPath;

    @JsonProperty(value = "ArcPath")
    private String ArcPath;

    @JsonProperty(value = "ArcName")
    private String ArcName;

    @JsonProperty(value = "ReadIndex")
    private int ReadIndex;
}
