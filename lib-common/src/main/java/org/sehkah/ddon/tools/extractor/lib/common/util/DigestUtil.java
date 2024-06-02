package org.sehkah.ddon.tools.extractor.lib.common.util;

import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class DigestUtil {
    private DigestUtil() {
    }

    public static String sha1Hex(byte[] bytes) {
        try {
            MessageDigest sha1 = MessageDigest.getInstance("sha1");
            HexFormat hexFormat = HexFormat.of();
            return hexFormat.formatHex(sha1.digest(bytes));
        } catch (NoSuchAlgorithmException e) {
            throw new TechnicalException(e);
        }
    }
}
