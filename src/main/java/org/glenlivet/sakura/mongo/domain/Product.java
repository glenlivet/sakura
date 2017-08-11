package org.glenlivet.sakura.mongo.domain;

import java.util.List;

public interface Product {

    Long getId();

    String getName();

    String getBrand();

    String getCode();

    String getDescription();

    List<ProductSku> getSkus();
}
