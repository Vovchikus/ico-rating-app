package com.project.rating.service;

import com.project.rating.model.Offering;
import com.project.rating.repository.OfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoOfferingService implements OfferingService {

    private final OfferingRepository repository;

    @Autowired
    public MongoOfferingService(OfferingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Offering offering) {
        this.repository.save(offering);
    }
}
