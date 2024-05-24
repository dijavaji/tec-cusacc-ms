package ec.com.technoloqie.api.account.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ACCOUNTTYPE")
public class AccountType implements Serializable{
	
	private static final long serialVersionUID = 1522323672894905689L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="ACCTYPID",nullable=false, unique=true)
	private Integer id;
	
	@Column(name="NAME",nullable=false, unique=true)
    private String name; 
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="CREATEDBY",nullable=false)
	private String createdBy;
	
	@Column(name="CREATEDDATE",nullable=false)
	@Temporal(TemporalType.DATE)
	private LocalDate createdDate;
	
	@Column(name="MODIFIEDBY")
	private String modifiedBy;
	
	@Column(name="MODIFIEDDATE")
	@Temporal(TemporalType.DATE)
	private LocalDate modifiedDate;
	
	@Column(name="STATUS")
	private Boolean status;
	
	//@JsonManagedReference
	//@OneToMany(fetch = FetchType.LAZY)
	//@JoinColumn(name = "ACCTYPID")
    //private List<Account> accountCol;
}
