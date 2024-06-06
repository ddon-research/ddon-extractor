module org.sehkah.ddon.tools.extractor.lib.api {
    requires static lombok;

    requires org.slf4j;

    requires org.apache.commons.lang3;
    requires org.apache.logging.log4j;

    requires org.bouncycastle.provider;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;

    exports org.sehkah.ddon.tools.extractor.api.crypto;
    exports org.sehkah.ddon.tools.extractor.api.datatype;
    exports org.sehkah.ddon.tools.extractor.api.entity;
    exports org.sehkah.ddon.tools.extractor.api.packet;
    exports org.sehkah.ddon.tools.extractor.api.error;
    exports org.sehkah.ddon.tools.extractor.api.io;
    exports org.sehkah.ddon.tools.extractor.api.serialization;
    exports org.sehkah.ddon.tools.extractor.api.deserialization;
    exports org.sehkah.ddon.tools.extractor.api.util;

    exports org.sehkah.ddon.tools.extractor.api.logic.packet;
    exports org.sehkah.ddon.tools.extractor.api.logic.packet.deserialization;

    exports org.sehkah.ddon.tools.extractor.api.logic.resource;
    exports org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization;
    exports org.sehkah.ddon.tools.extractor.api.logic.resource.serialization;
}
