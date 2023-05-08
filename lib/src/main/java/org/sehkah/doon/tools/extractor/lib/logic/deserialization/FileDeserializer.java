package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.common.error.FileParsingIncompleteException;
import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;

public abstract class FileDeserializer<T> implements Deserializer<T> {
    protected final ClientResourceFile clientResourceFile;

    protected FileDeserializer(ClientResourceFile clientResourceFile) {
        this.clientResourceFile = clientResourceFile;
    }

    @Override
    public T deserialize(FileReader fileReader) {
        if (clientResourceFile.fileHeader.magicString != null && !clientResourceFile.fileHeader.isMagicValid(fileReader)) {
            return null;
        }
        if (clientResourceFile.fileHeader.versionNumber >= 0 && !clientResourceFile.fileHeader.isVersionValid(fileReader)) {
            return null;
        }
        T result = readObject(fileReader);
        if (fileReader.hasRemaining()) {
            throw new FileParsingIncompleteException(fileReader.getRemainingCount(), fileReader.getLimit());
        }
        return result;
    }

    protected abstract T readObject(FileReader fileReader);
}
