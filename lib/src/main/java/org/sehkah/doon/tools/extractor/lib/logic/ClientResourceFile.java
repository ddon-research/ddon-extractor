package org.sehkah.doon.tools.extractor.lib.logic;

import lombok.ToString;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileHeader;

@ToString
public class ClientResourceFile {
    public final ClientResourceFileExtension fileExtension;
    public final FileHeader fileHeader;

    ClientResourceFile(ClientResourceFileExtension fileExtension, FileHeader fileHeader) {
        this.fileExtension = fileExtension;
        this.fileHeader = fileHeader;
    }
}
