package com.cts.menuitem.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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

}