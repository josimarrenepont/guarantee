package com.national.guarantee.guarantee.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_branch")
public class Branch implements Serializable{

	private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long id;
		private Integer numberBranch;
		private Integer codeProduct;
		private Integer quantityProduct;
		private Date date;
		private Integer sac;
		private String technicalAnalysis;
		
		
		public Branch() {
		}

		public Branch(Long id, Integer numberBranch, Integer codeProduct, Integer quantityProduct, Date date, Integer sac,
				String technicalAnalysis) {
			super();
			this.id = id;
			this.numberBranch = numberBranch;
			this.codeProduct = codeProduct;
			this.quantityProduct = quantityProduct;
			this.date = date;
			this.sac = sac;
			this.technicalAnalysis = technicalAnalysis;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Integer getNumberBranch() {
			return numberBranch;
		}

		public void setNumberBranch(Integer numberBranch) {
			this.numberBranch = numberBranch;
		}

		public Integer getCodeProduct() {
			return codeProduct;
		}

		public void setCodeProduct(Integer codeProduct) {
			this.codeProduct = codeProduct;
		}

		public Integer getQuantity() {
			return quantityProduct;
		}

		public void setQuantity(Integer quantity) {
			this.quantityProduct = quantity;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Integer getSac() {
			return sac;
		}

		public void setSac(Integer sac) {
			this.sac = sac;
		}

		public String getTechnicalAnalysis() {
			return technicalAnalysis;
		}

		public void setTechnicalAnalysis(String technicalAnalysis) {
			this.technicalAnalysis = technicalAnalysis;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Branch other = (Branch) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
	}
