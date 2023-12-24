package org.sehkah.ddon.tools.extractor.lib.common.util;

import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.function.LongFunction;

public class BitUtil {
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
        Set<T> types = HashSet.newHashSet(8);
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
}
