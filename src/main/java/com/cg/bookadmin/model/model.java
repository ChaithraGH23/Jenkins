package com.cg.bookadmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_db")

public class model {
	@Column(unique = true)
	@Id
	private long userId;
	private String name;
	private String role;
	private String password;
	public long getUserId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
