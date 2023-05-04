module org.sehkah.ddon.tools.extractor.lib {
    requires com.fasterxml.jackson.dataformat.yaml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.apache.logging.log4j;

    exports org.sehkah.doon.tools.extractor.lib.common.io;
    exports org.sehkah.doon.tools.extractor.lib.common.serialization;
    exports org.sehkah.doon.tools.extractor.lib.logic.reserialization;
    exports org.sehkah.doon.tools.extractor.lib.common.error;

    exports org.sehkah.doon.tools.extractor.lib.logic.entity.game_common to com.fasterxml.jackson.databind;
}