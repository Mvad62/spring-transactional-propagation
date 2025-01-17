package ru.liga.springtransactional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.springtransactional.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
