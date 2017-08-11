package org.glenlivet.sakura.converter;

import org.glenlivet.sakura.mongo.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class ProductMongoToJsonConverter implements Converter<Product, org.glenlivet.sakura.katharsis.domain.model.Product> {
    @Override
    public org.glenlivet.sakura.katharsis.domain.model.Product convert(Product product) {
        org.glenlivet.sakura.katharsis.domain.model.Product retVal = new org.glenlivet.sakura.katharsis.domain.model.Product();
        retVal.setId(product.getId());
        retVal.setBrand(product.getBrand());
        retVal.setCode(product.getCode());
        retVal.setDescription(product.getDescription());
        retVal.setName(product.getName());
        //TODO
        //SET SKU
        return retVal;
    }
}
