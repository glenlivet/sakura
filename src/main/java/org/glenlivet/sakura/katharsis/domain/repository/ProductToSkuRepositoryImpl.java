package org.glenlivet.sakura.katharsis.domain.repository;

import io.katharsis.repository.RelationshipRepositoryBase;
import org.glenlivet.sakura.katharsis.domain.model.Product;
import org.glenlivet.sakura.katharsis.domain.model.ProductSku;
import org.springframework.stereotype.Component;

@Component
public class ProductToSkuRepositoryImpl extends RelationshipRepositoryBase<Product, Long, ProductSku, Long> {

    public ProductToSkuRepositoryImpl() {
        super(Product.class, ProductSku.class);
    }
}
