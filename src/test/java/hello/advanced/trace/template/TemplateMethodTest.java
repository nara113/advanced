package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class TemplateMethodTest {

    @Test
    void templateTestV1() {
        AbstractTemplate logic1 = new SubClassLogic1();
        logic1.execute();

        AbstractTemplate logic2 = new SubClassLogic2();
        logic2.execute();
    }

    @Test
    void templateTestV2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("logic1");
            }
        };

        log.info("class name : {}", template1.getClass());
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("logic2");
            }
        };

        log.info("class name : {}", template2.getClass());
        template2.execute();

    }
}
