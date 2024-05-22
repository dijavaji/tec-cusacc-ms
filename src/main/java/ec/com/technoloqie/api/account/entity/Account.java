package ec.com.technoloqie.api.account.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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
@Table(name="ACCOUNT")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="ACCOUNTID",nullable=false, unique=true)
	private Integer id;
	
	@Column(name="ACCNUMBER",nullable=false, unique=true)
    private Integer accNumber; 
	
	@Column(name="BALANCE",nullable=false)
	private Double balance;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="CREATEDBY",nullable=false)
	private String createdBy;
	
	@Column(name="CREATEDDATE",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="MODIFIEDBY")
	private String modifiedBy;
	
	@Column(name="MODIFIEDDATE")
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;
	
	@Column(name="STATUS")
	private Boolean status;
	
	/*@ManyToOne
	@JoinColumn(name="ACCTYPID",nullable=false)
	private AccountType accountType;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMERID",nullable=false)
	private Customer customer;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNTID")
	private Collection<AccountTransaction> accTranCol;*/
	
	@PrePersist 
	public void prePersist() {
		createdDate = new Date();
		status = Boolean.TRUE;
	}

}
