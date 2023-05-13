module org.sehkah.ddon.tools.extractor.cli {
    requires info.picocli;
    requires org.slf4j;
    requires org.apache.logging.log4j;
    requires org.sehkah.ddon.tools.extractor.lib;

    opens org.sehkah.ddon.tools.extractor.cli.logic to info.picocli;
}
