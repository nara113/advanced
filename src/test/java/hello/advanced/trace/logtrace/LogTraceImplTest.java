package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogTraceImplTest {

    LogTrace logTrace = new LogTraceImpl();

    @Test
    void begin_end_level2() {
        final TraceStatus level1 = logTrace.begin("level1");
        final TraceStatus level2 = logTrace.begin("level2");
        logTrace.end(level2);
        logTrace.end(level1);
    }


    @Test
    void begin_exception_level2() {
        final TraceStatus level1 = logTrace.begin("level1");
        final TraceStatus level2 = logTrace.begin("level2");
        logTrace.exception(level2, new IllegalStateException());
        logTrace.exception(level1, new IllegalStateException());
    }
}