package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {
    public void execute() {
        final long startTime = System.currentTimeMillis();
        call();
        final long endTime = System.currentTimeMillis();
        log.info("result time : {}", endTime - startTime);
    }

    protected abstract void call();
}
