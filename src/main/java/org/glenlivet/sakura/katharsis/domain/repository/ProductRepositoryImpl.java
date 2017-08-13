package org.glenlivet.sakura.katharsis.domain.repository;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.exception.ResourceNotFoundException;
import io.katharsis.resource.list.ResourceList;
import org.glenlivet.sakura.katharsis.domain.model.Product;
import org.glenlivet.sakura.mongo.repository.ProductMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepositoryImpl extends ResourceRepositoryBase<Product, Long> {

    @Autowired
    private ProductMongoRepository productRepository;

    @Autowired
    @Qualifier("productIdGenerator")
    private RedisAtomicLong productIdGenerator;

    public ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    public Product save(Product resource) {
        if (resource.getId() == null) {
            //save
            long id = productIdGenerator.getAndIncrement();
            resource.setId(id);
            productRepository.save(resource);
            return resource;
        } else {
            return super.save(resource);
        }
    }

    @Override
    public Product findOne(Long id, QuerySpec querySpec) {

        Product product = productRepository.findOne(id);
        ResourceList<Product> resourceList = querySpec.apply(
                Arrays.asList(product));
        if (resourceList.isEmpty()) {
            throw new ResourceNotFoundException("resource not found");
        } else {
            return resourceList.get(0);
        }
    }

    @Override
    public ResourceList<Product> findAll(QuerySpec querySpec) {
        List<Product> productList = productRepository.findAll();
        return querySpec.apply(productList);
    }
}
