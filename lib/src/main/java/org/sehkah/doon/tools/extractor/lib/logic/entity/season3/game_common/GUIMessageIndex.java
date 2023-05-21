package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common;

public class GUIMessageIndex {
    public long index;
    public long crcHashDouble;
    public long crcHashTriple;
    public long linkOffset;
    public long offset;
    public String key;
    public long messageIndex;
    public String message;

    public GUIMessageIndex() {

    }

    public GUIMessageIndex(long index, long crcHashDouble, long crcHashTriple, long linkOffset, long offset) {
        this.index = index;
        this.crcHashDouble = crcHashDouble;
        this.crcHashTriple = crcHashTriple;
        this.linkOffset = linkOffset;
        this.offset = offset;
    }
}
