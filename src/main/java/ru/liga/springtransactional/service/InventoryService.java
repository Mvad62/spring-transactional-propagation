package ru.liga.springtransactional.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.springtransactional.dto.OrderDto;
import ru.liga.springtransactional.exception.InsufficientStockException;
import ru.liga.springtransactional.exception.ProductNotFoundException;
import ru.liga.springtransactional.model.Product;
import ru.liga.springtransactional.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final ProductRepository productRepository;

    @Transactional
    public void reduceStock(OrderDto orderDto) {
        String productName = orderDto.productName();
        Integer orderQuantity = orderDto.quantity();

        Product product = productRepository.findByName(productName)
                .orElseThrow(() -> new ProductNotFoundException("Товар не найден: " + productName));

        if (product.getStock() < orderQuantity) {
            throw new InsufficientStockException(
                    "Недостаточно товара на складе. Требуется: %d, доступно: %d"
                            .formatted(orderQuantity, product.getStock())
            );
        }

        product.setStock(product.getStock() - orderQuantity);
        productRepository.save(product);
    }
}

