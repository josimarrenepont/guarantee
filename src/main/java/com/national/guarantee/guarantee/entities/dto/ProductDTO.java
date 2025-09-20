package com.national.guarantee.guarantee.entities.dto;

import com.national.guarantee.guarantee.entities.Product;
import java.io.Serializable;
import java.util.Objects;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer codeProduct;
    private String nameProduct;
    private String refProduct;
    private Double priceProduct;

    public ProductDTO() {
    }

    public ProductDTO(Long id, Integer codeProduct, String nameProduct, String refProduct, Double priceProduct) {
        this.id = id;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.refProduct = refProduct;
        this.priceProduct = priceProduct;
    }

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.codeProduct = entity.getCodeProduct();
        this.nameProduct = entity.getNameProduct();
        this.refProduct = entity.getRefProduct();
        this.priceProduct = entity.getPriceProduct();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(Integer codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getRefProduct() {
        return refProduct;
    }

    public void setRefProduct(String refProduct) {
        this.refProduct = refProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProductDTO other = (ProductDTO) obj;
        return Objects.equals(id, other.id);
    }
}