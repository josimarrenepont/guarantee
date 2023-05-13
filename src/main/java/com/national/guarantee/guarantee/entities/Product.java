package com.national.guarantee.guarantee.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer codeProduct;
	private String nameProduct;
	private String refProduct;
	private Double priceProduct;
	
	
	public Product() {
	}

	public Product(Long id, Integer codeProduct, String nameProduct, String refProduct, Double priceProduct) {
		super();
		this.id = id;
		this.codeProduct = codeProduct;
		this.nameProduct = nameProduct;
		this.refProduct = refProduct;
		this.priceProduct = priceProduct;
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
		return Objects.hash(codeProduct, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(codeProduct, other.codeProduct) && Objects.equals(id, other.id);
	}
	
	
}
