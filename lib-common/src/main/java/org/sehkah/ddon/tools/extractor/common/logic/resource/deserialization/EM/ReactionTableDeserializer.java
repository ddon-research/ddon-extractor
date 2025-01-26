package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.*;

import java.nio.file.Path;

public class ReactionTableDeserializer extends ClientResourceFileDeserializer<ReactionTable> {
    private static ReactionAction readReactionAction(BufferReader bufferReader) {
        return new ReactionAction(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static ReactionCondition readReactionCondition(BufferReader bufferReader) {
        return new ReactionCondition(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    private static ReactionTrigger readReactionTrigger(BufferReader bufferReader) {
        return new ReactionTrigger(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static Reaction readReaction(BufferReader bufferReader) {
        return new Reaction(
                readReactionTrigger(bufferReader),
                bufferReader.readFixedLengthArray(4, ReactionTableDeserializer::readReactionCondition),
                bufferReader.readBoolean(),
                bufferReader.readFixedLengthArray(4, ReactionTableDeserializer::readReactionAction),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected ReactionTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new ReactionTable(bufferReader.readArray(ReactionTableDeserializer::readReaction));
    }
}
