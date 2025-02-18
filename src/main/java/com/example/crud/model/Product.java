package com.example.crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Product")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private  Double price;
	private  Integer quantity;

}
