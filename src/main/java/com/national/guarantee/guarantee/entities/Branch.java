package com.national.guarantee.guarantee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Branch implements Serializable{

	private static final long serialVersionUID = 1L;
		private Integer numberBranch;
		private Integer codeProduct;
		private Integer quantity;
		private Date date;
		private String sac;
		private String technicalAnalysis;
		
		public Branch() {
		}

		public Branch(Integer numberBranch, Integer codeProduct, Integer quantity, Date date, String sac,
				String technicalAnalysis) {
			super();
			this.numberBranch = numberBranch;
			this.codeProduct = codeProduct;
			this.quantity = quantity;
			this.date = date;
			this.sac = sac;
			this.technicalAnalysis = technicalAnalysis;
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

		public String getSac() {
			return sac;
		}

		public void setSac(String sac) {
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
			return Objects.hash(codeProduct, numberBranch, sac);
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
			return Objects.equals(codeProduct, other.codeProduct) && Objects.equals(numberBranch, other.numberBranch)
					&& Objects.equals(sac, other.sac);
		}
		
}
