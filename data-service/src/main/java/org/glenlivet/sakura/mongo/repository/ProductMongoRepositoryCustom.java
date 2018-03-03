package org.glenlivet.sakura.mongo.repository;

import org.glenlivet.sakura.model.ProductSku;

public interface ProductMongoRepositoryCustom {
    ProductSku addSku(ProductSku productSku);

    ProductSku findOneSku(Long id);
}
