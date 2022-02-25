package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import org.junit.jupiter.api.Test;

public class TemplateMethodTest {

    @Test
    void templateTest() {
        AbstractTemplate logic1 = new SubClassLogic1();
        logic1.execute();

        AbstractTemplate logic2 = new SubClassLogic2();
        logic2.execute();
    }
}
