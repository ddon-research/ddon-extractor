package org.sehkah.ddon.tools.extractor.lib.common.error;

import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;

public class PacketParsingIncompleteException extends TechnicalException {
    public PacketParsingIncompleteException() {
    }

    public PacketParsingIncompleteException(Packet packet, int remainingBytesCount, int maxBytesCount) {
        super("Packet has data remaining! %s bytes are unread (%s / %s) while parsing packet with header '%s'.".formatted(remainingBytesCount, maxBytesCount - remainingBytesCount, maxBytesCount, packet.getHeader()));
    }

    public PacketParsingIncompleteException(String message) {
        super(message);
    }

    public PacketParsingIncompleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public PacketParsingIncompleteException(Throwable cause) {
        super(cause);
    }

    public PacketParsingIncompleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
