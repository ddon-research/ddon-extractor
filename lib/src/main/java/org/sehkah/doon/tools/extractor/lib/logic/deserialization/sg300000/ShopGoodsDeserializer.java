package org.sehkah.doon.tools.extractor.lib.logic.deserialization.sg300000;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.sg300000.ShopGoods;
import org.sehkah.doon.tools.extractor.lib.logic.entity.sg300000.meta.ShopGoodsDate;
import org.sehkah.doon.tools.extractor.lib.logic.entity.sg300000.meta.ShopGoodsWithMetaInformation;

public class ShopGoodsDeserializer extends FileDeserializer {
    public ShopGoodsDeserializer(FileReader fileReader) {
        super(ExtensionMap.rShopGoods, fileReader);
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

    private static ShopGoodsWithMetaInformation readEntityWithMetaInformation(FileReader fileReader) {
        return new ShopGoodsWithMetaInformation(readEntity(fileReader));
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(ShopGoodsDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return fileReader.readArray(ShopGoodsDeserializer::readEntityWithMetaInformation);
    }
}
