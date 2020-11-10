package com.praktijk3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praktijk3.model.team;


@Repository("teamRepository")
public interface teamRepository extends JpaRepository<team, Integer>{
	
	//add method to sort by last name
		public List<team> findAllByOrderByNameAsc();

}
