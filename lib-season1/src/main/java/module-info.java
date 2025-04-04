module org.sehkah.ddon.tools.extractor.lib.season1 {
    requires static lombok;

    requires org.slf4j;

    requires org.apache.commons.lang3;
    requires org.apache.logging.log4j;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;

    requires java.desktop;

    requires org.sehkah.ddon.tools.extractor.lib.api;
    requires org.sehkah.ddon.tools.extractor.lib.common;

    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.base;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.binary;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.EM;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.gui_cmn;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.job;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.marker;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.npc;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.quest;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.skill;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.stage;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.tutorial_guide;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.ui.uGUIAreaMaster;

    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.binary;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.gui_cmn;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.job;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.marker;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.skill;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.tutorial_guide;
    exports org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.ui.uGUIAreaMaster;

    exports org.sehkah.ddon.tools.extractor.season1.logic.resource;
}
