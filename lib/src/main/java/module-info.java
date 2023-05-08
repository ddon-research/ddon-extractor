module org.sehkah.ddon.tools.extractor.lib {
    requires org.apache.logging.log4j;

    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.dataformat.yaml;

    exports org.sehkah.doon.tools.extractor.lib.common.datatype;
    exports org.sehkah.doon.tools.extractor.lib.common.error;
    exports org.sehkah.doon.tools.extractor.lib.common.io;

    exports org.sehkah.doon.tools.extractor.lib.logic.deserialization;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.game_common;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.meta;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.meta;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.base;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.stage;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.stage.meta;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea.meta;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.sg300000;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.sg300000.meta;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.ui.history;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIArisenCard;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUISkill;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIAreaMaster;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.preset.equip;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.EM;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.EM.meta;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.skill;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.scr;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.tutorial_guide;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.quest;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.quest.meta;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.clankyoten;
    exports org.sehkah.doon.tools.extractor.lib.logic.entity.MyRoom;

    exports org.sehkah.doon.tools.extractor.lib.logic.serialization;
}
