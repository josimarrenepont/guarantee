package com.national.guarantee.guarantee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
		private Integer quantity;
		private Date date;
		private Integer sac;
		private String technicalAnalysis;
		
		public Branch() {
		}

		public Branch(Long id, Integer numberBranch, Integer codeProduct, Integer quantity, Date date, Integer sac,
				String technicalAnalysis) {
			super();
			this.id = id;
			this.numberBranch = numberBranch;
			this.codeProduct = codeProduct;
			this.quantity = quantity;
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
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
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
			return Objects.hash(id, numberBranch);
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
			return Objects.equals(id, other.id) && Objects.equals(numberBranch, other.numberBranch);
		}


		
}
