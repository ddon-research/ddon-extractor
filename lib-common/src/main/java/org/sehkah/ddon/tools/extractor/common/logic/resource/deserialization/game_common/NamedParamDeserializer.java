package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.NamedParam;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.NamedParamList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.meta.NamedParamType;

import java.nio.file.Path;

public class NamedParamDeserializer extends ClientResourceFileDeserializer<NamedParamList> {
    private static NamedParam readNamedParam(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ID = bufferReader.readUnsignedInteger();
        long Type = bufferReader.readUnsignedInteger();
        Translation Name = null;
        if (lookupUtil != null) {
            Name = lookupUtil.getMessageTranslation(GUIMessageLookupTable.NAMED_PARAM.getFilePath(), "namedparam_" + ID);
        }

        NamedParamType TypeName = NamedParamType.of(Type);
        long HpRate = bufferReader.readUnsignedInteger();
        int Experience = bufferReader.readUnsignedShort();
        int AttackBasePhys = bufferReader.readUnsignedShort();
        int AttackWepPhys = bufferReader.readUnsignedShort();
        int DefenceBasePhys = bufferReader.readUnsignedShort();
        int DefenceWepPhys = bufferReader.readUnsignedShort();
        int AttackBaseMagic = bufferReader.readUnsignedShort();
        int AttackWepMagic = bufferReader.readUnsignedShort();
        int DefenceBaseMagic = bufferReader.readUnsignedShort();
        int DefenceWepMagic = bufferReader.readUnsignedShort();
        int Power = bufferReader.readUnsignedShort();
        int GuardDefenceBase = bufferReader.readUnsignedShort();
        int GuardDefenceWep = bufferReader.readUnsignedShort();
        int ShrinkEnduranceMain = bufferReader.readUnsignedShort();
        int BlowEnduranceMain = bufferReader.readUnsignedShort();
        int DownEnduranceMain = bufferReader.readUnsignedShort();
        int ShakeEnduranceMain = bufferReader.readUnsignedShort();
        int HpSub = bufferReader.readUnsignedShort();
        int ShrinkEnduranceSub = bufferReader.readUnsignedShort();
        int BlowEnduranceSub = bufferReader.readUnsignedShort();
        int OcdEndurance = bufferReader.readUnsignedShort();
        int AilmentDamage = bufferReader.readUnsignedShort();

        return new NamedParam(ID, Name, Type, TypeName, HpRate, Experience, AttackBasePhys, AttackWepPhys, DefenceBasePhys, DefenceWepPhys, AttackBaseMagic, AttackWepMagic, DefenceBaseMagic, DefenceWepMagic, Power, GuardDefenceBase, GuardDefenceWep, ShrinkEnduranceMain, BlowEnduranceMain, DownEnduranceMain, ShakeEnduranceMain, HpSub, ShrinkEnduranceSub, BlowEnduranceSub, OcdEndurance, AilmentDamage);
    }

    @Override
    protected NamedParamList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NamedParamList(bufferReader.readArray(NamedParamDeserializer::readNamedParam, lookupUtil));
    }
}
