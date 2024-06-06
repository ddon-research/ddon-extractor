module org.sehkah.ddon.tools.extractor.lib.common {
    requires static lombok;

    requires org.slf4j;

    requires org.apache.commons.lang3;
    requires org.apache.logging.log4j;

    requires org.bouncycastle.provider;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;

    requires org.sehkah.ddon.tools.extractor.lib.api;

    exports org.sehkah.ddon.tools.extractor.common.logic.resource;

    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.base;

    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base;
}
