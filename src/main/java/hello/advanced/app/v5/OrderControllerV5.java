package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 service;
    private final TraceTemplate traceTemplate;

    public OrderControllerV5(OrderServiceV5 service, LogTrace logTrace) {
        this.service = service;
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return traceTemplate.execute("OrderController.request()", () -> {
            service.orderItem(itemId);
            return "ok";
        });
    }
}
