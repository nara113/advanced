package hello.advanced.app.v0;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV0 {

    void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("exception");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}