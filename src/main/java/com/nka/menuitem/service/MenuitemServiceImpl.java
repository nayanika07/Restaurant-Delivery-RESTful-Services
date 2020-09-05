package com.nka.menuitem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nka.menuitem.exception.MenuitemException;
import com.nka.menuitem.model.Menuitem;
import com.nka.menuitem.repo.MenuitemRepository;

@Service
public class MenuitemServiceImpl implements MenuitemService{

	@Autowired
	private MenuitemRepository repo;
	
	@Override
	public List<Menuitem> getMenuitemListCustomer() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Menuitem getMenuitemById( int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).
				orElseThrow(()->new MenuitemException("Menuitem with the id "+id+" does not exist"));
	}

	@Override
	public Menuitem addMenuitem(Menuitem menuitem) {
		Optional<Menuitem> op=repo.findById(menuitem.getId());
		if(op.isPresent()) {
			throw new MenuitemException("Menuitem with the id "+menuitem.getId()+" already exist");
		}
		repo.save(menuitem);
		return menuitem;
	}

	@Override
	public String deleteMenuitem(int id) {
		Optional<Menuitem> menuOpt=repo.findById(id);
		if(!menuOpt.isPresent()) {
			throw new MenuitemException("Menuitem with the id "+id+" does not exist");
		}
		repo.deleteById(id);
		return "Menuitem with the Id "+id+" deleted successfully";
	}

	@Override
	public String updateMenuitem(int id, Menuitem menuitem) {
		Optional<Menuitem> op=repo.findById(id);
		if(!op.isPresent()) {
			throw new MenuitemException("Menuitem with the id "+id+" does not exist");
		}
		Menuitem men = op.get();
		if(menuitem.getName()!=null) {
			
			men.setName(menuitem.getName());
		}
		if(menuitem.getPrice()!=0.0) {
			men.setPrice(menuitem.getPrice());
		}
		if(menuitem.isActive()!=false) {
			men.setActive(menuitem.isActive());
		}
        if(menuitem.getDateoflaunch()!=null) {
			
			men.setDateoflaunch(menuitem.getDateoflaunch());
		}
	   if(menuitem.getCategory()!=null) {
			
			men.setCategory(menuitem.getCategory());
		}
	   if(menuitem.isFreedelivery()!=false) {
			
				men.setFreedelivery(menuitem.isFreedelivery());
			}
		repo.save(men);
		return "Menuitem with the id "+id+" updated successfully";
	}



}

