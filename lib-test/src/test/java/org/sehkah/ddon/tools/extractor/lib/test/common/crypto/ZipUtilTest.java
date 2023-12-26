package org.sehkah.ddon.tools.extractor.lib.test.common.crypto;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.lib.common.crypto.BlowFishUtil;
import org.sehkah.ddon.tools.extractor.lib.common.crypto.ZipUtil;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileReader;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;

import java.util.HexFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZipUtilTest {

    @Test
    void testDecryptResourceInfoPath() {
        String sg30000ResourceInfo1 = "573DB39C9E7379D81EDCA9B6601334566E4F776DDA8B0B36B3E1B9A795742F1FED2C0FE3F2D373B3CCC64036EB33A69E61FDBB9EAF5728BEB02B6B1C1F68FCE2919B7941D98216B8C5018928A872CC179CE2F40E79A529D69FDB023045E4EAC2F4F1F9BB9895073C1F0AE3EA3219A566";

        byte[] decompressedDecrypted = ZipUtil.decompress(BlowFishUtil.decrypt(HexFormat.of().parseHex(sg30000ResourceInfo1)), 747);
        FileReader temporaryReader = new BinaryFileReader(decompressedDecrypted);

        assertEquals("TBL\0", temporaryReader.readString(4));
    }
}
