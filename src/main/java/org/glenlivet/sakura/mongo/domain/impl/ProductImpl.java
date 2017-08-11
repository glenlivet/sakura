package org.glenlivet.sakura.mongo.domain.impl;

import org.glenlivet.sakura.mongo.domain.Product;
import org.glenlivet.sakura.mongo.domain.ProductSku;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements Product {

    @Id
    private Long id;

    private String name;

    private String brand;

    private String code;

    private String description;

    private List<ProductSku> skus;

    public ProductImpl() {
        this.skus = new ArrayList<>();
    }

    public ProductImpl(Long id, String name, String brand, String code, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.code = code;
        this.description = description;
        this.skus = new ArrayList<>();
    }

    public ProductImpl(Long id, String name, String brand, String code, String description, List<ProductSku> skus) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.code = code;
        this.description = description;
        this.skus = skus;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
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

    public List<ProductSku> getSkus() {
        return skus;
    }

    public void setSkus(List<ProductSku> skus) {
        this.skus = skus;
    }
}
