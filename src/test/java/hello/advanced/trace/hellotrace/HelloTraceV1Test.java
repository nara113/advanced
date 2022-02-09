package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV1Test {

    @Test
    void begin_end() {
        final HelloTraceV1 helloTraceV1 = new HelloTraceV1();
        final TraceStatus status = helloTraceV1.begin("hello");
        helloTraceV1.end(status);
    }

    @Test
    void begin_exception() {
        final HelloTraceV1 helloTraceV1 = new HelloTraceV1();
        final TraceStatus status = helloTraceV1.begin("hello");
        helloTraceV1.exception(status, new IllegalStateException());
    }
}