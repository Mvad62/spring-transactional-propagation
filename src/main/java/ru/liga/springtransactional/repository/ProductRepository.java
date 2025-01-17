package ru.liga.springtransactional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.springtransactional.model.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
