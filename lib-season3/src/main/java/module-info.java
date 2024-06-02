module org.sehkah.ddon.tools.extractor.lib.season3 {
    requires static lombok;

    requires org.slf4j;

    requires org.apache.commons.lang3;
    requires org.apache.logging.log4j;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires org.sehkah.ddon.tools.extractor.lib.common;

    exports org.sehkah.ddon.tools.extractor.season3.packet.deserialization.c2l;
    exports org.sehkah.ddon.tools.extractor.season3.packet.deserialization.l2c;

    exports org.sehkah.ddon.tools.extractor.season3.resource.serialization.game_common;

    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.game_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.marker;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.stage;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.EM;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.MyRoom;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.base;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.clankyoten;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.gui_cmn;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.job;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.npc;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.quest;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.skill;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.tutorial_guide;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.ui.uGUIAreaMaster;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.Human;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.binary;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.character_edit;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.collision_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.craft_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.effect_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.em_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.equip;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.fieldarea;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.launcher;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.npc_common;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.om;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.pawn;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.scr;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.sg300000;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.ui.history;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.ui.uGUIArisenCard;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.ui.uGUIDogmaOrb;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.ui.uGUIKeyConfig;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.ui.uGUISkill;
    exports org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.wep_res_table;

    exports org.sehkah.ddon.tools.extractor.season3.packet;
    exports org.sehkah.ddon.tools.extractor.season3.packet.entity.c2l;
    exports org.sehkah.ddon.tools.extractor.season3.packet.entity.l2c;
    exports org.sehkah.ddon.tools.extractor.season3.packet.entity.c2l.meta;
    exports org.sehkah.ddon.tools.extractor.season3.packet.entity.c2s;

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
}
