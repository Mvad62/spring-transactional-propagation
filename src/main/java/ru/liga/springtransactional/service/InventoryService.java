package ru.liga.springtransactional.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.springtransactional.dto.OrderDto;
import ru.liga.springtransactional.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final ProductRepository productRepository;

    @Transactional
    public void reduceStock(OrderDto orderDto) {
        // todo реализовать
    }
}
