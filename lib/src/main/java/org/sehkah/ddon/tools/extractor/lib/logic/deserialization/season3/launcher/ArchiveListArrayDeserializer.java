package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.launcher;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.launcher.ArchiveListArray;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.launcher.ArchiveListNode;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.launcher.ArchiveListTag;

import java.util.List;

public class ArchiveListArrayDeserializer extends ClientResourceFileDeserializer {
    public ArchiveListArrayDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ArchiveListNode readArchiveListNode(FileReader fileReader) {
        return new ArchiveListNode(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    private static ArchiveListTag readArchiveListTag(FileReader fileReader) {
        int ArchPathPointer = (int) fileReader.readUnsignedInteger();
        int currentOffset = fileReader.getPosition();
        fileReader.setPosition(ArchPathPointer);
        String ArcPath = fileReader.readNullTerminatedString();
        fileReader.setPosition(currentOffset);

        long TagId = fileReader.readUnsignedInteger();
        long Group = fileReader.readUnsignedInteger();
        long Type = fileReader.readUnsignedInteger();

        int NodeNum = (int) fileReader.readUnsignedInteger();
        int NodeArrayPointer = (int) fileReader.readUnsignedInteger();
        currentOffset = fileReader.getPosition();
        fileReader.setPosition(NodeArrayPointer);
        List<ArchiveListNode> NodeArray = fileReader.readFixedLengthArray(NodeNum, ArchiveListArrayDeserializer::readArchiveListNode);
        fileReader.setPosition(currentOffset);

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
    protected ArchiveListArray parseClientResourceFile(FileReader fileReader) {
        long MagicNo = fileReader.readUnsignedInteger();
        long ConvHash = fileReader.readUnsignedInteger();
        int TagNum = fileReader.readUnsignedShort();
        int TargetTagNo = fileReader.readUnsignedShort();
        ArchiveListArray archiveListArray = new ArchiveListArray(
                MagicNo,
                ConvHash,
                TagNum,
                TargetTagNo,
                fileReader.readFixedLengthArray(TagNum, ArchiveListArrayDeserializer::readArchiveListTag)
        );
        // FIXME: hacky workaround due to jumping around
        fileReader.setPosition(fileReader.getLimit());
        return archiveListArray;
    }
}
