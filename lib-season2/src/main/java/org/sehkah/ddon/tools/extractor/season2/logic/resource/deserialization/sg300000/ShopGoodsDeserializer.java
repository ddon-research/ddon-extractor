package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.sg300000;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.sg300000.ShopGoods;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.sg300000.ShopGoodsDate;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.sg300000.ShopGoodsList;

public class ShopGoodsDeserializer extends ClientResourceFileDeserializer<ShopGoodsList> {


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
    protected ShopGoodsList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new ShopGoodsList(bufferReader.readArray(ShopGoodsDeserializer::readShopGoods));
    }
}
