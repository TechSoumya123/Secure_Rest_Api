package com.SecureRestAPI.model;

import java.util.UUID;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Entity
@Table(name = "book_table")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long id;

	@Column(name = "title")
	@NotNull(message = "title cannot be null")
	@NotEmpty(message = "title name cannot be empty")
	private String title;

	@Column(name = "author")
	@NotBlank(message = "author cannot be null")
	private String author;

	@Column(name = "edition")
	@NotBlank(message = "edition cannot be null")
	private String edition;

	private UUID isbn = UUID.randomUUID();

}
