package org.sehkah.ddon.tools.extractor.lib.common.crypto;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.engines.BlowfishEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;

import java.nio.charset.StandardCharsets;

@Slf4j
public class BlowFishUtil {
    private static final byte[] key = "ABB(DF2I8[{Y-oS_CCMy(@<}qR}WYX11M)w[5V.~CbjwM5q<F1Iab+-".getBytes(StandardCharsets.UTF_8);
    private static final BufferedBlockCipher blowfishDecryption = new BufferedBlockCipher(new BlowfishEngine());

    static {
        blowfishDecryption.init(false, new KeyParameter(key));
    }

    /**
     * Simulate blowfish-compat by reversing 4-byte chunks, see https://github.com/otrtool/otrtool/commit/4282fbee1643ed2b37ae48c510619b2617a34bf1
     */
    public static byte[] reverse(byte[] in) {
        byte[] reversed = new byte[in.length];
        for (int i = 0; i < in.length; i++) {
            reversed[(i + 3) - ((i % 4) * 2)] = in[i];
        }
        return reversed;
    }

    public static byte[] decrypt(byte[] encrypted) {
        blowfishDecryption.reset();
        byte[] decrypted = new byte[encrypted.length];
        int outputLen = blowfishDecryption.processBytes(reverse(encrypted), 0, encrypted.length, decrypted, 0);
        try {
            blowfishDecryption.doFinal(decrypted, outputLen);
        } catch (CryptoException ce) {
            throw new TechnicalException("Blowfish failed to decrypt data.", ce);
        }
        return reverse(decrypted);
    }
}
