module org.sehkah.ddon.tools.extractor.cli {
    requires static lombok;

    requires info.picocli;
    requires org.slf4j;
    requires org.apache.logging.log4j;

    requires org.sehkah.ddon.tools.extractor.lib.common;
    requires org.sehkah.ddon.tools.extractor.lib.season1;
    requires org.sehkah.ddon.tools.extractor.lib.season3;
    requires org.sehkah.ddon.tools.extractor.lib.season2;

    opens org.sehkah.ddon.tools.extractor.cli.logic to info.picocli;
}
