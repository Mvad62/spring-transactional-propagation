package ru.liga.springtransactional.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.springtransactional.dto.OrderDto;

@Service
@RequiredArgsConstructor
public class OrderProcessingService {

    private final OrderService orderService;
    private final InventoryService inventoryService;

    @Transactional
    public void processOrder(OrderDto orderDto) {
        orderService.create(orderDto);
        inventoryService.reduceStock(orderDto);
    }
}
