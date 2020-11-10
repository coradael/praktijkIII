package com.praktijk3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.praktijk3.model.Employee;
import com.praktijk3.service.EmployeeService;


@Controller
@RequestMapping("employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// !!! Constructor injection - @Autowired is optional
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}



	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		//employees from database -> findAll()
		model.addAttribute("employees", employeeService.findAll());
		
		//return view with list of employees
		return "employees/list";
		
	}
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		
		//add attribute
		model.addAttribute("employee", new Employee());
		
		//return form view
		return "employees/save";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		//save employee
		employeeService.save(employee);
		//redirect to list
		return "redirect:/employees/list";
		
	}
	
	//mapping for buttons with "update", get employee and than return view with employee from db
	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("id") int id, Model model) {
		
		//find employee and add to model
		model.addAttribute("employee", employeeService.findById(id));
		
		//return view for update
		return "employees/save";
	}
	
	//mapping for delete action
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") int id) {
		
		//delete from database by id
		employeeService.deleteById(id);
		
		//return view for update
		return "redirect:/employees/list";
	}
	
	
	
}
