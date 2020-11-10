package com.praktijk3.service;


import java.util.List;



import com.praktijk3.model.team;


public interface teamService {
	
	 public List<team> findAll();
		public team findById(int id);
		public void save(team team);
		public void deleteById(int id);

}
