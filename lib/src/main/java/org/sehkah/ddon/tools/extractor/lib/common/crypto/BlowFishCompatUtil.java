package org.sehkah.ddon.tools.extractor.lib.common.crypto;

import java.nio.charset.StandardCharsets;

public class BlowFishCompatUtil {

    private static final byte[] key = "ABB(DF2I8[{Y-oS_CCMy(@<}qR}WYX11M)w[5V.~CbjwM5q<F1Iab+-".getBytes(StandardCharsets.UTF_8);

    private BlowFishCompatUtil() {

    }

    public static byte[] decrypt(byte[] encrypted) {
        final BlowFishCompat blowfishDecryption = new BlowFishCompat(key);
        return blowfishDecryption.decryptECB(encrypted);
    }

}
