package com.sam.fullcrud.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="travel")
public class Travel {

	
//	Member vars
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull
	    @Size(min = 2, max = 200)
	    private String expense;

	    @NotNull
	    @Size(min = 2, max = 200)
	    private String vendor;
	    
	    @NotNull
	    @Min(1)
	    private Integer amount;
	    
	    @NotNull
	    @Size(min = 4, max = 40)
	    private String description;
	    
	    
	    // This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
//	    CONSTRUCTORS-----------
//	    ALWAYS EMPTY
	    public Travel() {
//	    	OVERLOADING CONSTRUCTOR FOR API
	    }
	    public Travel(String expense, String vendor, int amount, String description) {
	        this.expense = expense;
	        this.vendor = vendor;
	        this.amount = amount;
	        this.description = description;
	    }
	    
	    
	    // ALL GETTERS AND SETTERS
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getExpense() {
			return expense;
		}
		public void setExpense(String expense) {
			this.expense = expense;
		}
		public String getVendor() {
			return vendor;
		}
		public void setVendor(String vendor) {
			this.vendor = vendor;
		}
		public Integer getAmount() {
			return amount;
		}
		public void setAmount(Integer amount) {
			this.amount = amount;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	    
	    
	    
	    
	    
}
