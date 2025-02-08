package org.sehkah.ddon.tools.extractor.lib.test.api.io;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.api.datatype.Color;
import org.sehkah.ddon.tools.extractor.api.io.BinaryReader;

import java.math.BigInteger;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class BinaryReaderTest {

    @Test
    void testReadUnsignedByte() {
        byte[] testData = {1};
        BinaryReader binaryReader = new BinaryReader(testData, ByteOrder.BIG_ENDIAN);


        int result = binaryReader.readUnsignedByte();


        assertEquals(1, result);
    }

    @Test
    void testReadSignedByte() {
        byte[] testData = {127, -128};
        BinaryReader binaryReader = new BinaryReader(testData, ByteOrder.BIG_ENDIAN);


        int firstResult = binaryReader.readSignedByte();
        int secondResult = binaryReader.readSignedByte();


        assertEquals(127, firstResult);
        assertEquals(-128, secondResult);
    }

    @Test
    void testReadUnsignedShort() {
        byte[] testData = {0, 1};
        BinaryReader binaryReader = new BinaryReader(testData, ByteOrder.BIG_ENDIAN);


        int result = binaryReader.readUnsignedShort();


        assertEquals(1, result);
    }

    @Test
    void testReadSignedInteger() {
        byte[] testData = {0, 0, 0, 1};
        BinaryReader binaryReader = new BinaryReader(testData, ByteOrder.BIG_ENDIAN);


        int result = binaryReader.readSignedInteger();


        assertEquals(1, result);
    }

    @Test
    void testReadFloat() {
        byte[] testData = {64, 73, 15, -62}; // 3.14f in IEEE 754
        BinaryReader binaryReader = new BinaryReader(testData, ByteOrder.BIG_ENDIAN);


        float result = binaryReader.readFloat();


        assertEquals(3.14f, result, 0.01);
    }

    @Test
    void testReadUnsignedLong() {
        byte[] testData = {0, 0, 0, 0, 0, 0, 0, 1};
        BinaryReader binaryReader = new BinaryReader(testData, ByteOrder.BIG_ENDIAN);


        BigInteger result = binaryReader.readUnsignedLong();


        assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testReadNullTerminatedString() {
        byte[] testData = {'H', 'e', 'l', 'l', 'o', 0};
        BinaryReader binaryReader = new BinaryReader(testData, ByteOrder.BIG_ENDIAN);


        String result = binaryReader.readNullTerminatedString(StandardCharsets.US_ASCII);


        assertEquals("Hello", result);
    }

    @Test
    void testReadBoolean() {
        byte[] testData = {1, 0};
        BinaryReader binaryReader = new BinaryReader(testData, ByteOrder.BIG_ENDIAN);


        boolean firstResult = binaryReader.readBoolean();
        boolean secondResult = binaryReader.readBoolean();


        assertTrue(firstResult);
        assertFalse(secondResult);
    }

    @Test
    void testReadColor() {
        byte[] testData = {(byte) 255, 0, 0, 0};
        BinaryReader binaryReader = new BinaryReader(testData, ByteOrder.BIG_ENDIAN);


        Color color = binaryReader.readColor();


        assertEquals(255, color.a());
        assertEquals(0, color.b());
        assertEquals(0, color.g());
        assertEquals(0, color.r());
    }
}
