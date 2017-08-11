package org.glenlivet.sakura.katharsis.domain.model;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.JsonApiToOne;

import java.util.Map;

@JsonApiResource(type = "product-skus")
public class ProductSku {

    @JsonApiId
    private Long id;

    private Map<String, String> attrs;

    @JsonApiToOne(opposite = "skus")
    private Product product;

    public ProductSku() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, String> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, String> attrs) {
        this.attrs = attrs;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
