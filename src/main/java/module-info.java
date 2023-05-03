module org.sehkah.ddon.tools {
    requires com.fasterxml.jackson.dataformat.yaml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    requires info.picocli;

    requires org.apache.logging.log4j;

    opens org.sehkah.ddon.tools.extractor to com.fasterxml.jackson.databind, info.picocli;
    opens org.sehkah.ddon.tools.extractor.logic.game_common to com.fasterxml.jackson.databind, info.picocli;

    exports org.sehkah.ddon.tools.extractor to com.fasterxml.jackson.databind;
    exports org.sehkah.ddon.tools.extractor.logic.game_common to com.fasterxml.jackson.databind;
    exports org.sehkah.ddon.tools.extractor.model.game_common to com.fasterxml.jackson.databind;
}