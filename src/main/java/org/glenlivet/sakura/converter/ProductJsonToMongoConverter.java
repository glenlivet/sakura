package org.glenlivet.sakura.converter;

import org.glenlivet.sakura.katharsis.domain.model.Product;
import org.glenlivet.sakura.mongo.domain.impl.ProductImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class ProductJsonToMongoConverter implements Converter<Product, org.glenlivet.sakura.mongo.domain.Product> {

    @Override
    public org.glenlivet.sakura.mongo.domain.Product convert(Product product) {
        org.glenlivet.sakura.mongo.domain.Product retVal = new ProductImpl(product.getId(),
                product.getName(), product.getBrand(), product.getCode(), product.getDescription());
        return retVal;
    }
}
