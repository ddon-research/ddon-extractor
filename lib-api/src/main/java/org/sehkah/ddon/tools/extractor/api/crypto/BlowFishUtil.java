package org.sehkah.ddon.tools.extractor.api.crypto;

import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DefaultBufferedBlockCipher;
import org.bouncycastle.crypto.engines.BlowfishEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;

import java.nio.charset.StandardCharsets;

public class BlowFishUtil {

    private static final byte[] key = "ABB(DF2I8[{Y-oS_CCMy(@<}qR}WYX11M)w[5V.~CbjwM5q<F1Iab+-".getBytes(StandardCharsets.UTF_8);

    private BlowFishUtil() {

    }

    /**
     * Simulate blowfish-compat by reversing 4-byte chunks, see https://github.com/otrtool/otrtool/commit/4282fbee1643ed2b37ae48c510619b2617a34bf1
     */
    public static byte[] reverse(byte[] in) {
        byte[] reversed = new byte[in.length];
        //noinspection ManualArrayCopy
        for (int i = 0; i < in.length; i++) {
            reversed[(i + 3) - ((i % 4) * 2)] = in[i];
        }
        return reversed;
    }

    public static byte[] decrypt(byte[] encrypted) {
        final DefaultBufferedBlockCipher blowfishDecryption = new DefaultBufferedBlockCipher(new BlowfishEngine());
        blowfishDecryption.init(false, new KeyParameter(key));
        byte[] decrypted = new byte[encrypted.length];
        int outputLen = blowfishDecryption.processBytes(reverse(encrypted), 0, encrypted.length, decrypted, 0);
        try {
            blowfishDecryption.doFinal(decrypted, outputLen);
        } catch (CryptoException ce) {
            throw new TechnicalException("Blowfish failed to decrypt data.", ce);
        }
        return reverse(decrypted);
    }

    public static byte[] decryptCompat(byte[] encrypted) {
        final BlowFishCompat blowfishDecryption = new BlowFishCompat(key);
        return blowfishDecryption.decryptECB(encrypted);
    }
}
