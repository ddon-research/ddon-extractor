package org.sehkah.doon.tools.extractor.lib.common.error;

public class FileParsingIncompleteException extends TechnicalException {
    public FileParsingIncompleteException() {
    }

    public FileParsingIncompleteException(int remainingBytesCount, int maxBytesCount) {
        super("File has data remaining! %s bytes are unread.".formatted(maxBytesCount - remainingBytesCount));
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
