package org.sehkah.ddon.tools.extractor.api.error;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;

import java.nio.file.Path;

public class FileParsingIncompleteException extends TechnicalException {
    public FileParsingIncompleteException() {
    }

    public FileParsingIncompleteException(int remainingBytesCount, int maxBytesCount) {
        super("File has data remaining! %s bytes are unread (%s / %s).".formatted(remainingBytesCount, maxBytesCount - remainingBytesCount, maxBytesCount));
    }

    public FileParsingIncompleteException(Path filePath, FileHeader fileHeader, int remainingBytesCount, int maxBytesCount) {
        super("File '%s' has data remaining! %s bytes are unread (%s / %s) while parsing file header '%s'.".formatted(filePath, remainingBytesCount, maxBytesCount - remainingBytesCount, maxBytesCount, fileHeader));
    }

    public FileParsingIncompleteException(String message) {
        super(message);
    }

    public FileParsingIncompleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileParsingIncompleteException(Throwable cause) {
        super(cause);
    }

    public FileParsingIncompleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
