package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.sg300000;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.sg300000.ShopGoods;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.sg300000.meta.ShopGoodsDate;

import java.util.List;

public class ShopGoodsDeserializer extends ClientResourceFileDeserializer<List<ShopGoods>> {
    public ShopGoodsDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ShopGoodsDate readShopGoodsDate(FileReader fileReader) {
        return new ShopGoodsDate(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte()
        );
    }

    private static ShopGoods readEntity(FileReader fileReader) {
        return new ShopGoods(
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedShort(),
                readShopGoodsDate(fileReader),
                readShopGoodsDate(fileReader),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedShort(),
                readShopGoodsDate(fileReader)
        );
    }

    @Override
    protected List<ShopGoods> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(ShopGoodsDeserializer::readEntity);
    }
}
