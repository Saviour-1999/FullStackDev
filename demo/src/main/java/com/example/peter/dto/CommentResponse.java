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
public class CommentResponse {
	private String comment_id;
	private Timestamp createdAt;
	private String user_id;
	private String comment_value;
	private String post_id;

	@Override
	public String toString() {
		return "id/t"+this.comment_id+"user_id/t"+this.user_id+"post_id/t"+this.comment_id +"comment"+this.comment_value;
	}
	

}
