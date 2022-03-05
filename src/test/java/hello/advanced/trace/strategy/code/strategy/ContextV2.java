package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {
    public void execute(Strategy strategy) {
        final long startTime = System.currentTimeMillis();
        strategy.call();
        final long endTime = System.currentTimeMillis();
        log.info("result time : {}", endTime - startTime);
    }
}
