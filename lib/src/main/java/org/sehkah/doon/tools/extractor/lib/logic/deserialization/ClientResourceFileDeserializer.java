package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.doon.tools.extractor.lib.common.error.FileParsingIncompleteException;
import org.sehkah.doon.tools.extractor.lib.common.error.MagicValidationFailedException;
import org.sehkah.doon.tools.extractor.lib.common.error.VersionValidationFailedException;
import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;

public abstract class ClientResourceFileDeserializer implements Deserializer<TopLevelClientResource> {
    protected final ClientResourceFile clientResourceFile;

    protected ClientResourceFileDeserializer(ClientResourceFile clientResourceFile) {
        this.clientResourceFile = clientResourceFile;
    }

    @Override
    public TopLevelClientResource deserialize(FileReader fileReader) {
        if (clientResourceFile.fileHeader.magicString != null && !clientResourceFile.fileHeader.isMagicValid(fileReader)) {
            throw new MagicValidationFailedException(clientResourceFile);
        }
        if (clientResourceFile.fileHeader.versionNumber >= 0 && !clientResourceFile.fileHeader.isVersionValid(fileReader)) {
            throw new VersionValidationFailedException(clientResourceFile);
        }
        TopLevelClientResource result = parseClientResourceFile(fileReader);
        if (fileReader.hasRemaining()) {
            throw new FileParsingIncompleteException(fileReader.getRemainingCount(), fileReader.getLimit());
        }
        result.setFileSize(fileReader.getLimit());
        result.setMagicString(clientResourceFile.fileHeader.magicString);
        result.setVersionNumber(clientResourceFile.fileHeader.versionNumber);
        return result;
    }

    protected abstract TopLevelClientResource parseClientResourceFile(FileReader fileReader);
}
