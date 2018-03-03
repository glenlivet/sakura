package org.glenlivet.sakura.katharsis.domain.repository;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;
import org.glenlivet.sakura.model.ProductSku;
import org.glenlivet.sakura.mongo.repository.ProductMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductSkuRepositoryImpl extends ResourceRepositoryBase<ProductSku, Long> {

    @Autowired
    private ProductMongoRepository productMongoRepository;

    public ProductSkuRepositoryImpl() {
        super(ProductSku.class);
    }

    @Override
    public ProductSku save(ProductSku resource) {
        if (resource.getId() == null) {
            return productMongoRepository.addSku(resource);
        } else {
            throw new UnsupportedOperationException("Update ProductSku is not supported right now.");
        }
    }

    @Override
    public ProductSku findOne(Long id, QuerySpec querySpec) {
        return productMongoRepository.findOneSku(id);
    }

    @Override
    public ResourceList<ProductSku> findAll(QuerySpec querySpec) {
        return null;
    }
}
