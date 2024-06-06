package org.sehkah.ddon.tools.extractor.api.logic.packet.deserialization;

import org.sehkah.ddon.tools.extractor.api.packet.PacketIdentifier;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum PacketFileExtension {
    packet, yaml;

    private static final Set<String> names = HashSet.newHashSet(128);

    static {
        names.addAll(Arrays.stream(PacketIdentifier.values).map(PacketIdentifier::name).collect(Collectors.toSet()));
        names.addAll(Arrays.stream(values()).map(Enum::name).collect(Collectors.toSet()));
    }

    public static Set<String> getSupportedFileExtensions() {
        return names;
    }
}
