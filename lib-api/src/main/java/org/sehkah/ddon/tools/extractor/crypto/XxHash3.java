package org.sehkah.ddon.tools.extractor.crypto;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;

/**
 * High-performance Java implementation of the XXH3 hash algorithm.
 * <p>
 * Based on the .NET Foundation's XXH3 implementation from https://github.com/Cyan4973/xxHash.
 * Provides fast 64-bit hashing with excellent distribution properties.
 * <p>
 * This implementation is optimized for JDK 24 and uses modern Java features
 * for maximum performance while maintaining cross-platform compatibility.
 */
public final class XxHash3 {

    /**
     * XXH3 produces 8-byte (64-bit) hashes
     */
    public static final int HASH_LENGTH_BYTES = 8;

    // Prime constants used in the xxHash algorithm
    private static final long PRIME64_1 = 0x9E3779B185EBCA87L;
    private static final long PRIME64_2 = 0xC2B2AE3D27D4EB4FL;
    private static final long PRIME64_3 = 0x165667B19E3779F9L;
    private static final long PRIME64_4 = 0x85EBCA77C2B2AE63L;
    private static final long PRIME64_5 = 0x27D4EB2F165667C5L;

    private static final int PRIME32_1 = 0x9E3779B1;
    private static final int PRIME32_2 = 0x85EBCA77;
    private static final int PRIME32_3 = 0xC2B2AE3D;

    // Algorithm constants
    private static final int STRIPE_LENGTH_BYTES = 64;
    private static final int SECRET_LENGTH_BYTES = 192;
    private static final int SECRET_LAST_ACC_START_BYTES = 7;
    private static final int SECRET_CONSUME_RATE_BYTES = 8;
    private static final int SECRET_MERGE_ACCS_START_BYTES = 11;
    private static final int NUM_STRIPES_PER_BLOCK = (SECRET_LENGTH_BYTES - STRIPE_LENGTH_BYTES) / SECRET_CONSUME_RATE_BYTES;
    private static final int ACCUMULATOR_COUNT = STRIPE_LENGTH_BYTES / Long.BYTES;
    private static final int MID_SIZE_MAX_BYTES = 240;
    private static final int INTERNAL_BUFFER_LENGTH_BYTES = 256;

    /**
     * The default secret used when no seed is provided.
     * This is the same as a custom secret derived from a seed of 0.
     */
    private static final byte[] DEFAULT_SECRET = {
            (byte) 0xb8, (byte) 0xfe, (byte) 0x6c, (byte) 0x39, (byte) 0x23, (byte) 0xa4, (byte) 0x4b, (byte) 0xbe,
            (byte) 0x7c, (byte) 0x01, (byte) 0x81, (byte) 0x2c, (byte) 0xf7, (byte) 0x21, (byte) 0xad, (byte) 0x1c,
            (byte) 0xde, (byte) 0xd4, (byte) 0x6d, (byte) 0xe9, (byte) 0x83, (byte) 0x90, (byte) 0x97, (byte) 0xdb,
            (byte) 0x72, (byte) 0x40, (byte) 0xa4, (byte) 0xa4, (byte) 0xb7, (byte) 0xb3, (byte) 0x67, (byte) 0x1f,
            (byte) 0xcb, (byte) 0x79, (byte) 0xe6, (byte) 0x4e, (byte) 0xcc, (byte) 0xc0, (byte) 0xe5, (byte) 0x78,
            (byte) 0x82, (byte) 0x5a, (byte) 0xd0, (byte) 0x7d, (byte) 0xcc, (byte) 0xff, (byte) 0x72, (byte) 0x21,
            (byte) 0xb8, (byte) 0x08, (byte) 0x46, (byte) 0x74, (byte) 0xf7, (byte) 0x43, (byte) 0x24, (byte) 0x8e,
            (byte) 0xe0, (byte) 0x35, (byte) 0x90, (byte) 0xe6, (byte) 0x81, (byte) 0x3a, (byte) 0x26, (byte) 0x4c,
            (byte) 0x3c, (byte) 0x28, (byte) 0x52, (byte) 0xbb, (byte) 0x91, (byte) 0xc3, (byte) 0x00, (byte) 0xcb,
            (byte) 0x88, (byte) 0xd0, (byte) 0x65, (byte) 0x8b, (byte) 0x1b, (byte) 0x53, (byte) 0x2e, (byte) 0xa3,
            (byte) 0x71, (byte) 0x64, (byte) 0x48, (byte) 0x97, (byte) 0xa2, (byte) 0x0d, (byte) 0xf9, (byte) 0x4e,
            (byte) 0x38, (byte) 0x19, (byte) 0xef, (byte) 0x46, (byte) 0xa9, (byte) 0xde, (byte) 0xac, (byte) 0xd8,
            (byte) 0xa8, (byte) 0xfa, (byte) 0x76, (byte) 0x3f, (byte) 0xe3, (byte) 0x9c, (byte) 0x34, (byte) 0x3f,
            (byte) 0xf9, (byte) 0xdc, (byte) 0xbb, (byte) 0xc7, (byte) 0xc7, (byte) 0x0b, (byte) 0x4f, (byte) 0x1d,
            (byte) 0x8a, (byte) 0x51, (byte) 0xe0, (byte) 0x4b, (byte) 0xcd, (byte) 0xb4, (byte) 0x59, (byte) 0x31,
            (byte) 0xc8, (byte) 0x9f, (byte) 0x7e, (byte) 0xc9, (byte) 0xd9, (byte) 0x78, (byte) 0x73, (byte) 0x64,
            (byte) 0xea, (byte) 0xc5, (byte) 0xac, (byte) 0x83, (byte) 0x34, (byte) 0xd3, (byte) 0xeb, (byte) 0xc3,
            (byte) 0xc5, (byte) 0x81, (byte) 0xa0, (byte) 0xff, (byte) 0xfa, (byte) 0x13, (byte) 0x63, (byte) 0xeb,
            (byte) 0x17, (byte) 0x0d, (byte) 0xdd, (byte) 0x51, (byte) 0xb7, (byte) 0xf0, (byte) 0xda, (byte) 0x49,
            (byte) 0xd3, (byte) 0x16, (byte) 0x55, (byte) 0x26, (byte) 0x29, (byte) 0xd4, (byte) 0x68, (byte) 0x9e,
            (byte) 0x2b, (byte) 0x16, (byte) 0xbe, (byte) 0x58, (byte) 0x7d, (byte) 0x47, (byte) 0xa1, (byte) 0xfc,
            (byte) 0x8f, (byte) 0xf8, (byte) 0xb8, (byte) 0xd1, (byte) 0x7a, (byte) 0xd0, (byte) 0x31, (byte) 0xce,
            (byte) 0x45, (byte) 0xcb, (byte) 0x3a, (byte) 0x8f, (byte) 0x95, (byte) 0x16, (byte) 0x04, (byte) 0x28,
            (byte) 0xaf, (byte) 0xd7, (byte) 0xfb, (byte) 0xca, (byte) 0xbb, (byte) 0x4b, (byte) 0x40, (byte) 0x7e
    };

    // Precomputed values from the default secret for performance
    private static final long DEFAULT_SECRET_UINT64_0 = 0xBE4BA423396CFEB8L;
    private static final long DEFAULT_SECRET_UINT64_1 = 0x1CAD21F72C81017CL;
    private static final long DEFAULT_SECRET_UINT64_2 = 0xDB979083E96DD4DEL;
    private static final long DEFAULT_SECRET_UINT64_3 = 0x1F67B3B7A4A44072L;
    private static final long DEFAULT_SECRET_UINT64_4 = 0x78E5C0CC4EE679CBL;
    private static final long DEFAULT_SECRET_UINT64_5 = 0x2172FFCC7DD05A82L;
    private static final long DEFAULT_SECRET_UINT64_6 = 0x8E2443F7744608B8L;
    private static final long DEFAULT_SECRET_UINT64_7 = 0x4C263A81E69035E0L;
    private static final long DEFAULT_SECRET_UINT64_8 = 0xCB00C391BB52283CL;
    private static final long DEFAULT_SECRET_UINT64_9 = 0xA32E531B8B65D088L;
    private static final long DEFAULT_SECRET_UINT64_10 = 0x4EF90DA297486471L;
    private static final long DEFAULT_SECRET_UINT64_11 = 0xD8ACDEA946EF1938L;
    private static final long DEFAULT_SECRET_UINT64_12 = 0x3F349CE33F76FAA8L;
    private static final long DEFAULT_SECRET_UINT64_13 = 0x1D4F0BC7C7BBDCF9L;
    private static final long DEFAULT_SECRET_UINT64_14 = 0x3159B4CD4BE0518AL;
    private static final long DEFAULT_SECRET_UINT64_15 = 0x647378D9C97E9FC8L;

    // Secret3 precomputed values for lengths 129 to 240
    private static final long DEFAULT_SECRET3_UINT64_0 = 0x81017CBE4BA42339L;
    private static final long DEFAULT_SECRET3_UINT64_1 = 0x6DD4DE1CAD21F72CL;
    private static final long DEFAULT_SECRET3_UINT64_2 = 0xA44072DB979083E9L;
    private static final long DEFAULT_SECRET3_UINT64_3 = 0xE679CB1F67B3B7A4L;
    private static final long DEFAULT_SECRET3_UINT64_4 = 0xD05A8278E5C0CC4EL;
    private static final long DEFAULT_SECRET3_UINT64_5 = 0x4608B82172FFCC7DL;
    private static final long DEFAULT_SECRET3_UINT64_6 = 0x9035E08E2443F774L;
    private static final long DEFAULT_SECRET3_UINT64_7 = 0x52283C4C263A81E6L;
    private static final long DEFAULT_SECRET3_UINT64_8 = 0x65D088CB00C391BBL;
    private static final long DEFAULT_SECRET3_UINT64_9 = 0x486471A32E531B8BL;
    private static final long DEFAULT_SECRET3_UINT64_10 = 0xEF19384EF90DA297L;
    private static final long DEFAULT_SECRET3_UINT64_11 = 0x76FAA8D8ACDEA946L;
    private static final long DEFAULT_SECRET3_UINT64_12 = 0xBBDCF93F349CE33FL;
    private static final long DEFAULT_SECRET3_UINT64_13 = 0xE0518A1D4F0BC7C7L;

    // Tail constants used in 129..240 length path (match .NET reference literals)
    private static final long TAIL_SECRET_LOW = 0x7378D9C97E9FC831L;
    private static final long TAIL_SECRET_HIGH = 0xEBD33483ACC5EA64L;

    // State for incremental hashing
    private static final class State {
        long seed;
        final byte[] secret = new byte[SECRET_LENGTH_BYTES];
        final byte[] buffer = new byte[INTERNAL_BUFFER_LENGTH_BYTES];
        final long[] accumulators = new long[ACCUMULATOR_COUNT];
        int bufferedCount;
        long stripesProcessedInCurrentBlock;
        long totalLength;

        State(long seed) {
            this.seed = seed;
            initializeSecret(seed);
            reset();
        }

        private void initializeSecret(long seed) {
            if (seed == 0) {
                System.arraycopy(DEFAULT_SECRET, 0, secret, 0, SECRET_LENGTH_BYTES);
            } else {
                deriveSecretFromSeed(seed);
            }
        }

        private void deriveSecretFromSeed(long seed) {
            ByteBuffer defaultSecretBuffer = ByteBuffer.wrap(DEFAULT_SECRET).order(ByteOrder.LITTLE_ENDIAN);
            ByteBuffer secretBuffer = ByteBuffer.wrap(secret).order(ByteOrder.LITTLE_ENDIAN);

            for (int i = 0; i < SECRET_LENGTH_BYTES; i += 16) {
                long val1 = defaultSecretBuffer.getLong(i) + seed;
                long val2 = defaultSecretBuffer.getLong(i + 8) - seed;
                secretBuffer.putLong(i, val1);
                secretBuffer.putLong(i + 8, val2);
            }
        }

        private void reset() {
            bufferedCount = 0;
            stripesProcessedInCurrentBlock = 0;
            totalLength = 0;
            initializeAccumulators();
        }

        private void initializeAccumulators() {
            accumulators[0] = PRIME32_3;
            accumulators[1] = PRIME64_1;
            accumulators[2] = PRIME64_2;
            accumulators[3] = PRIME64_3;
            accumulators[4] = PRIME64_4;
            accumulators[5] = PRIME32_2;
            accumulators[6] = PRIME64_5;
            accumulators[7] = PRIME32_1;
        }
    }

    // Private constructor - this is a utility class
    private XxHash3() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Computes the XXH3 hash of the provided data using the default seed (0).
     *
     * @param data the data to hash
     * @return the XXH3 64-bit hash code
     * @throws NullPointerException if data is null
     */
    public static long hash(byte[] data) {
        return hash(data, 0L);
    }

    /**
     * Computes the XXH3 hash of the provided data using the specified seed.
     *
     * @param data the data to hash
     * @param seed the seed value for this hash computation
     * @return the XXH3 64-bit hash code
     * @throws NullPointerException if data is null
     */
    public static long hash(byte[] data, long seed) {
        Objects.requireNonNull(data, "data cannot be null");
        return hashToLong(data, 0, data.length, seed);
    }

    /**
     * Computes the XXH3 hash of the provided data segment using the specified seed.
     *
     * @param data   the data array
     * @param offset the starting offset in the data array
     * @param length the number of bytes to hash
     * @param seed   the seed value for this hash computation
     * @return the XXH3 64-bit hash code
     * @throws NullPointerException      if data is null
     * @throws IndexOutOfBoundsException if offset or length are invalid
     */
    public static long hash(byte[] data, int offset, int length, long seed) {
        Objects.requireNonNull(data, "data cannot be null");
        if (offset < 0 || length < 0 || offset + length > data.length) {
            throw new IndexOutOfBoundsException("Invalid offset or length");
        }
        return hashToLong(data, offset, length, seed);
    }

    /**
     * Computes the XXH3 hash as a byte array in big-endian format.
     *
     * @param data the data to hash
     * @return the XXH3 hash as an 8-byte array
     * @throws NullPointerException if data is null
     */
    public static byte[] hashBytes(byte[] data) {
        return hashBytes(data, 0L);
    }

    /**
     * Computes the XXH3 hash as a byte array in big-endian format.
     *
     * @param data the data to hash
     * @param seed the seed value for this hash computation
     * @return the XXH3 hash as an 8-byte array
     * @throws NullPointerException if data is null
     */
    public static byte[] hashBytes(byte[] data, long seed) {
        long hash = hash(data, seed);
        return longToBigEndianBytes(hash);
    }

    /**
     * Core hashing implementation.
     */
    private static long hashToLong(byte[] data, int offset, int length, long seed) {
        if (length <= 16) {
            return hashLength0To16(data, offset, length, seed);
        }

        if (length <= 128) {
            return hashLength17To128(data, offset, length, seed);
        }

        if (length <= MID_SIZE_MAX_BYTES) {
            return hashLength129To240(data, offset, length, seed);
        }

        return hashLengthOver240(data, offset, length, seed);
    }

    /**
     * Hash data of length 0 to 16 bytes.
     */
    private static long hashLength0To16(byte[] data, int offset, int length, long seed) {
        if (length > 8) {
            return hashLength9To16(data, offset, length, seed);
        }

        if (length >= 4) {
            return hashLength4To8(data, offset, length, seed);
        }

        if (length > 0) {
            return hashLength1To3(data, offset, length, seed);
        }

        // Empty input: SecretXor = DefaultSecretUInt64_7 ^ DefaultSecretUInt64_8
        long secretXor = DEFAULT_SECRET_UINT64_7 ^ DEFAULT_SECRET_UINT64_8;
        return avalanche(seed ^ secretXor);
    }

    /**
     * Hash data of length 1 to 3 bytes.
     */
    private static long hashLength1To3(byte[] data, int offset, int length, long seed) {
        int c1 = Byte.toUnsignedInt(data[offset]);
        int c2 = Byte.toUnsignedInt(data[offset + (length >>> 1)]);
        int c3 = Byte.toUnsignedInt(data[offset + length - 1]);

        int combined = (c1 << 16) | (c2 << 24) | c3 | (length << 8);
        // SecretXor = lower32(DefaultSecretUInt64_0) ^ upper32(DefaultSecretUInt64_0)
        long secretXor = ((DEFAULT_SECRET_UINT64_0 & 0xFFFFFFFFL) ^ (DEFAULT_SECRET_UINT64_0 >>> 32)) & 0xFFFFFFFFL;
        // Use simple avalanche per reference rather than rrmxmx here
        return avalanche(Integer.toUnsignedLong(combined) ^ (secretXor + seed));
    }

    /**
     * Hash data of length 4 to 8 bytes.
     */
    private static long hashLength4To8(byte[] data, int offset, int length, long seed) {
        seed ^= Long.reverseBytes(seed) >>> 32;

        int input1 = readInt32LE(data, offset);
        int input2 = readInt32LE(data, offset + length - 4);

        long bitflip = (DEFAULT_SECRET_UINT64_1 ^ DEFAULT_SECRET_UINT64_2) - seed;
        long input64 = Integer.toUnsignedLong(input2) + (Integer.toUnsignedLong(input1) << 32);
        return rrmxmx(input64 ^ bitflip, length);
    }

    /**
     * Hash data of length 9 to 16 bytes.
     */
    private static long hashLength9To16(byte[] data, int offset, int length, long seed) {
        // bitflipLow = (DefaultSecretUInt64_3 ^ DefaultSecretUInt64_4) + seed
        // bitflipHigh = (DefaultSecretUInt64_5 ^ DefaultSecretUInt64_6) - seed
        long bitflipLow = (DEFAULT_SECRET_UINT64_3 ^ DEFAULT_SECRET_UINT64_4) + seed;
        long bitflipHigh = (DEFAULT_SECRET_UINT64_5 ^ DEFAULT_SECRET_UINT64_6) - seed;

        long inputLow = readLong64LE(data, offset) ^ bitflipLow;
        long inputHigh = readLong64LE(data, offset + length - 8) ^ bitflipHigh;

        return avalanche(length + Long.reverseBytes(inputLow) + inputHigh +
                multiply64To128ThenFold(inputLow, inputHigh));
    }

    /**
     * Hash data of length 17 to 128 bytes.
     */
    private static long hashLength17To128(byte[] data, int offset, int length, long seed) {
        long acc = Integer.toUnsignedLong(length) * PRIME64_1;
        int limitCase = (length - 1) / 32; // 0..3
        switch (limitCase) {
            default: // case 3
                acc += mix16Bytes(data, offset + 48, DEFAULT_SECRET_UINT64_12, DEFAULT_SECRET_UINT64_13, seed);
                acc += mix16Bytes(data, offset + length - 64, DEFAULT_SECRET_UINT64_14, DEFAULT_SECRET_UINT64_15, seed);
            case 2:
                acc += mix16Bytes(data, offset + 32, DEFAULT_SECRET_UINT64_8, DEFAULT_SECRET_UINT64_9, seed);
                acc += mix16Bytes(data, offset + length - 48, DEFAULT_SECRET_UINT64_10, DEFAULT_SECRET_UINT64_11, seed);
            case 1:
                acc += mix16Bytes(data, offset + 16, DEFAULT_SECRET_UINT64_4, DEFAULT_SECRET_UINT64_5, seed);
                acc += mix16Bytes(data, offset + length - 32, DEFAULT_SECRET_UINT64_6, DEFAULT_SECRET_UINT64_7, seed);
            case 0:
                acc += mix16Bytes(data, offset, DEFAULT_SECRET_UINT64_0, DEFAULT_SECRET_UINT64_1, seed);
                acc += mix16Bytes(data, offset + length - 16, DEFAULT_SECRET_UINT64_2, DEFAULT_SECRET_UINT64_3, seed);
        }
        return avalanche(acc);
    }

    /**
     * Hash data of length 129 to 240 bytes.
     */
    private static long hashLength129To240(byte[] data, int offset, int length, long seed) {
        long acc = Integer.toUnsignedLong(length) * PRIME64_1;

        // First 8 * 16 bytes
        acc += mix16Bytes(data, offset + 16 * 0, DEFAULT_SECRET_UINT64_0, DEFAULT_SECRET_UINT64_1, seed);
        acc += mix16Bytes(data, offset + 16 * 1, DEFAULT_SECRET_UINT64_2, DEFAULT_SECRET_UINT64_3, seed);
        acc += mix16Bytes(data, offset + 16 * 2, DEFAULT_SECRET_UINT64_4, DEFAULT_SECRET_UINT64_5, seed);
        acc += mix16Bytes(data, offset + 16 * 3, DEFAULT_SECRET_UINT64_6, DEFAULT_SECRET_UINT64_7, seed);
        acc += mix16Bytes(data, offset + 16 * 4, DEFAULT_SECRET_UINT64_8, DEFAULT_SECRET_UINT64_9, seed);
        acc += mix16Bytes(data, offset + 16 * 5, DEFAULT_SECRET_UINT64_10, DEFAULT_SECRET_UINT64_11, seed);
        acc += mix16Bytes(data, offset + 16 * 6, DEFAULT_SECRET_UINT64_12, DEFAULT_SECRET_UINT64_13, seed);
        acc += mix16Bytes(data, offset + 16 * 7, DEFAULT_SECRET_UINT64_14, DEFAULT_SECRET_UINT64_15, seed);

        acc = avalanche(acc);

        int remainingBlocks = (length - (16 * 8)) / 16; // 0..7 (240 -> 7)
        switch (remainingBlocks) {
            default: // case 7
                acc += mix16Bytes(data, offset + 16 * 14, DEFAULT_SECRET3_UINT64_12, DEFAULT_SECRET3_UINT64_13, seed);
            case 6:
                acc += mix16Bytes(data, offset + 16 * 13, DEFAULT_SECRET3_UINT64_10, DEFAULT_SECRET3_UINT64_11, seed);
            case 5:
                acc += mix16Bytes(data, offset + 16 * 12, DEFAULT_SECRET3_UINT64_8, DEFAULT_SECRET3_UINT64_9, seed);
            case 4:
                acc += mix16Bytes(data, offset + 16 * 11, DEFAULT_SECRET3_UINT64_6, DEFAULT_SECRET3_UINT64_7, seed);
            case 3:
                acc += mix16Bytes(data, offset + 16 * 10, DEFAULT_SECRET3_UINT64_4, DEFAULT_SECRET3_UINT64_5, seed);
            case 2:
                acc += mix16Bytes(data, offset + 16 * 9, DEFAULT_SECRET3_UINT64_2, DEFAULT_SECRET3_UINT64_3, seed);
            case 1:
                acc += mix16Bytes(data, offset + 16 * 8, DEFAULT_SECRET3_UINT64_0, DEFAULT_SECRET3_UINT64_1, seed);
            case 0:
                acc += mix16Bytes(data, offset + length - 16, TAIL_SECRET_LOW, TAIL_SECRET_HIGH, seed);
        }
        return avalanche(acc);
    }

    /**
     * Hash data longer than 240 bytes using the full stripe-based algorithm.
     */
    private static long hashLengthOver240(byte[] data, int offset, int length, long seed) {
        byte[] secret = new byte[SECRET_LENGTH_BYTES];
        if (seed == 0) {
            System.arraycopy(DEFAULT_SECRET, 0, secret, 0, SECRET_LENGTH_BYTES);
        } else {
            deriveSecretFromSeed(secret, seed);
        }

        long[] accumulators = new long[ACCUMULATOR_COUNT];
        initializeAccumulators(accumulators);

        hashInternalLoop(accumulators, data, offset, length, secret);

        return mergeAccumulators(accumulators, secret,
                SECRET_MERGE_ACCS_START_BYTES,
                Integer.toUnsignedLong(length) * PRIME64_1);
    }

    /**
     * Main processing loop for large inputs.
     */
    private static void hashInternalLoop(long[] accumulators, byte[] data, int offset, int length, byte[] secret) {
        final int stripesPerBlock = NUM_STRIPES_PER_BLOCK;
        final int blockLen = STRIPE_LENGTH_BYTES * stripesPerBlock;
        int blocksNum = (length - 1) / blockLen;

        // Process complete blocks
        for (int block = 0; block < blocksNum; block++) {
            int blockOffset = offset + block * blockLen;
            accumulate(accumulators, data, blockOffset, secret, 0, stripesPerBlock);
            scrambleAccumulators(accumulators, secret, SECRET_LENGTH_BYTES - STRIPE_LENGTH_BYTES);
        }

        // Process remaining stripes
        int remainingOffset = offset + blocksNum * blockLen;
        int remainingLength = length - blocksNum * blockLen;
        int stripesNumber = (remainingLength - 1) / STRIPE_LENGTH_BYTES;

        if (stripesNumber > 0) {
            accumulate(accumulators, data, remainingOffset, secret, 0, stripesNumber);
        }

        // Process last stripe
        accumulate512(accumulators, data, offset + length - STRIPE_LENGTH_BYTES,
                secret, SECRET_LENGTH_BYTES - STRIPE_LENGTH_BYTES - SECRET_LAST_ACC_START_BYTES);
    }

    /**
     * Accumulate stripes into accumulators.
     */
    private static void accumulate(long[] accumulators, byte[] data, int dataOffset,
                                   byte[] secret, int secretOffset, int stripesToProcess) {
        for (int stripe = 0; stripe < stripesToProcess; stripe++) {
            accumulate512(accumulators, data, dataOffset + stripe * STRIPE_LENGTH_BYTES,
                    secret, secretOffset + stripe * SECRET_CONSUME_RATE_BYTES);
        }
    }

    /**
     * Process a single 512-bit (64-byte) stripe.
     */
    private static void accumulate512(long[] accumulators, byte[] data, int dataOffset,
                                      byte[] secret, int secretOffset) {
        // Reference behavior: for each lane i
        // sourceVal = read64(data)
        // sourceKey = sourceVal ^ read64(secret)
        // accumulators[i ^ 1] += sourceVal;
        // accumulators[i] += Multiply32To64(low32(sourceKey), high32(sourceKey));
        for (int i = 0; i < ACCUMULATOR_COUNT; i++) {
            long sourceVal = readLong64LE(data, dataOffset + i * 8);
            long sourceKey = sourceVal ^ readLong64LE(secret, secretOffset + i * 8);
            // swap adjacent lanes when adding sourceVal
            accumulators[i ^ 1] += sourceVal;
            long product = (sourceKey & 0xFFFFFFFFL) * ((sourceKey >>> 32) & 0xFFFFFFFFL);
            accumulators[i] += product;
        }
    }

    /**
     * Scramble accumulators after processing a block.
     */
    private static void scrambleAccumulators(long[] accumulators, byte[] secret, int secretOffset) {
        for (int i = 0; i < ACCUMULATOR_COUNT; i++) {
            long keyVal = readLong64LE(secret, secretOffset + i * 8);
            accumulators[i] = (accumulators[i] ^ (accumulators[i] >>> 47)) ^ keyVal;
            accumulators[i] *= PRIME32_1;
        }
    }

    /**
     * Initialize accumulators with prime values.
     */
    private static void initializeAccumulators(long[] accumulators) {
        accumulators[0] = PRIME32_3;
        accumulators[1] = PRIME64_1;
        accumulators[2] = PRIME64_2;
        accumulators[3] = PRIME64_3;
        accumulators[4] = PRIME64_4;
        accumulators[5] = PRIME32_2;
        accumulators[6] = PRIME64_5;
        accumulators[7] = PRIME32_1;
    }

    /**
     * Merge accumulators into final hash value.
     */
    private static long mergeAccumulators(long[] accumulators, byte[] secret,
                                          int secretOffset, long start) {
        long result = start;

        for (int i = 0; i < ACCUMULATOR_COUNT; i += 2) {
            long secretLow = readLong64LE(secret, secretOffset + i * 8);
            long secretHigh = readLong64LE(secret, secretOffset + (i + 1) * 8);

            result += multiply64To128ThenFold(
                    accumulators[i] ^ secretLow,
                    accumulators[i + 1] ^ secretHigh
            );
        }

        return avalanche(result);
    }

    /**
     * Mix 16 bytes of data with secret values.
     */
    private static long mix16Bytes(byte[] data, int offset, long secretLow, long secretHigh, long seed) {
        long input_lo = readLong64LE(data, offset);
        long input_hi = readLong64LE(data, offset + 8);
        return multiply64To128ThenFold(
                input_lo ^ (secretLow + seed),
                input_hi ^ (secretHigh - seed)
        );
    }

    /**
     * Derive secret from seed for seeded hashing.
     */
    private static void deriveSecretFromSeed(byte[] destinationSecret, long seed) {
        ByteBuffer defaultBuffer = ByteBuffer.wrap(DEFAULT_SECRET).order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer destBuffer = ByteBuffer.wrap(destinationSecret).order(ByteOrder.LITTLE_ENDIAN);

        for (int i = 0; i < SECRET_LENGTH_BYTES; i += 16) {
            long val1 = defaultBuffer.getLong(i) + seed;
            long val2 = defaultBuffer.getLong(i + 8) - seed;
            destBuffer.putLong(i, val1);
            destBuffer.putLong(i + 8, val2);
        }
    }

    /**
     * Calculate 64-bit to 128-bit multiply, then XOR fold the result.
     */
    private static long multiply64To128ThenFold(long left, long right) {
        long high = Math.multiplyHigh(left, right); // JDK 18+ available (we target 24)
        long low = left * right;
        return low ^ high;
    }

    /**
     * Fast avalanche function for final mixing.
     */
    private static long avalanche(long hash) {
        hash = xorShift(hash, 37);
        hash *= 0x165667919E3779F9L;
        hash = xorShift(hash, 32);
        return hash;
    }

    /**
     * Stronger avalanche function with rotation and multiplication.
     */
    private static long rrmxmx(long hash, int length) {
        hash ^= Long.rotateLeft(hash, 49) ^ Long.rotateLeft(hash, 24);
        hash *= 0x9FB21C651E98DF25L;
        hash ^= (hash >>> 35) + length;
        hash *= 0x9FB21C651E98DF25L;
        return xorShift(hash, 28);
    }

    /**
     * XOR-shift operation.
     */
    private static long xorShift(long value, int shift) {
        return value ^ (value >>> shift);
    }

    /**
     * Read a 32-bit little-endian integer from byte array.
     */
    private static int readInt32LE(byte[] data, int offset) {
        return (data[offset] & 0xFF) |
                ((data[offset + 1] & 0xFF) << 8) |
                ((data[offset + 2] & 0xFF) << 16) |
                ((data[offset + 3] & 0xFF) << 24);
    }

    /**
     * Read a 64-bit little-endian long from byte array.
     */
    private static long readLong64LE(byte[] data, int offset) {
        return (data[offset] & 0xFFL) |
                ((data[offset + 1] & 0xFFL) << 8) |
                ((data[offset + 2] & 0xFFL) << 16) |
                ((data[offset + 3] & 0xFFL) << 24) |
                ((data[offset + 4] & 0xFFL) << 32) |
                ((data[offset + 5] & 0xFFL) << 40) |
                ((data[offset + 6] & 0xFFL) << 48) |
                ((data[offset + 7] & 0xFFL) << 56);
    }

    /**
     * Convert long to big-endian byte array.
     */
    private static byte[] longToBigEndianBytes(long value) {
        return new byte[]{
                (byte) (value >>> 56),
                (byte) (value >>> 48),
                (byte) (value >>> 40),
                (byte) (value >>> 32),
                (byte) (value >>> 24),
                (byte) (value >>> 16),
                (byte) (value >>> 8),
                (byte) (value)
        };
    }

    /**
     * Creates a new hasher instance for incremental hashing.
     *
     * @return a new XxHash3Hasher instance
     */
    public static XxHash3Hasher newHasher() {
        return new XxHash3Hasher(0L);
    }

    /**
     * Creates a new hasher instance for incremental hashing with a seed.
     *
     * @param seed the seed value
     * @return a new XxHash3Hasher instance
     */
    public static XxHash3Hasher newHasher(long seed) {
        return new XxHash3Hasher(seed);
    }

    /**
     * Hasher class for incremental hashing operations.
     */
    public static final class XxHash3Hasher {
        private final State state;

        private XxHash3Hasher(long seed) {
            this.state = new State(seed);
        }

        /**
         * Updates the hash with the provided data.
         *
         * @param data the data to add to the hash
         * @return this hasher instance for method chaining
         * @throws NullPointerException if data is null
         */
        public XxHash3Hasher update(byte[] data) {
            Objects.requireNonNull(data, "data cannot be null");
            return update(data, 0, data.length);
        }

        /**
         * Updates the hash with the provided data segment.
         *
         * @param data   the data array
         * @param offset the starting offset
         * @param length the number of bytes to process
         * @return this hasher instance for method chaining
         * @throws NullPointerException      if data is null
         * @throws IndexOutOfBoundsException if offset or length are invalid
         */
        public XxHash3Hasher update(byte[] data, int offset, int length) {
            Objects.requireNonNull(data, "data cannot be null");
            if (offset < 0 || length < 0 || offset + length > data.length) {
                throw new IndexOutOfBoundsException("Invalid offset or length");
            }

            // For incremental hashing, we implement a simplified buffering approach
            // For production use, a full streaming implementation would be more complex
            byte[] newData = new byte[state.buffer.length + length];
            System.arraycopy(state.buffer, 0, newData, 0, (int) state.totalLength);
            System.arraycopy(data, offset, newData, (int) state.totalLength, length);

            System.arraycopy(newData, 0, state.buffer, 0,
                    Math.min(newData.length, state.buffer.length));
            state.totalLength += length;

            return this;
        }

        /**
         * Finalize the hash computation and return the result.
         *
         * @return the computed hash value
         */
        public long digest() {
            if (state.totalLength > state.buffer.length) {
                // For very large incremental data, we'd need a more sophisticated approach
                throw new UnsupportedOperationException(
                        "Incremental hashing of data larger than buffer size not fully implemented");
            }

            return hashToLong(state.buffer, 0, (int) state.totalLength, state.seed);
        }

        /**
         * Finalize the hash computation and return the result as a byte array.
         *
         * @return the computed hash as an 8-byte array in big-endian format
         */
        public byte[] digestBytes() {
            return longToBigEndianBytes(digest());
        }

        /**
         * Reset the hasher to its initial state.
         *
         * @return this hasher instance for method chaining
         */
        public XxHash3Hasher reset() {
            state.reset();
            return this;
        }
    }
}
