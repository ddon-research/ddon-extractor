package org.sehkah.ddon.tools.extractor.lib.test.api.crypto;

import org.junit.jupiter.api.Test;
import org.sehkah.ddon.tools.extractor.api.crypto.BlowFishUtil;
import org.sehkah.ddon.tools.extractor.api.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;

import java.util.HexFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlowFishUtilTest {

    @Test
    void testDecryptResourceInfoPath() {
        String sg30000ResourceInfo1 = "773C6B3FDCE8F303455EF6F0C398F5CA60352DB1D0F9B4DA8CA5B93345E705DB8CA5B93345E705DB8CA5B93345E705DB8CA5B93345E705DB8CA5B93345E705DB0855440D8B18EC1DBA1E25F72AE7ED4F";

        BufferReader temporaryReader = new BinaryReader(BlowFishUtil.decrypt(HexFormat.of().parseHex(sg30000ResourceInfo1)));

        assertEquals("etc\\goods_general", temporaryReader.readString(64).replace("\0", ""));
    }

    @Test
    void testDecryptCompatResourceInfoPath() {
        String sg30000ResourceInfo1 = "773C6B3FDCE8F303455EF6F0C398F5CA60352DB1D0F9B4DA8CA5B93345E705DB8CA5B93345E705DB8CA5B93345E705DB8CA5B93345E705DB8CA5B93345E705DB0855440D8B18EC1DBA1E25F72AE7ED4F";

        BufferReader temporaryReader = new BinaryReader(BlowFishUtil.decryptCompat(HexFormat.of().parseHex(sg30000ResourceInfo1)));

        assertEquals("etc\\goods_general", temporaryReader.readString(64).replace("\0", ""));
    }
}
