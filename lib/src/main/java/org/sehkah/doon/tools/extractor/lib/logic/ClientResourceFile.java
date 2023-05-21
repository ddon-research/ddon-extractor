package org.sehkah.doon.tools.extractor.lib.logic;

import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileHeader;

public class ClientResourceFile {
    public final ClientResourceFileExtension fileExtension;
    public final FileHeader fileHeader;
    public final ClientSeasonType clientSeason;

    ClientResourceFile(ClientResourceFileExtension fileExtension, FileHeader fileHeader, ClientSeasonType clientSeason) {
        this.fileExtension = fileExtension;
        this.fileHeader = fileHeader;
        this.clientSeason = clientSeason;
    }
}
