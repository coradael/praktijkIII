package com.praktijk3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praktijk3.model.team;
import com.praktijk3.repository.teamRepository;

@Service("teamService")
public class teamServiceImpl implements teamService{
	
	private teamRepository teamRepo;
	
	@Autowired
	public teamServiceImpl(teamRepository teamRepository) {
		this.teamRepo = teamRepository;
	}


	@Override
	public List<team> findAll() {
		return teamRepo.findAllByOrderByNameAsc(); //method from repo
	}

	@Override
	public team findById(int id) {
		//try to find:
		Optional<team> result = teamRepo.findById(id);
		//found:
		if(result.isPresent()) return result.get();
		//not found:
		throw new RuntimeException("Employee with id: " + id + "does'nt exist");
	}

	@Override
	public void save(team team) {
		teamRepo.save(team);
	}

	@Override
	public void deleteById(int id) {
		teamRepo.deleteById(id);
	}


}
