package ec.com.technoloqie.api.customer.mapper;

import ec.com.technoloqie.api.customer.dto.CustomerDto;
import ec.com.technoloqie.api.customer.entity.Customer;

public class CustomerMapper {
	
	public static Customer mapToCustomer(CustomerDto customerDto) {
		return new Customer();
	}
	
	public static CustomerDto mapToCustomerDto(Customer customer) {
		return new CustomerDto();
	}
}
