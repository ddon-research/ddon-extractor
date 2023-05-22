package org.sehkah.ddon.tools.extractor.lib.logic;

import lombok.Data;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.FileHeader;

@Data
public class ClientResourceFile {
    private final ClientResourceFileExtension fileExtension;
    private final FileHeader fileHeader;
}
