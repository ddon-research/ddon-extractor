package org.sehkah.ddon.tools.extractor.api.packet;


public enum PacketIdentifier {
    C2L_LOGIN_REQ,
    L2C_LOGIN_RES,
    C2S_CLAN_GET_MY_INFO_REQ;

    public static final PacketIdentifier[] values = values();
}
