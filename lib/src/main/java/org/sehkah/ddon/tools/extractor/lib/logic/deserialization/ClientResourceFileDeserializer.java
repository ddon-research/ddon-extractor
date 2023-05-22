package org.sehkah.ddon.tools.extractor.lib.logic.deserialization;

import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.FileParsingIncompleteException;
import org.sehkah.ddon.tools.extractor.lib.common.error.MagicValidationFailedException;
import org.sehkah.ddon.tools.extractor.lib.common.error.VersionValidationFailedException;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;

public abstract class ClientResourceFileDeserializer implements ClientResourceDeserializer<TopLevelClientResource> {
    protected final ClientResourceFile clientResourceFile;

    protected ClientResourceFileDeserializer(ClientResourceFile clientResourceFile) {
        this.clientResourceFile = clientResourceFile;
    }

    @Override
    public TopLevelClientResource deserialize(FileReader fileReader) {
        if (clientResourceFile.getFileHeader().getMagicString() != null && !clientResourceFile.getFileHeader().isMagicValid(fileReader)) {
            throw new MagicValidationFailedException(clientResourceFile);
        }
        if (clientResourceFile.getFileHeader().getVersionNumber() >= 0 && !clientResourceFile.getFileHeader().isVersionValid(fileReader)) {
            throw new VersionValidationFailedException(clientResourceFile);
        }
        TopLevelClientResource result = parseClientResourceFile(fileReader);
        if (fileReader.hasRemaining()) {
            throw new FileParsingIncompleteException(fileReader.getRemainingCount(), fileReader.getLimit());
        }
        result.setFileSize(fileReader.getLimit());
        result.setMagicString(clientResourceFile.getFileHeader().getMagicString());
        result.setVersionNumber(clientResourceFile.getFileHeader().getVersionNumber());
        return result;
    }

    protected abstract TopLevelClientResource parseClientResourceFile(FileReader fileReader);
}
