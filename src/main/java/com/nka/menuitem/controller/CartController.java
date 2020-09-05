package com.nka.menuitem.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nka.menuitem.model.Cart;
import com.nka.menuitem.model.Menuitem;
import com.nka.menuitem.service.CartService;
import com.nka.menuitem.service.MenuitemService;



@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService service;
	
	
//	@GetMapping
//	public List<Cart> getCartitems(){
//		return service.getAllCartItems();
//	}
	@GetMapping("/{userid}")
	public Cart getAllCartItems(@PathVariable String userid) {
		return service.getAllCartItems(userid);
				
	}
	@PostMapping("/{userid}/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public String addCartitem(@PathVariable String userid, @PathVariable int id) {
		
		return service.addCartitem(userid,id);
	}
	@DeleteMapping("/{userid}/{id}")
	public String deleteCartitem(@PathVariable String userid, @PathVariable int id){
		
		return service.deleteCartitem(userid,id);
	}
	
//	@PutMapping("/{id}")
//	public String updateMenuitem(@PathVariable int id,@RequestBody Menuitem menuitem) {
//		
//		return service.updateMenuitem(id, menuitem);
//				
//}

	
	
}

