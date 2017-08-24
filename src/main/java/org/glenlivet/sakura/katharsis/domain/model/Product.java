package org.glenlivet.sakura.katharsis.domain.model;

import io.katharsis.resource.annotations.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

@JsonApiResource(type="products")
public class Product implements KatharsisModel {

    @JsonApiId
    @Id
    private Long id;

    private String name;

    private String brand;

    private String code;

    private String description;

    @JsonApiToOne
    @Transient
    private ProductSku defaultSku;

    @JsonApiToMany(opposite = "product")
    private List<ProductSku> skus = new ArrayList<>();

    public Product() {
    }

    public Product(Long id, String name, String brand, String code, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductSku getDefaultSku() {
        return defaultSku;
    }

    public void setDefaultSku(ProductSku defaultSku) {
        this.defaultSku = defaultSku;
    }

    public List<ProductSku> getSkus() {
        return skus;
    }

    public void setSkus(List<ProductSku> skus) {
        this.skus = skus;
    }
}
