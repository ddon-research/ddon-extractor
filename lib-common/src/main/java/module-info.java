module org.sehkah.ddon.tools.extractor.lib.common {
    requires static lombok;

    requires org.slf4j;

    requires org.apache.commons.lang3;
    requires org.apache.logging.log4j;

    requires org.bouncycastle.provider;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;

    exports org.sehkah.ddon.tools.extractor.lib.common.crypto;
    exports org.sehkah.ddon.tools.extractor.lib.common.datatype;
    exports org.sehkah.ddon.tools.extractor.lib.common.entity;
    exports org.sehkah.ddon.tools.extractor.lib.common.packet;
    exports org.sehkah.ddon.tools.extractor.lib.common.error;
    exports org.sehkah.ddon.tools.extractor.lib.common.io;
    exports org.sehkah.ddon.tools.extractor.lib.common.serialization;
    exports org.sehkah.ddon.tools.extractor.lib.common.util;

    exports org.sehkah.ddon.tools.extractor.lib.logic.packet;
    exports org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization;

    exports org.sehkah.ddon.tools.extractor.lib.logic.resource;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity;
    exports org.sehkah.ddon.tools.extractor.lib.common.deserialization;
}
