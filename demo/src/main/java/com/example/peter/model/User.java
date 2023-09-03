package com.example.peter.model;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
	
	@Column(nullable = false)
	@Id
	private String user_id;
	
	@CreationTimestamp
	@Column
	private Timestamp created_at;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String mail_id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Posts> postsList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Comments> commentList;

	@Override
	public String toString() {
		return " password/t"+this.password+"mail_is/t"+this.mail_id+"user_id"+this.user_id;
	}

}
