package ec.com.technoloqie.api.customer.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	
	private Integer id;
	private String pass;
	private String createdBy;
	private LocalDate createdDate;
	private String modifiedBy;
	private LocalDate modifiedDate;
	private Boolean status;

}
