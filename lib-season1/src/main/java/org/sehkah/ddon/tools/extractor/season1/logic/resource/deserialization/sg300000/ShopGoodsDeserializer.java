package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.sg300000;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.sg300000.ShopGoods;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.sg300000.ShopGoodsDate;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.sg300000.ShopGoodsList;

public class ShopGoodsDeserializer extends ClientResourceFileDeserializer {
    public ShopGoodsDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ShopGoodsDate readShopGoodsDate(BufferReader bufferReader) {
        return new ShopGoodsDate(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte()
        );
    }

    private static ShopGoods readShopGoods(BufferReader bufferReader) {
        return new ShopGoods(
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedShort(),
                readShopGoodsDate(bufferReader),
                readShopGoodsDate(bufferReader),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedShort(),
                readShopGoodsDate(bufferReader)
        );
    }

    @Override
    protected ShopGoodsList parseClientResourceFile(BufferReader bufferReader) {
        return new ShopGoodsList(bufferReader.readArray(ShopGoodsDeserializer::readShopGoods));
    }
}
