package org.glenlivet.sakura.mongo.repository;

import org.glenlivet.sakura.katharsis.domain.model.ProductSku;

public interface ProductMongoRepositoryCustom {
    ProductSku addSku(ProductSku productSku);
}
