package com.national.guarantee.guarantee.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.national.guarantee.guarantee.entities.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product extends ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer codeProduct;
	private String nameProduct;
	private String refProduct;
	private Double priceProduct;

	@ManyToMany
	@JoinTable(name = "tb_product_supplier", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
	private Set<Supplier> suppliers = new HashSet<>();

	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();

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

	public Set<Supplier> getSuppliers() {
		return suppliers;
	}

	public Set<Order> getOrders() {
		Set<Order> set = new HashSet<>();
		for (OrderItem x : items) {
			set.add(x.getOrder());
		}
		return set;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, items, priceProduct);
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
		return Objects.equals(id, other.id) && Objects.equals(items, other.items)
				&& Objects.equals(priceProduct, other.priceProduct);
	}

}
