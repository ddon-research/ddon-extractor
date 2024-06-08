package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftRecipe;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftRecipeList;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftRecipeMaterialData;

public class CraftRecipeDeserializer extends ClientResourceFileDeserializer<CraftRecipeList> {


    private static CraftRecipeMaterialData readCraftRecipeMaterialData(BufferReader bufferReader) {
        return new CraftRecipeMaterialData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    private static CraftRecipe readCraftRecipe(BufferReader bufferReader) {
        return new CraftRecipe(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readArray(CraftRecipeDeserializer::readCraftRecipeMaterialData)
        );
    }

    @Override
    protected CraftRecipeList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CraftRecipeList(bufferReader.readArray(CraftRecipeDeserializer::readCraftRecipe));
    }
}
