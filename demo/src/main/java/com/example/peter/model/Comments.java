package com.example.peter.model;

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="comments")
public class Comments {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column
	private String comment_id;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column
	private String comment_value;
	
	@ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", nullable = false)
	protected User user;
	
	@ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="post_id",nullable = false)
	protected Posts post;

}