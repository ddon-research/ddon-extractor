package org.sehkah.ddon.tools.extractor.api.crypto;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.Throughput)
@State(Scope.Thread)
public class BlowFishBenchmark {
    private static final String SAMPLE = "773C6B3FDCE8F303455EF6F0C398F5CA60352DB1D0F9B4DA8CA5B93345E705DB8CA5B93345E705DB8CA5B93345E705DB8CA5B93345E705DB8CA5B93345E705DB0855440D8B18EC1DBA1E25F72AE7ED4F";

    @Benchmark
    public void decrypt(Blackhole bh) {
        bh.consume(BlowFishUtil.decrypt(SAMPLE.getBytes()));
    }
}
