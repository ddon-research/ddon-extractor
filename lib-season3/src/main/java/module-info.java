module org.sehkah.ddon.tools.extractor.lib.season3 {
    requires static lombok;

    requires org.slf4j;

    requires org.apache.commons.lang3;
    requires org.apache.logging.log4j;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires org.sehkah.ddon.tools.extractor.lib.common;

    exports org.sehkah.ddon.tools.extractor.season3.logic.packet.deserialization.c2l;
    exports org.sehkah.ddon.tools.extractor.season3.logic.packet.deserialization.l2c;

    exports org.sehkah.ddon.tools.extractor.season3.resource.serialization.game_common;

    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.game_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.marker;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.stage;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.EM;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.MyRoom;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.clankyoten;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.gui_cmn;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.job;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.npc;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.quest;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.skill;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.tutorial_guide;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.ui.uGUIAreaMaster;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.Human;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.binary;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.character_edit;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.collision_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.craft_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.effect_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.em_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.equip;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.fieldarea;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.launcher;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.npc_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.om;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.pawn;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.scr;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.sg300000;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.ui.history;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.ui.uGUIArisenCard;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.ui.uGUIDogmaOrb;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.ui.uGUIKeyConfig;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.ui.uGUISkill;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.wep_res_table;

    exports org.sehkah.ddon.tools.extractor.season3.logic.packet;
    exports org.sehkah.ddon.tools.extractor.season3.logic.packet.entity.c2l;
    exports org.sehkah.ddon.tools.extractor.season3.logic.packet.entity.l2c;
    exports org.sehkah.ddon.tools.extractor.season3.logic.packet.entity.c2l.meta;
    exports org.sehkah.ddon.tools.extractor.season3.logic.packet.entity.c2s;

    exports org.sehkah.ddon.tools.extractor.season3.resource;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.base.meta;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.base;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.binary;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.character_edit;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.clankyoten;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.collision_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.craft_common.meta;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.craft_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.effect_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.EM.meta;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.EM;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.em_common.meta;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.em_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.equip;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.fieldarea.meta;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.fieldarea;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.meta;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.gui_cmn;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.Human;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.job.meta;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.job;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.launcher;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.marker;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.MyRoom;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.npc;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.npc_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.om;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.pawn;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.quest.meta;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.quest;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.scr;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.sg300000;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.sg300000.meta;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.skill;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.stage.meta;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.stage;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.tutorial_guide;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.ui.history;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.ui.uGUIAreaMaster;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.ui.uGUIArisenCard;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.ui.uGUIDogmaOrb;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.ui.uGUIKeyConfig;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.ui.uGUISkill;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.wep_res_table.wep_res_table.meta;
    exports org.sehkah.ddon.tools.extractor.season3.resource.entity.wep_res_table.wep_res_table;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.base;
}
