package com.example.peter.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostCreateRequest {
	@NotBlank
	private String content;
	
	@NotBlank
	private String user_id;

}
