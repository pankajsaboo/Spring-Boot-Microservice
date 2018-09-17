package com.customer.dto;

import lombok.Data;

@Data
public class CustomerDto {
	private Long id;

	private String name;

	private String firstname;

	private String email;

	private String street;

	private String city;
}
