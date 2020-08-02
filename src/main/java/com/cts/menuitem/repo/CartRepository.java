package com.cts.menuitem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.menuitem.model.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {

	
	
}
