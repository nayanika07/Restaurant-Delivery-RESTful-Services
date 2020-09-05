package com.nka.menuitem.service;

import java.util.List;

import com.nka.menuitem.model.Menuitem;



public interface MenuitemService {
    //List<Menuitem> getMenuitems();
	List<Menuitem> getMenuitemListCustomer();
	Menuitem getMenuitemById(int id);
	Menuitem addMenuitem(Menuitem menuitem);
	String deleteMenuitem(int id);
	String updateMenuitem(int id,Menuitem menuitem);
}