package org.sehkah.ddon.tools.extractor.lib.logic.deserialization;

import lombok.Getter;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.FileParsingIncompleteException;
import org.sehkah.ddon.tools.extractor.lib.common.error.MagicValidationFailedException;
import org.sehkah.ddon.tools.extractor.lib.common.error.VersionValidationFailedException;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;

public abstract class ClientResourceFileDeserializer implements ClientResourceDeserializer<TopLevelClientResource> {
    @Getter
    protected final ClientResourceFile clientResourceFile;

    protected ClientResourceFileDeserializer(ClientResourceFile clientResourceFile) {
        this.clientResourceFile = clientResourceFile;
    }

    @Override
    public TopLevelClientResource deserialize(FileReader fileReader) {
        FileHeader fileHeader = getClientResourceFile().getFileHeader();
        if (fileHeader.getMagicString() != null && !fileHeader.isMagicValid(fileReader)) {
            throw new MagicValidationFailedException(clientResourceFile);
        }
        if (fileHeader.getVersionNumber() >= 0 && !fileHeader.isVersionValid(fileReader)) {
            throw new VersionValidationFailedException(clientResourceFile);
        }
        TopLevelClientResource result = parseClientResourceFile(fileReader);
        if (fileReader.hasRemaining()) {
            throw new FileParsingIncompleteException(fileReader.getRemainingCount(), fileReader.getLimit());
        }
        result.setFileSize(fileReader.getLimit());
        result.setMagicString(fileHeader.getMagicString());
        result.setVersionNumber(fileHeader.getVersionNumber());
        return result;
    }

    protected abstract TopLevelClientResource parseClientResourceFile(FileReader fileReader);
}
