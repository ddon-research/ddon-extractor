package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common;

public class GUIMessageIndex {
    public long Index;
    public long CrcHashDouble;
    public long CrcHashTriple;
    public long LinkOffset;
    public long Offset;
    public String Key;
    public long MessageIndex;
    public String Message;

    public GUIMessageIndex() {

    }

    public GUIMessageIndex(long index, long crcHashDouble, long crcHashTriple, long linkOffset, long offset) {
        Index = index;
        CrcHashDouble = crcHashDouble;
        CrcHashTriple = crcHashTriple;
        LinkOffset = linkOffset;
        Offset = offset;
    }
}
