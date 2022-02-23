package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalLogTrace implements LogTrace {

    private static final String START_PREFIX = "-->";
    private static final String END_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>();

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        final TraceId traceId = traceIdHolder.get();
        final long time = System.currentTimeMillis();

        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, time, message);
    }

    @Override
    public void end(TraceStatus status) {
        complete(status, null);

    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    private void syncTraceId() {
        final TraceId traceId = traceIdHolder.get();
        if (traceId == null) {
            traceIdHolder.set(new TraceId());
        } else {
            traceIdHolder.set(traceId.createNextId());
        }
    }

    private void releaseTraceId() {
        final TraceId traceId = traceIdHolder.get();
        if (traceId.isFirstLevel()) {
            traceIdHolder.remove();
        } else {
            traceIdHolder.set(traceId.createPreviousId());
        }
    }

    private void complete(TraceStatus status, Exception e) {
        long timeMs = System.currentTimeMillis() - status.getStartTimeMs();
        final TraceId traceId = status.getTraceId();

        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(END_PREFIX, traceId.getLevel()), status.getMessage(), timeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), timeMs, e.toString());
        }

        releaseTraceId();
    }

    private String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<level; i++) {
            sb.append(i == level - 1? "|" + prefix : "|   ");
        }
        return sb.toString();
    }
}
