package ec.com.technoloqie.api.account.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor	
public class TransactionDto {
	
	private Integer id;
	private Double amount;
	private Integer accNumber;  
	private Integer accountType;
	private Double balanceInit;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;
	private Boolean status;
	
}
