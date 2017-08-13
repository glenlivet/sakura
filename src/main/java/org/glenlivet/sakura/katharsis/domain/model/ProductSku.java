package org.glenlivet.sakura.katharsis.domain.model;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.JsonApiToOne;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.Map;

@JsonApiResource(type = "product-skus")
public class ProductSku {

    @JsonApiId
    @Id
    private Long id;

    private Map<String, String> attrs;

    private Money price;

    @JsonApiToOne(opposite = "skus")
    @Transient
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

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}
