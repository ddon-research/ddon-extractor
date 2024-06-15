package org.sehkah.ddon.tools.extractor.api.error;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;

public class MagicValidationFailedException extends TechnicalException {
    public MagicValidationFailedException() {
    }

    public MagicValidationFailedException(String encounteredMagic, String expectedMagic) {
        super("Encountered magic value '%s' does not equal expected '%s'.".formatted(encounteredMagic, expectedMagic));
    }

    public MagicValidationFailedException(ClientResourceFile clientResourceFile) {
        super("Magic validation failed for client resource '%s'.".formatted(clientResourceFile));
    }

    public MagicValidationFailedException(FileHeader fileHeader) {
        super("Magic validation failed for file header '%s'.".formatted(fileHeader));
    }

    public MagicValidationFailedException(String message) {
        super(message);
    }

    public MagicValidationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MagicValidationFailedException(Throwable cause) {
        super(cause);
    }

    public MagicValidationFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
