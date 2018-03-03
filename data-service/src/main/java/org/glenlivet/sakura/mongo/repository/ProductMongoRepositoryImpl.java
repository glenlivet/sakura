package org.glenlivet.sakura.mongo.repository;

import org.glenlivet.sakura.model.Product;
import org.glenlivet.sakura.model.ProductSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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

    @Override
    public ProductSku findOneSku(Long id) {
        Criteria query = Criteria.where("skus._id").is(id);
        Criteria projection = Criteria.where("skus").elemMatch(Criteria.where("_id").is(id));
        BasicQuery queryAndProject = new BasicQuery(query.getCriteriaObject(), projection.getCriteriaObject());
        Arrays.stream(Product.class.getDeclaredFields())
                .filter(field -> field.getAnnotation(Transient.class) == null)
                .forEach(field -> queryAndProject.fields().include(field.getName()));
        Product product = mongoTemplate.findOne(queryAndProject, Product.class);
        if (product.getSkus() != null && !product.getSkus().isEmpty()) {
            return product.getSkus().get(0);
        }
        return null;
    }
}
