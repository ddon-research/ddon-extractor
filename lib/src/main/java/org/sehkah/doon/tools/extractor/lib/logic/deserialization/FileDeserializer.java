package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.common.error.FileParsingIncompleteException;
import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;

public abstract class FileDeserializer implements Deserializer {
    protected final ExtensionMap extension;
    protected final FileReader fileReader;

    protected FileDeserializer(ExtensionMap extension, FileReader fileReader) {
        this.extension = extension;
        this.fileReader = fileReader;
    }

    @Override
    public Object deserialize() {
        if (extension.fileHeader.magicString != null && !extension.fileHeader.isMagicValid(fileReader)) {
            return null;
        }
        if (extension.fileHeader.versionNumber >= 0 && !extension.fileHeader.isVersionValid(fileReader)) {
            return null;
        }
        Object result = readObject();
        if (fileReader.hasRemaining()) {
            throw new FileParsingIncompleteException(fileReader.getRemainingCount(), fileReader.getLimit());
        }
        return result;
    }

    protected abstract Object readObject();
}
