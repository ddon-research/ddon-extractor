package org.sehkah.ddon.tools.extractor.cli.logic;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.sehkah.ddon.tools.extractor.cli.logic.util.FileChangeDetector;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@State(Scope.Benchmark)
public class FileChangeDetectorBenchmark {
    private final Map<String, byte[]> dataSets = new HashMap<>();
    @Param({"SMALL", "MEDIUM", "LARGE"})
    public String sizeProfile;

    private static byte[] randomBytes(SecureRandom random, int len) {
        byte[] b = new byte[len];
        random.nextBytes(b);
        return b;
    }

    @Setup(Level.Trial)
    public void setup() {
        // Prepare deterministic random data for repeatable benchmarks
        SecureRandom random = new SecureRandom("ddon-benchmark-seed".getBytes(StandardCharsets.UTF_8));
        dataSets.put("SMALL", randomBytes(random, 64));          // fits in a few stripes
        dataSets.put("MEDIUM", randomBytes(random, 4096));       // typical resource size
        dataSets.put("LARGE", randomBytes(random, 512 * 1024));  // 512 KiB large sample
    }

    @Benchmark
    public void hashDataset(Blackhole bh) {
        byte[] data = dataSets.get(sizeProfile);
        bh.consume(FileChangeDetector.computeHash(data));
    }
}
