package org.sehkah.ddon.tools.extractor.api.logic.resource;

import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Translation {
    private String Jp;
    private String En;

    public static Translation concatenateTranslations(List<Translation> translations) {
        StringBuilder jpBuilder = new StringBuilder();
        StringBuilder enBuilder = new StringBuilder();

        for (Translation t : translations) {
            if (t == null) {
                continue;
            }
            if (!jpBuilder.isEmpty()) {
                jpBuilder.append(" ");
            }
            if (!enBuilder.isEmpty()) {
                enBuilder.append(" ");
            }
            jpBuilder.append(t.getJp());
            enBuilder.append(t.getEn());
        }

        return new Translation(jpBuilder.toString(), enBuilder.toString());
    }
}
