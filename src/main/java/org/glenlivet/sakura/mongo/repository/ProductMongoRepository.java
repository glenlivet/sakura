package org.glenlivet.sakura.mongo.repository;

import org.glenlivet.sakura.katharsis.domain.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends MongoRepository<Product, Long>, ProductMongoRepositoryCustom {

}
