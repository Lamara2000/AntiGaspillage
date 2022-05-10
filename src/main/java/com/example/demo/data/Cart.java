package com.example.demo.data;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cart {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private Timestamp date;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private float price;
	
	@Column(nullable = false)
	private int nbCart;
	
	@ManyToOne
	private Trader trader;
	
	@ManyToOne
	private Category category;
	
	public Cart() {
		
	}

	public Cart(Timestamp date, String description, float price, int nbCart, Trader trader, Category category) {
		super();
		this.date = date;
		this.description = description;
		this.price = price;
		this.nbCart = nbCart;
		this.trader = trader;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNbCart() {
		return nbCart;
	}

	public void setNbCart(int nbCart) {
		this.nbCart = nbCart;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
