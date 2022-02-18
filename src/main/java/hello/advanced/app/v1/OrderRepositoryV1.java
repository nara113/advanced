package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV1 {

    private final HelloTraceV1 trace;

    void save(String itemId) {
        TraceStatus status = null;

        try {
            status = trace.begin("OrderRepository.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("exception");
            }

            sleep();
            trace.end(status);

        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}