package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.common.error.FileParsingIncompleteException;
import org.sehkah.doon.tools.extractor.lib.common.error.MagicValidationFailedException;
import org.sehkah.doon.tools.extractor.lib.common.error.VersionValidationFailedException;
import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ClientResourceFileDeserializer<T> implements Deserializer<T> {
    private static final Logger logger = LoggerFactory.getLogger(ClientResourceFileDeserializer.class);
    protected final ClientResourceFile clientResourceFile;

    protected ClientResourceFileDeserializer(ClientResourceFile clientResourceFile) {
        this.clientResourceFile = clientResourceFile;
    }

    @Override
    public T deserialize(FileReader fileReader) {
        if (clientResourceFile.fileHeader.magicString != null && !clientResourceFile.fileHeader.isMagicValid(fileReader)) {
            throw new MagicValidationFailedException(clientResourceFile);
        }
        if (clientResourceFile.fileHeader.versionNumber >= 0 && !clientResourceFile.fileHeader.isVersionValid(fileReader)) {
            throw new VersionValidationFailedException(clientResourceFile);
        }
        T result = parseClientResourceFile(fileReader);
        if (fileReader.hasRemaining()) {
            throw new FileParsingIncompleteException(fileReader.getRemainingCount(), fileReader.getLimit());
        }
        return result;
    }

    protected abstract T parseClientResourceFile(FileReader fileReader);
}
