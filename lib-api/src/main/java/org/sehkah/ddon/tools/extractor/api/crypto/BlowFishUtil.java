package org.sehkah.ddon.tools.extractor.api.crypto;

import java.nio.charset.StandardCharsets;

public final class BlowFishUtil {
    private static final byte[] key = "ABB(DF2I8[{Y-oS_CCMy(@<}qR}WYX11M)w[5V.~CbjwM5q<F1Iab+-".getBytes(StandardCharsets.UTF_8);
    private static final BlowFishCompat BLOWFISH_ENGINE = new BlowFishCompat(key);

    private BlowFishUtil() {

    }

    public static byte[] decrypt(byte[] encrypted) {
        return BLOWFISH_ENGINE.decryptECB(encrypted);
    }
}
