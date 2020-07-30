package com.cts.menuitem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.menuitem.model.Menuitem;


	public interface MenuitemRepository extends JpaRepository<Menuitem, Integer> {

	
		
	}