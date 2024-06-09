module org.sehkah.ddon.tools.extractor.lib.season2 {
    requires static lombok;

    requires org.slf4j;

    requires org.apache.commons.lang3;
    requires org.apache.logging.log4j;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;

    requires org.sehkah.ddon.tools.extractor.lib.api;
    requires org.sehkah.ddon.tools.extractor.lib.common;

    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.base;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.binary;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.clankyoten;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.em_common;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.fieldarea;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.game_common;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.gui_cmn;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.job;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker.season2;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker.season3;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.MyRoom;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.npc;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.npc_common;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.om;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.quest;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.scr;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.sg300000;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.stage;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.tutorial_guide;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.ui.history;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.ui.uGUIAreaMaster;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.ui.uGUIKeyConfig;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.wep_res_table;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.skill;

    exports org.sehkah.ddon.tools.extractor.season2.logic.resource;

    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.meta;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.binary;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.meta;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.em_common;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.fieldarea;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.meta;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.job.meta;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.job;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season2;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season3;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.om;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.meta;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.scr;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.sg300000;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.sg300000.meta;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.meta;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.tutorial_guide;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.history;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIKeyConfig;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.wep_res_table.meta;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.wep_res_table;
    exports org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.skill;

}
