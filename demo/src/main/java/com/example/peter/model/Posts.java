package com.example.peter.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Posts {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column
	private String post_id;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column
	private String content;
	
	@ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", nullable = true)
	protected User user;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comments> commentList;

}