package com.national.guarantee.guarantee.services;

import java.util.Objects;

import com.national.guarantee.guarantee.entities.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_suppliers")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codeSupplier;
	private String nameSupplier;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "tb_product_id")
	private Product product;
	
	public Supplier() {
	}
	
	public Supplier(Long id, String codeSupplier, String nameSupplier, String email) {
		super();
		this.id = id;
		this.codeSupplier = codeSupplier;
		this.nameSupplier = nameSupplier;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodeSupplier() {
		return codeSupplier;
	}
	public void setCodeSupplier(String codeSupplier) {
		this.codeSupplier = codeSupplier;
	}
	public String getNameSupplier() {
		return nameSupplier;
	}
	public void setNameSupplier(String nameSupplier) {
		this.nameSupplier = nameSupplier;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codeSupplier, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		return Objects.equals(codeSupplier, other.codeSupplier) && Objects.equals(id, other.id);
	}

	
}
