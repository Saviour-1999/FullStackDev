package com.example.peter.dto;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentRequest {
	@NotBlank
	private String comment_value;
	
	@NotBlank
	private String user_id;
	
	@NotBlank
	private String post_id;

}
