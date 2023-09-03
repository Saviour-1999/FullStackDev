package com.example.peter.dto;

import java.sql.Timestamp;

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
public class PostResponse {
	private String post_id;
	private String user_id;
	private String content;
	private Timestamp createdAt;

	@Override
	public String toString() {
		return "id/t"+this.post_id+"user_id/t"+this.user_id+"content"+this.content;
	}
	

}
