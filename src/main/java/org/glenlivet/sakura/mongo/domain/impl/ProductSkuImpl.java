package org.glenlivet.sakura.mongo.domain.impl;

import org.glenlivet.sakura.mongo.domain.Money;
import org.glenlivet.sakura.mongo.domain.ProductSku;
import org.springframework.data.annotation.Id;

import java.util.Map;

public class ProductSkuImpl implements ProductSku {

    @Id
    private String id;

    private Money basePrice;

    private Map<String, String> attributes;

    public ProductSkuImpl(String id, Money basePrice, Map<String, String> attributes) {
        this.id = id;
        this.basePrice = basePrice;
        this.attributes = attributes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBasePrice(Money basePrice) {
        this.basePrice = basePrice;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Money getBasePrice() {
        return basePrice;
    }

    @Override
    public Map<String, String> getAttributes() {
        return attributes;
    }
}
