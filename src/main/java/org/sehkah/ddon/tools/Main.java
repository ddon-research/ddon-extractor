package org.sehkah.ddon.tools;

import org.sehkah.ddon.tools.extractor.ExtractCommand;
import picocli.CommandLine;

public class Main {
    public static void main(String... args) {
        int exitCode = new CommandLine(new ExtractCommand()).execute(args);
        System.exit(exitCode);
    }
}
