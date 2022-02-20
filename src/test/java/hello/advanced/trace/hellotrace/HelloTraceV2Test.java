package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV2Test {

    @Test
    void begin_end() {
        final HelloTraceV2 helloTraceV2 = new HelloTraceV2();
        final TraceStatus status = helloTraceV2.begin("hello1");
        final TraceStatus status2 = helloTraceV2.beginSync(status.getTraceId(), "hello2");
        helloTraceV2.end(status2);
        helloTraceV2.end(status);
    }

    @Test
    void begin_exception() {
        final HelloTraceV2 helloTraceV2 = new HelloTraceV2();
        final TraceStatus status = helloTraceV2.begin("hello");
        final TraceStatus status2 = helloTraceV2.beginSync(status.getTraceId(), "hello2");
        helloTraceV2.exception(status2, new IllegalStateException());
        helloTraceV2.exception(status, new IllegalStateException());
    }
}