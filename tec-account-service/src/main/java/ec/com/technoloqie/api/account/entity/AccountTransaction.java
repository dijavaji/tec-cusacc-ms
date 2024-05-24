package ec.com.technoloqie.api.account.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="ACCOUNTTRANSACTION")
public class AccountTransaction implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="ACCTRANID",nullable=false, unique=true)
	private Integer id;
	
	@Column(name="BALANCEINIT",nullable=false)
    private Double balanceInit;
	
	@Column(name="BALANCEAVAILABLE",nullable=false)
    private Double balanceAvailable;
	
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
	
	//@Column(name="TRANSACTIONID",nullable=false)
	//private Integer transactionId;
	
	//@Column(name="ACCOUNTID",nullable=false)
	//private Integer accountId;
	
	@ManyToOne
	@JoinColumn(name="ACCOUNTID",nullable=false)
	private Account account;
	
	@ManyToOne
	@JoinColumn(name="TRANSACTIONID",nullable=false)
	private Transaction transaction;
	
	@PrePersist 
	public void prePersist() {
		createdDate = LocalDate.now();
		status = Boolean.TRUE;
	}
	
	private static final long serialVersionUID = 1L;
}
