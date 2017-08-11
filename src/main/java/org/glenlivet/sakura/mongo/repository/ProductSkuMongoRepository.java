package org.glenlivet.sakura.mongo.repository;

import org.glenlivet.sakura.mongo.domain.ProductSku;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductSkuMongoRepository extends MongoRepository<ProductSku, Long> {
}
