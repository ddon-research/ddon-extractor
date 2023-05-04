package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.doon.tools.extractor.lib.common.error.MagicValidationFailedException;
import org.sehkah.doon.tools.extractor.lib.common.error.VersionValidationFailedException;
import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;

public abstract class FileDeserializer implements Deserializer {
    protected final Logger logger = LogManager.getLogger();
    protected final ExtractionType extractionTypeReference;
    protected final FileReader fileReader;

    protected FileDeserializer(ExtractionType extractionTypeReference, FileReader fileReader) {
        this.extractionTypeReference = extractionTypeReference;
        this.fileReader = fileReader;
    }

    protected boolean isVersionValid() {
        try {
            long version = fileReader.readUnsignedInteger();
            if (version != extractionTypeReference.version) {
                throw new VersionValidationFailedException(version, extractionTypeReference.version);
            }
            logger.info("version: '{}'", version);
            return true;
        } catch (VersionValidationFailedException e) {
            logger.error("Failed to validate version.");
            if (logger.isDebugEnabled()) {
                logger.error(e);
            }
        }
        return false;
    }

    protected boolean isMagicValid() {
        try {
            String magic = fileReader.readString(4);
            if (!magic.equals(extractionTypeReference.magic)) {
                throw new MagicValidationFailedException(magic, extractionTypeReference.magic);
            }
            logger.info("magic: '{}'", magic);
            return true;
        } catch (MagicValidationFailedException e) {
            logger.error("Failed to validate magic.");
            if (logger.isDebugEnabled()) {
                logger.error(e);
            }
        }
        return false;
    }
}
