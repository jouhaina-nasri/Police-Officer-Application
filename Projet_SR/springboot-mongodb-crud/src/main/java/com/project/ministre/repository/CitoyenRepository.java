package com.project.ministre.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.ministre.model.Citoyen;

@Repository
public interface CitoyenRepository extends MongoRepository<Citoyen, Long>{

}