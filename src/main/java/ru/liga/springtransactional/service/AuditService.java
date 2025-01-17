package ru.liga.springtransactional.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.springtransactional.model.Audit;
import ru.liga.springtransactional.repository.AuditRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final AuditRepository auditRepository;

    @Transactional
    public void log(String action, String details) {
        Audit audit = new Audit();
        audit.setAction(action);
        audit.setDetails(details);
        audit.setCreatedAt(LocalDateTime.now());
        auditRepository.save(audit);
    }
}
