package ru.liga.springtransactional.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.springtransactional.dto.OrderDto;
import ru.liga.springtransactional.model.Order;
import ru.liga.springtransactional.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final AuditService auditService;

    @Transactional
    public void create(OrderDto orderDto) {
        Order order = new Order()
                .setProductName(orderDto.productName())
                .setQuantity(orderDto.quantity());

        orderRepository.save(order);

        auditService.log(
                "CREATE_ORDER",
                "Товар '%s', количество: %d".formatted(order.getProductName(), order.getQuantity())
        );
    }
}
