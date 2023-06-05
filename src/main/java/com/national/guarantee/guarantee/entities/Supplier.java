package com.national.guarantee.guarantee.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_supplier")
public class Supplier implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codeSupplier;
	private String nameSupplier;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "tb_product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "tb_branch_id")
	private Branch branch;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "supplier")
	private Set<Product> products = new HashSet<>();
	
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
	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branch, id, nameSupplier, product);
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
		return Objects.equals(branch, other.branch) && Objects.equals(id, other.id)
				&& Objects.equals(nameSupplier, other.nameSupplier) && Objects.equals(product, other.product);
	}

	@Override
	public String toString() {
		return nameSupplier + email + product +
				branch + getCodeSupplier() + getNameSupplier()
				+ getEmail() + getProduct() + getBranch();
	}
	


	
}
