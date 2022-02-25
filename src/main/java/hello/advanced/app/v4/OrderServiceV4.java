package hello.advanced.app.v4;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceV4 {

    private final OrderRepositoryV4 repository;
    private final LogTrace trace;

    void orderItem(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                repository.save(itemId);
                return null;
            }
        };
        template.execute("OrderService.orderItem()");
    }
}
