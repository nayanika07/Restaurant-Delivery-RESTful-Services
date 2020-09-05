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

import com.nka.menuitem.model.Menuitem;
import com.nka.menuitem.service.MenuitemService;



@RestController
@RequestMapping("/menu-items")
public class MenuitemController {
	
	@Autowired
	private MenuitemService service;
	@GetMapping
	public List<Menuitem> getMenuitems(){
		return service.getMenuitemListCustomer();
	}
	@GetMapping("/{id}")
	public Menuitem getConByCode(@PathVariable int id) {
		return service.getMenuitemById(id);
				
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Menuitem addMenuitem(@Valid @RequestBody Menuitem menuitem) {
		
		return service.addMenuitem(menuitem);
	}
	@DeleteMapping("/{id}")
	public String deleteMenuitem(@PathVariable int id){
		
		return service.deleteMenuitem(id);
	}
	
	@PutMapping("/{id}")
	public String updateMenuitem(@PathVariable int id,@RequestBody Menuitem menuitem) {
		
		return service.updateMenuitem(id, menuitem);
				
	}

	
	
}

