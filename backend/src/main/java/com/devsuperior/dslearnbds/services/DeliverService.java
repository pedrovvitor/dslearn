package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.dto.DeliverRevisionDTO;
import com.devsuperior.dslearnbds.entities.Deliver;
import com.devsuperior.dslearnbds.repositories.DeliverRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliverService {

    final DeliverRepository repository;

    public DeliverService(DeliverRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void saveRevision(Long deliverId, DeliverRevisionDTO dto) {
        Deliver deliver = repository.getOne(deliverId);
        deliver.setStatus(dto.getStatus());
        deliver.setFeedback(dto.getFeedback());
        deliver.setCorrectCount(dto.getCorrectCount());
        repository.save(deliver);
    }
}
