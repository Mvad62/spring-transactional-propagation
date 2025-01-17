package ru.liga.springtransactional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.springtransactional.model.Audit;

public interface AuditRepository extends JpaRepository<Audit, Long> {
}
