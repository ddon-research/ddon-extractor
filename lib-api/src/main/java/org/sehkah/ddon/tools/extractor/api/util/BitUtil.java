package org.sehkah.ddon.tools.extractor.api.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.function.LongFunction;

public class BitUtil {
    private BitUtil() {

    }

    public static <T> Set<T> extractBitSetUnsignedIntegerFlag(LongFunction<T> longToEnumMapper, long bitSetValue) {
        return extractBitSetUnsignedIntegerFlag(longToEnumMapper, Collections.singletonList(bitSetValue));
    }

    public static <T> Set<T> extractBitSetUnsignedIntegerFlag(LongFunction<T> longToEnumMapper, IntUnaryOperator bitShiftFunction, long bitSetValue) {
        return extractBitSetUnsignedIntegerFlag(longToEnumMapper, bitShiftFunction, Collections.singletonList(bitSetValue), 32);
    }

    public static <T> Set<T> extractBitSetUnsignedIntegerFlag(LongFunction<T> longToEnumMapper, List<Long> bitSetList) {
        return extractBitSetUnsignedIntegerFlag(longToEnumMapper, bitSetList, 32);
    }


    public static <T> Set<T> extractBitSetUnsignedIntegerFlag(LongFunction<T> longToEnumMapper, List<Long> bitSetList, int bitSetBitsLength) {
        return extractBitSetUnsignedIntegerFlag(longToEnumMapper, IntUnaryOperator.identity(), bitSetList, bitSetBitsLength);
    }

    public static <T> Set<T> extractBitSetUnsignedIntegerFlag(LongFunction<T> longToEnumMapper, IntUnaryOperator bitShiftFunction, List<Long> bitSetList, int bitSetBitsLength) {
        if (bitSetList.stream().allMatch(l -> l == 0)) {
            return Set.of(longToEnumMapper.apply(0));
        }
        Set<T> types = LinkedHashSet.newLinkedHashSet(8);
        for (long l : bitSetList) {
            BitSet bitSet = BitSet.valueOf(new long[]{l});
            for (int i = 0; i < bitSetBitsLength; i++) {
                if (bitSet.get(i)) {
                    types.add(longToEnumMapper.apply(bitShiftFunction.applyAsInt(i)));
                }
            }
        }
        return types;
    }

    public static int extractInt(long source, int fromInclusive, int toInclusive) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES).order(ByteOrder.LITTLE_ENDIAN).putLong(source);
        BitSet bitSet = BitSet.valueOf(buffer.array()).get(fromInclusive, toInclusive + 1);
        int result = 0;
        for (int i = 0; i < bitSet.length(); ++i) {
            result += bitSet.get(i) ? (1 << i) : 0;
        }
        return result;
    }

    public static boolean extractBoolean(long source, int position) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES).order(ByteOrder.LITTLE_ENDIAN).putLong(source);
        return BitSet.valueOf(buffer.array()).get(position);
    }

    public static long extractLong(long source, int fromInclusive, int toInclusive) {
        return BitSet.valueOf(new long[]{source}).get(fromInclusive, toInclusive + 1).toLongArray()[0];
    }
}
