package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.launcher;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.launcher.ArchiveListArray;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.launcher.ArchiveListNode;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.launcher.ArchiveListTag;

import java.nio.file.Path;
import java.util.List;

public class ArchiveListArrayDeserializer extends ClientResourceFileDeserializer<ArchiveListArray> {
    private static ArchiveListNode readArchiveListNode(BufferReader bufferReader) {
        return new ArchiveListNode(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static ArchiveListTag readArchiveListTag(BufferReader bufferReader) {
        int ArchPathPointer = (int) bufferReader.readUnsignedInteger();
        int currentOffset = bufferReader.getPosition();
        bufferReader.setPosition(ArchPathPointer);
        String ArcPath = bufferReader.readNullTerminatedString();
        bufferReader.setPosition(currentOffset);

        long TagId = bufferReader.readUnsignedInteger();
        long Group = bufferReader.readUnsignedInteger();
        long Type = bufferReader.readUnsignedInteger();

        int NodeNum = (int) bufferReader.readUnsignedInteger();
        int NodeArrayPointer = (int) bufferReader.readUnsignedInteger();
        currentOffset = bufferReader.getPosition();
        bufferReader.setPosition(NodeArrayPointer);
        List<ArchiveListNode> NodeArray = bufferReader.readFixedLengthArray(NodeNum, ArchiveListArrayDeserializer::readArchiveListNode);
        bufferReader.setPosition(currentOffset);

        return new ArchiveListTag(
                ArchPathPointer,
                ArcPath,
                TagId,
                Group,
                Type,
                NodeNum,
                NodeArrayPointer,
                NodeArray
        );
    }

    @Override
    protected ArchiveListArray parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long MagicNo = bufferReader.readUnsignedInteger();
        long ConvHash = bufferReader.readUnsignedInteger();
        int TagNum = bufferReader.readUnsignedShort();
        int TargetTagNo = bufferReader.readUnsignedShort();
        ArchiveListArray archiveListArray = new ArchiveListArray(
                MagicNo,
                ConvHash,
                TagNum,
                TargetTagNo,
                bufferReader.readFixedLengthArray(TagNum, ArchiveListArrayDeserializer::readArchiveListTag)
        );
        // FIXME: hacky workaround due to jumping around
        bufferReader.setPosition(bufferReader.getLimit());
        return archiveListArray;
    }
}
