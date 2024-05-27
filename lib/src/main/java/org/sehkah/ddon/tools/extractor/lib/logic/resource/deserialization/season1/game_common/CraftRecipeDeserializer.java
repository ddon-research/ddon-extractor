package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season1.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common.CraftRecipe;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common.CraftRecipeList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common.CraftRecipeMaterialData;

/**
 * Season 1, season 2 & season 3 all share the same header version 2, but season 1 lacks the position data for areas.
 */
public class CraftRecipeDeserializer extends ClientResourceFileDeserializer {
    public CraftRecipeDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected CraftRecipeList parseClientResourceFile(BufferReader bufferReader) {
        return new CraftRecipeList(bufferReader.readArray(CraftRecipeDeserializer::readCraftRecipe));
    }
}
