package org.sehkah.ddon.tools.extractor.cli.logic;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.cli.logic.commands.ExtractPacketCommand;
import org.sehkah.ddon.tools.extractor.cli.logic.commands.ExtractResourceCommand;
import picocli.CommandLine;

@Slf4j
@CommandLine.Command(
        name = "extract",
        mixinStandardHelpOptions = true,
        version = "extract 1.0",
        description = "Extracts the provided DDON resource or packet file(s).",
        subcommands = {ExtractResourceCommand.class, ExtractPacketCommand.class}
)
public class ExtractCommand {
}
