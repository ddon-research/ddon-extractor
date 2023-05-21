package org.sehkah.doon.tools.extractor.lib.logic;

import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileHeader;

public class ClientResourceFile {
    public final ClientResourceFileExtension fileExtension;
    public final FileHeader fileHeader;

    ClientResourceFile(ClientResourceFileExtension fileExtension, FileHeader fileHeader) {
        this.fileExtension = fileExtension;
        this.fileHeader = fileHeader;
    }

    @Override
    public String toString() {
        return "ClientResourceFile{" +
                "fileExtension=" + fileExtension +
                ", fileHeader=" + fileHeader +
                '}';
    }
}
