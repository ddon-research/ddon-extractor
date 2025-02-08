module org.sehkah.ddon.tools.extractor.lib.test {

    requires org.apache.commons.codec;

    requires org.junit.jupiter.api;
    requires org.junitpioneer;

    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.dataformat.yaml;

    requires org.sehkah.ddon.tools.extractor.lib.api;
    requires org.sehkah.ddon.tools.extractor.lib.common;
    requires org.sehkah.ddon.tools.extractor.lib.season1;
    requires org.sehkah.ddon.tools.extractor.lib.season2;
    requires org.sehkah.ddon.tools.extractor.lib.season3;
    requires org.mockito;

    opens org.sehkah.ddon.tools.extractor.lib.test.logic.packet.deserialization to org.junit.platform.commons;
    opens org.sehkah.ddon.tools.extractor.lib.test.logic.resource.serialization to org.junit.platform.commons;
    opens org.sehkah.ddon.tools.extractor.lib.test.logic.resource.deserialization to org.junit.platform.commons;
    opens org.sehkah.ddon.tools.extractor.lib.test.logic.resource to org.junit.platform.commons;
    opens org.sehkah.ddon.tools.extractor.lib.test.api.crypto to org.junit.platform.commons;
    opens org.sehkah.ddon.tools.extractor.lib.test.api.io to org.junit.platform.commons;
}
