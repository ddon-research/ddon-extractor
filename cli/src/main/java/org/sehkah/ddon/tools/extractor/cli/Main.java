package org.sehkah.ddon.tools.extractor.cli;

import org.sehkah.ddon.tools.extractor.cli.logic.ExtractCommand;
import picocli.CommandLine;

public class Main {
    public static void main(String... args) {
        int exitCode = new CommandLine(new ExtractCommand()).execute(args);
        System.exit(exitCode);
    }
}
