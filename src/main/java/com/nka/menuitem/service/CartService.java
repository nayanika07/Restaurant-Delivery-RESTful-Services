package com.nka.menuitem.service;

import java.util.List;

import com.nka.menuitem.model.Cart;


public interface CartService {
	
	Cart getAllCartItems(String user_id);

	String addCartitem(String user_id, int menuitem_id);
	String deleteCartitem(String user_id, int menuitem_id);
}
