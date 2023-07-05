package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.dto.EmployeeDTO;
import com.main.entity.EmployeeEntity;
import com.main.services.EmployeeService;

// learning spring boot
@Controller

public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("/")
	String showLoginPage(){
		return "login";
		
	}
	
	@GetMapping("/registrationPage")
	
	String displayRegistrationPageAgain(){
		
		return "registration";
		
	}
	

	@PostMapping("/registration")
	String registration(@ModelAttribute EmployeeDTO employeeDTO,Model model,RedirectAttributes redirectAttrs){
		
		employeeService.saveEmployee(employeeDTO);	
		
		//model.addAttribute("msg", "registration done successfully");//will not work
		redirectAttrs.addFlashAttribute("msg", "registration done successfully");
		return "redirect:registrationPage";
		
	}
	
	@PostMapping("/login")
	String authenticate(@RequestParam String emailId,@RequestParam String password,Model model){
		
		System.out.println("This not the page ");
		System.out.println("This not the page ");
		
		EmployeeDTO employeeDTO=employeeService.authenticate(emailId,password);
		if(employeeDTO!=null) {
			
			model.addAttribute("employee", employeeDTO);
			
			return "congrates";		
			
		}		
		
		model.addAttribute("msg", "plz try again");
		return "login";
		
	}
	
	@GetMapping("/showEmployees")
	String findAll(Model model){
		
		List<EmployeeDTO> listOfEmployeeDTO=employeeService.findAllEmp();
		model.addAttribute("listOfEmployee", listOfEmployeeDTO);
		
		
		return "showAll";
		
	}
	
	@GetMapping("/showEditForm")
	String findEmployee(@RequestParam int employeeId,Model model){
		
		EmployeeDTO  employeeDTO=employeeService.findEmp(employeeId);
		if(employeeDTO !=null) {
			model.addAttribute("employeeDTO", employeeDTO);
			return "showEditForm";
			
		}	
		
		
		return "login";
		
	}

	@PostMapping("/updateEmployee")
	String updateEmployee(@ModelAttribute EmployeeDTO employeeDTO,Model model,RedirectAttributes redirectAttrs){
		
		employeeService.saveEmployee(employeeDTO);	
		
		//model.addAttribute("msg", "registration done successfully");//will not work
		redirectAttrs.addFlashAttribute("msg", "updation done successfully");
		return "redirect:showEmployees";
		
	}
	
	
	
	
}
	
	


