package com.example.peter.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
	private String user_id;
	private String mail_id;

	@Override
	public String toString() {
		return "mail_is/t"+this.mail_id+"user_id"+this.user_id;
	}
	

}
