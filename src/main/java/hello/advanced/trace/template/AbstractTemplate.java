package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace logTrace;

    public AbstractTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public T execute(String msg) {

        TraceStatus status = null;

        try {
            status = logTrace.begin(msg);
            final T result = call();
            logTrace.end(status);

            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}
