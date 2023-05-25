module org.sehkah.ddon.tools.extractor.lib.test {
    requires org.apache.commons.codec;
    requires org.junit.jupiter.api;

    requires org.sehkah.ddon.tools.extractor.lib;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.dataformat.yaml;

    opens org.sehkah.ddon.tools.extractor.lib.test.logic.serialization to org.junit.platform.commons;
}
