package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.binary.XfsDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage.StartPos;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage.StartPosInfo;

import java.util.ArrayList;
import java.util.List;

public class StartPosDeserializer extends ClientResourceFileDeserializer {
    public StartPosDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StartPosInfo readStartPosInfo(BufferReader bufferReader) {
        int index1 = bufferReader.readUnsignedShort();
        int propertyIndex = bufferReader.readUnsignedShort();
        long bufferSize = bufferReader.readUnsignedInteger();

        long propertyCount1 = bufferReader.readUnsignedInteger();
        Vector3f Pos = bufferReader.readVector3f();
        float pad = bufferReader.readFloat();

        long propertyCount2 = bufferReader.readUnsignedInteger();
        float Ang = bufferReader.readFloat();

        long OfsPosNum = bufferReader.readUnsignedInteger();
        List<Vector3f> OfsPos = new ArrayList<>((int) OfsPosNum);
        for (int i = 0; i < OfsPosNum; i++) {
            OfsPos.add(bufferReader.readVector3f());
            pad = bufferReader.readFloat();
        }

        List<Float> OfsAng = bufferReader.readArray(BufferReader::readFloat);

        return new StartPosInfo(
                Pos,
                Ang,
                OfsPos,
                OfsAng
        );
    }

    @Override
    protected StartPos parseClientResourceFile(BufferReader bufferReader) {
        // Account for hacky workaround to make a unique resourceVersion by reading in both the deserializer and class resourceVersion initially
        bufferReader.setPosition(bufferReader.getPosition() - 2);

        XfsDeserializer.readHeader(bufferReader);
        XfsDeserializer.readResource(bufferReader);

        return new StartPos(
                XfsDeserializer.readMtArray(bufferReader, StartPosDeserializer::readStartPosInfo)
        );
    }
}
