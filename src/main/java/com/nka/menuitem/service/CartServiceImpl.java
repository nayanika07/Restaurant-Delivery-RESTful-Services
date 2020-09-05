package com.nka.menuitem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nka.menuitem.exception.CartException;
import com.nka.menuitem.exception.MenuitemException;
import com.nka.menuitem.model.Cart;
import com.nka.menuitem.model.Menuitem;
import com.nka.menuitem.repo.CartRepository;
import com.nka.menuitem.repo.MenuitemRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository repository;
	@Autowired
	private MenuitemRepository repo;
	
	@Override
	public Cart getAllCartItems(String userid) {
		Cart cart = repository.findById(userid).get();
		if(cart==null) {
			throw new CartException("User with user id "+userid+" does not exist");
		}
		if (cart.getCartitems().isEmpty()) {
			throw new CartException("Cart is empty");
		
		}
		return cart;
	}
	
	@Override
	public String addCartitem(String userid, int id) {
		Optional<Cart> op_cart = repository.findById(userid);
		Optional<Menuitem> op_menu = repo.findById(id);
		
		if(!op_cart.isPresent()) {
			throw new CartException("User with user id "+userid+" does not exist");}
		if(!op_menu.isPresent()) {
			throw new MenuitemException("Menu Item with id "+id+" does not exist");
		}
		int count=0;
		List<Menuitem> menu = op_cart.get().getCartitems();
		for(Menuitem mn : menu)
		{
			if(mn.getId()==id) {
				count++;
				break;
			}
		}
		if(count>0) {
			throw new MenuitemException("Menu item with id "+id+" is already present in the cart");
		}
		Cart new_cart = op_cart.get();
		Menuitem mn =op_menu.get();
		new_cart.getCartitems().add(op_menu.get());
		mn.getCart().add(new_cart);
		repository.save(new_cart);
		return "item with id "+id+" is added to cart successfully.";
	}
	
	@Override
	public String deleteCartitem(String userid, int id) {
		Optional<Cart> op_cart = repository.findById(userid);
		Optional<Menuitem> op_menu = repo.findById(id);
		
		if(!op_cart.isPresent()) {
			throw new CartException("User with user id "+userid+" does not exist");}
		
		int count = 0;
		List <Menuitem> menu = op_cart.get().getCartitems();
		
		for(Menuitem mn: menu) {
			if(mn.getId()==id) {
				count++;
				break;
			}
		}
		if(count==0) {
			throw new MenuitemException("Menu item with id"+id+" is not present in the cart");
		}
		Cart new_cart = op_cart.get();
		Menuitem mn = op_menu.get();
		new_cart.getCartitems().remove(op_menu.get());
		mn.getCart().remove(new_cart);
		repository.save(new_cart);
		return("Item with id "+id+" is removed from cart successfully.");
		
	}
}
