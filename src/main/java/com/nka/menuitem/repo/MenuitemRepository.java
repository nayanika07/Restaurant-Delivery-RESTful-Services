package com.nka.menuitem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nka.menuitem.model.Menuitem;


	public interface MenuitemRepository extends JpaRepository<Menuitem, Integer> {

	
		
	}