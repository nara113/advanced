package hello.advanced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        final long startTime = System.currentTimeMillis();
        callback.call();
        final long endTime = System.currentTimeMillis();
        log.info("result time : {}", endTime - startTime);
    }
}
