package com.nka.menuitem.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Menuitem")
public class Menuitem {
   
	@Id
	@NotNull
    private int id;
	
	private String name;
	private float price;
	private boolean active;
    @DateTimeFormat (pattern = "dd-MM-yyyy")
    private LocalDate dateoflaunch;
    private String category;
    private boolean freedelivery;
    
    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
    	    name="usercart",
    	    		joinColumns = { @JoinColumn(name="menuitem_id")},
    	    		inverseJoinColumns = { @JoinColumn(name="user_id")})
                 private List<Cart> cart = new ArrayList<Cart>();

}