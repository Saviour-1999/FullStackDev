package com.example.peter.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCreateRequest {
	
	@NotBlank
	private String user_id;
	
	@NotBlank
	@Size(min = 8, max = 12, message = "password length should be between 8-12")
	private String password;
	
	@NotBlank
	@Email
	private String mail_id;
	

}
