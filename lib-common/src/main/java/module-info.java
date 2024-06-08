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
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.gui_cmn;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.npc_common;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.tutorial_guide;

    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.meta;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.meta;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.tutorial_guide;

    exports org.sehkah.ddon.tools.extractor.common.logic.resource.serialization.game_common;
}
