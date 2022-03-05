package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV2;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ContextTestV2 {
    @Test
    void strategyV2_1() {
        ContextV2 contextV2 = new ContextV2();

        Strategy strategy1 = new StrategyLogic1();
        contextV2.execute(strategy1);

        Strategy strategy2 = new StrategyLogic2();
        contextV2.execute(strategy2);
    }

    @Test
    void strategyV2_2() {
        ContextV2 contextV2 = new ContextV2();

        Strategy strategy1 = new Strategy() {
            @Override
            public void call() {
                log.info("logic 1");
            }
        };
        contextV2.execute(strategy1);

        Strategy strategy2 = new Strategy() {
            @Override
            public void call() {
                log.info("logic 2");
            }
        };
        contextV2.execute(strategy2);
    }

    @Test
    void strategyV3() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(() -> log.info("logic 1"));
        contextV2.execute(() -> log.info("logic 2"));
    }
}
