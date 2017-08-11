package org.glenlivet.sakura.mongo.repository;

import org.glenlivet.sakura.mongo.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends MongoRepository<Product, Long> {

}
