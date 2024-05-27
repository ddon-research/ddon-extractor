module org.sehkah.ddon.tools.extractor.lib {
    requires static lombok;

    requires org.slf4j;

    requires org.apache.commons.lang3;
    requires org.apache.logging.log4j;

    requires org.bouncycastle.provider;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;

    exports org.sehkah.ddon.tools.extractor.lib.common.crypto;
    exports org.sehkah.ddon.tools.extractor.lib.common.datatype;
    exports org.sehkah.ddon.tools.extractor.lib.common.entity;
    exports org.sehkah.ddon.tools.extractor.lib.common.packet;
    exports org.sehkah.ddon.tools.extractor.lib.common.error;
    exports org.sehkah.ddon.tools.extractor.lib.common.io;
    exports org.sehkah.ddon.tools.extractor.lib.common.serialization;


    exports org.sehkah.ddon.tools.extractor.lib.logic.packet;
    exports org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization;
    exports org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.c2l;

    exports org.sehkah.ddon.tools.extractor.lib.logic.packet.entity.c2l;
    exports org.sehkah.ddon.tools.extractor.lib.logic.packet.entity.l2c;
    exports org.sehkah.ddon.tools.extractor.lib.logic.packet.entity.c2l.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.packet.entity.c2s;

    exports org.sehkah.ddon.tools.extractor.lib.logic.resource;

    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization;

    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.meta;

    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.marker;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.stage;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common;

    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.clankyoten;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.EM;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.game_common;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.gui_cmn;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.marker;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.MyRoom;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.npc;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.skill;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.quest;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.tutorial_guide;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.ui.uGUIAreaMaster;

    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.character_edit;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.clankyoten;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.collision_common;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.craft_common.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.craft_common;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.effect_common;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.equip;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.fieldarea.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.fieldarea;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.Human;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.job.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.job;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.launcher;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.marker;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.MyRoom;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.npc;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.npc_common;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.om;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.pawn;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.scr;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.sg300000;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.sg300000.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.skill;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.tutorial_guide;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.history;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUIAreaMaster;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUIArisenCard;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUIDogmaOrb;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUIKeyConfig;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUISkill;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.wep_res_table.meta;
    exports org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.wep_res_table;
}
