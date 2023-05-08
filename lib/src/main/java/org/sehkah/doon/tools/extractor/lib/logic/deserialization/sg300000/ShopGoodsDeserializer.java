package org.sehkah.doon.tools.extractor.lib.logic.deserialization.sg300000;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.sg300000.ShopGoods;
import org.sehkah.doon.tools.extractor.lib.logic.entity.sg300000.meta.ShopGoodsDate;

import java.util.List;

public class ShopGoodsDeserializer extends FileDeserializer<List<ShopGoods>> {
    public ShopGoodsDeserializer() {
        super(ClientResourceFile.rShopGoods);
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
    protected List<ShopGoods> readObject(FileReader fileReader) {
        return fileReader.readArray(ShopGoodsDeserializer::readEntity);
    }
}
