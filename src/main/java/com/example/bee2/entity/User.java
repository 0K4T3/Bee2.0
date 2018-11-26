package com.example.bee2.entity;


import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NodeEntity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Long age;
	private String email;
	private String password;
	private String location;
	private Long failed;
	private boolean lockout;
	private boolean enabled;
	private String role;

	@Relationship(type="FOLLOW", direction=Relationship.OUTGOING)
	private Set<User> following = new HashSet<>();

	public User(String name, Long age, String email, String password, String location) {
		setName(name);
		setAge(age);
		setEmail(email);
		setPassword(password);
		setLocation(location);
		setFailed(0L);
		setLockout(false);
		setEnabled(true);
		setRole(role);
	}
}
