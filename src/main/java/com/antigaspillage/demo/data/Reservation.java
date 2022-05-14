package com.antigaspillage.demo.data;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@EnableJpaRepositories
public class Reservation {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User user;

	@ManyToOne
	private Trader trader;
	
	@ManyToOne
	private Cart cart;
	
	@Column(nullable = false)
	private Timestamp reservationDate;
	
	@Column(nullable = false)
	private int quantity;
	
	public Reservation() {
		
	}

	public Reservation(User user, Trader trader, Cart cart, Timestamp reservationDate, int quantity) {
		super();
		this.user = user;
		this.trader=trader;
		this.cart = cart;
		this.reservationDate = reservationDate;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Timestamp getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Timestamp reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"id=" + id +
				", user=" + user +
				", trader=" + trader +
				", cart=" + cart +
				", reservationDate=" + reservationDate +
				", quantity=" + quantity +
				'}';
	}
}
