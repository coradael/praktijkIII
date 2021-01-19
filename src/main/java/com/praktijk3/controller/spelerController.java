package com.praktijk3.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.praktijk3.model.apiResponse;
import com.praktijk3.model.speler;

import com.praktijk3.payload.spelerResponse;
import com.praktijk3.service.spelerService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/speler")
public class spelerController {
	
	
	    @Autowired
	    private spelerService spelerService;

	    @PostMapping
	    public apiResponse<speler> saveUser(@RequestBody spelerResponse speler
	    		){
	        return new apiResponse<>(HttpStatus.OK.value(), "User saved successfully.",spelerService.save(speler));
	    }

	    @GetMapping
	    public apiResponse<List<speler>> listSpeler(){
	        return new apiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",spelerService.findAll());
	    }

	    @GetMapping("/{id}")
	    public apiResponse<speler> getOne(@PathVariable int id){
	        return new apiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",spelerService.findById(id));
	    }

	    @PutMapping("/{id}")
	    public apiResponse<spelerResponse> update(@RequestBody spelerResponse spelerResponse) {
	        return new apiResponse<>(HttpStatus.OK.value(), "User updated successfully.",spelerService.update(spelerResponse));
	    }

	    @DeleteMapping("/{id}")
	    public apiResponse<Void> delete(@PathVariable int id) {
	        spelerService.delete(id);
	        return new apiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
	    }
	    
	}



