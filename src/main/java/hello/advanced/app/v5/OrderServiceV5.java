package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 repository;
    private final TraceTemplate traceTemplate;

    public OrderServiceV5(OrderRepositoryV5 repository, LogTrace logTrace) {
        this.repository = repository;
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    void orderItem(String itemId) {
        traceTemplate.execute("OrderService.orderItem()", () -> {
            repository.save(itemId);
            return null;
        });
    }
}
