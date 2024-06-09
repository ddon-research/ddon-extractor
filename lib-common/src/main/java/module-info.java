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
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.pawn;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ui;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.launcher;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.Human;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EM;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.craft_common;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.character_edit;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.em_common;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.equip;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.job;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.skill;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.collision_common;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.quest;

    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.meta;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.meta;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.tutorial_guide;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.pawn;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.meta;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.launcher;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.Human;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.meta;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.craft_common;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.craft_common.meta;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.character_edit;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common.meta;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.equip;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.job;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.job.meta;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.skill;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.collision_common;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest;
    exports org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest.meta;

    exports org.sehkah.ddon.tools.extractor.common.logic.resource.serialization.game_common;
}
