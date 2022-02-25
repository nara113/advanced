package hello.advanced;

import hello.advanced.trace.TraceId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.stream.Stream;

@SpringBootApplication
public class AdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedApplication.class, args);

        Stream.of(1,2,3)
                .sorted(Integer::compareTo);

        TraceId traceId = new TraceId();
        TraceId traceId2 = new TraceId();

        Stream.of(traceId, traceId2)
                .sorted(Comparator.comparingInt(TraceId::getLevel));

    }

}
