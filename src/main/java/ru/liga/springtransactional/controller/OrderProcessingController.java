package ru.liga.springtransactional.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.springtransactional.dto.OrderDto;
import ru.liga.springtransactional.service.OrderProcessingService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderProcessingController {

    private final OrderProcessingService orderProcessingService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {
        orderProcessingService.processOrder(orderDto);
        return ResponseEntity.ok("Заказ успешно создан и обработан!");
    }
}
