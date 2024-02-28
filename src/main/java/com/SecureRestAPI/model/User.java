package com.SecureRestAPI.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamicInsert
@DynamicUpdate
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	@NotBlank(message = "firstName cannot be null")
	@NotEmpty(message = "firstName cannot be empty")
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "lastname cannot be null")
	private String lastName;

	@Column(name = "U_email")
	@Email(message = "must be a well formed email-address")
	@NotBlank(message = "email cannot be null")
	private String email;

	@Column(name = "u_password")
	@NotBlank(message = "password cannot be null")
	private String password;

	@Column(name = "user_role")
	private String roles;

}
