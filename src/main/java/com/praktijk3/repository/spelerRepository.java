package com.praktijk3.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.transaction.annotation.Transactional;

import com.praktijk3.model.speler;


public interface spelerRepository extends CrudRepository <speler, Integer> {
	
	speler findByname(String name);
	

}
