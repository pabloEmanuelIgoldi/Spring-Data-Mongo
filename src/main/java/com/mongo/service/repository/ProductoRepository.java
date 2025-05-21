package com.mongo.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.entity.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {

}
