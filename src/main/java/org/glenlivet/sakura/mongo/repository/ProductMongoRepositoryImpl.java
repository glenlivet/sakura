package org.glenlivet.sakura.mongo.repository;

import org.glenlivet.sakura.katharsis.domain.model.Product;
import org.glenlivet.sakura.katharsis.domain.model.ProductSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class ProductMongoRepositoryImpl implements ProductMongoRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    @Qualifier("skuIdGenerator")
    private RedisAtomicLong skuIdGenerator;

    @Override
    public ProductSku addSku(ProductSku productSku) {
        if (productSku.getId() != null) {
            throw new IllegalArgumentException("Cannot adding an existing SKU to DB again.");
        }
        productSku.setId(skuIdGenerator.incrementAndGet());
        Query findProductById = new Query(where("_id").is(productSku.getProduct().getId()));
        Update update = new Update().addToSet("skus", productSku);
        mongoTemplate.findAndModify(findProductById, update, Product.class);
        return productSku;
    }
}
