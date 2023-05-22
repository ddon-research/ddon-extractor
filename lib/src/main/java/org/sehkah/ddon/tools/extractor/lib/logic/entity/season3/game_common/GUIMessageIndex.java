package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GUIMessageIndex {
    public long index;
    public long crcHashDouble;
    public long crcHashTriple;
    public long linkOffset;
    public long offset;
    public String key;
    public long messageIndex;
    public String message;
}
