package com.nka.menuitem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nka.menuitem.model.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {

	
	
}
