package com.praktijk3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.praktijk3.model.team;
import com.praktijk3.service.teamService;

@Controller
@RequestMapping("team")
public class teamController {

	@Autowired	
	private teamService teamService;
	
	// !!! Constructor injection - @Autowired is optional
	@Autowired
	public teamController(teamService teamService) {
		this.teamService = teamService;
	}



	@GetMapping("/list")
	public String listTeam(Model model) {
		
		//employees from database -> findAll()
		model.addAttribute("team", teamService.findAll());
		
		//return view with list of employees
		return "team/list";
		
	}
	
	@GetMapping("/showFormTeam")
	public String showForm(Model model) {
		
		//add attribute
		model.addAttribute("team", new team());
		
		//return form view
		return "team/save";
		
	}
	
	@PostMapping("/save")
	public String saveTeam(@ModelAttribute("team") team team) {
		
		//save employee
		teamService.save(team);
		//redirect to list
		return "redirect:/team/list";
		
	}
	
	//mapping for buttons with "update", get employee and than return view with employee from db
	@GetMapping("/updateTeam")
	public String updateEmployee(@RequestParam("id") int id, Model model) {
		
		//find employee and add to model
		model.addAttribute("team", teamService.findById(id));
		
		//return view for update
		return "team/save";
	}
	
	//mapping for delete action
	@GetMapping("/deleteTeam")
	public String deleteEmployee(@RequestParam("id") int id) {
		
		//delete from database by id
		teamService.deleteById(id);
		
		//return view for update
		return "redirect:/team/list";
	}
	
	
}
