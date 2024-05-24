package ec.com.technoloqie.api.account.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	
	private Integer id;
	
    private Integer accNumber; 
	
	private Double balance;
	
	private String createdBy;
	
	private LocalDate createdDate;
	
	private String modifiedBy;
	
	private LocalDate modifiedDate;
	
	private Boolean status;
	
	private Integer customerId;
}
