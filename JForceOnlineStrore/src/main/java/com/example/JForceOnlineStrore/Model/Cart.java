package com.example.JForceOnlineStrore.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cart")
@Data
public class Cart {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@ManyToOne
	@JoinColumn(name = "userid")
	public User userid;

	@ManyToOne
	@JoinColumn(name = "productid")
	public Product productid;

	@Column(name = "cartororder")
	public String cartororder;

}
