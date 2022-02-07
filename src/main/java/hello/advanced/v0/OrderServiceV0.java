package hello.advanced.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceV0 {

    private final OrderRepositoryV0 repository;

    void orderItem(String itemId) {
        repository.save(itemId);
    }
}
