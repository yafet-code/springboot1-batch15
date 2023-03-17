package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.dto.EmployeeDTO;
import com.main.services.EmployeeService;

@RestController

public class EmployeeRestcontroller {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")// localhost:8080/employees   >>> end point 
	List<EmployeeDTO> findAll(Model model){
		
		List<EmployeeDTO> listOfEmployeeDTO= employeeService.findAllEmp();
		
		
		
		return listOfEmployeeDTO;
		
		
		
	}
	
	
	
	@GetMapping("/employees/{employeeId}")// localhost:8080/employees   >>> end point 
	ResponseEntity<EmployeeDTO> findAll(@PathVariable int employeeId){
		
		EmployeeDTO employeeDTO=  employeeService.findEmp(employeeId);
		
		return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
	}
	
	
	
	
	

	@PostMapping("/employees")// localhost:8080/employees/1   >>> end point 

	ResponseEntity<String> registration(@RequestBody EmployeeDTO employeeDTO){
		
		employeeService.saveEmployee(employeeDTO);	
		
		return new  ResponseEntity<>("registration done succesfully",HttpStatus.CREATED);


	}
	@PutMapping("/employees")// localhost:8080/employees/1   >>> end point 

	ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO){
		
		
		
		employeeService.saveEmployee(employeeDTO);	
		
		return new  ResponseEntity<>("Updation done succesfully",HttpStatus.OK);
	


	}
	
	@PutMapping("/employees/{employeeId}")// localhost:8080/employees/3 + data to be updated in the body choosing only the id from url not in the body

	ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO,@PathVariable int employeeId){
		
		employeeDTO.setEmployeeId(employeeId);
		employeeService.saveEmployee(employeeDTO);	
		
		return new  ResponseEntity<>("Updation done succesfully",HttpStatus.OK);
	}
	
	@PatchMapping("/employees/{employeeId}/{password}")// localhost:8080/employees/3 + password in the 
	ResponseEntity<EmployeeDTO>partialUpdateEmployee(@PathVariable int employeeId,@PathVariable String password){
		
		EmployeeDTO employeeDTO= employeeService.partialUpdate(employeeId,password);
		
		
	
		
		return new  ResponseEntity<>(employeeDTO,HttpStatus.OK);
	}

	@PostMapping("/employees/{emailId}/{password}")// localhost:8080/emploloyee/p@gmail.com/password
	ResponseEntity<String>authenticate(@PathVariable String emailId,@PathVariable String password){
		
		EmployeeDTO employeeDTO= employeeService.authenticate(emailId,password);
		
		
	if (employeeDTO!=null) {
		
		return new  ResponseEntity<>("verified...authenticated",HttpStatus.OK);
	}
	
	
	return new  ResponseEntity<>("sorry ...plz enter a valid credetial",HttpStatus.BAD_REQUEST);
    }
	
	
	@DeleteMapping("/employees/{employeeId}")// localhost:8080/employees/3

	ResponseEntity<String> deleteEmployee(@PathVariable int employeeId){
		
		
		
		employeeService.deleteEmployee(employeeId);	
		
		return new  ResponseEntity<>("Deletion done succesfully",HttpStatus.OK);
	}
}