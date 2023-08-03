package com.example.spring6r2dbc.mappers;

import com.example.spring6r2dbc.domain.Customer;
import com.example.spring6r2dbc.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}
