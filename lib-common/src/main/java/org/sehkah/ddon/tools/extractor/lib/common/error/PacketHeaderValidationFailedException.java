package org.sehkah.ddon.tools.extractor.lib.common.error;

public class PacketHeaderValidationFailedException extends TechnicalException {
    public PacketHeaderValidationFailedException() {
    }

    public PacketHeaderValidationFailedException(String message) {
        super(message);
    }

    public PacketHeaderValidationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PacketHeaderValidationFailedException(Throwable cause) {
        super(cause);
    }

    public PacketHeaderValidationFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
