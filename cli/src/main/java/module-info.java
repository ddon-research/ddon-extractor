module org.sehkah.ddon.tools.extractor.cli {
    requires info.picocli;
    requires org.apache.logging.log4j;
    requires org.sehkah.ddon.tools.extractor.lib;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.dataformat.yaml;

    opens org.sehkah.ddon.tools.extractor.cli.logic to info.picocli;
}