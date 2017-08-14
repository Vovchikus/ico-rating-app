package com.project.rating.repository;

import com.project.rating.model.Offering;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfferingRepository extends MongoRepository<Offering, String> {
}
