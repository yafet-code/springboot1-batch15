package com.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.main.entity.EmployeeEntity;
import com.main.dao.EmployeeRepository;
import com.main.dto.EmployeeDTO;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	

	@Override
	public void saveEmployee(EmployeeDTO employeeDTO) {
		
		EmployeeEntity employeeEntity =new EmployeeEntity();
		BeanUtils.copyProperties(employeeDTO, employeeEntity);
		
		employeeRepository.save(employeeEntity);	
		
		
	}


	@Override
	public EmployeeDTO authenticate(String emailId, String password) {
		
	
		
		EmployeeEntity employeeEntity=employeeRepository.findByEmailIdAndPassword(emailId,password);
		
		if(employeeEntity !=null) {
			
			EmployeeDTO employeeDTO =new EmployeeDTO();
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			return employeeDTO;
			
		}
		
		
		return null;
	}


	@Override
	public List<EmployeeDTO> findAllEmp() {
	
		List<EmployeeEntity> listOfEmployeeEntity=employeeRepository.findAll();
		//crate a blank dto list
		List<EmployeeDTO> listOfEmployeeDTO=new ArrayList<>();
		
		for( EmployeeEntity employeeEntity   : listOfEmployeeEntity) {
			
			EmployeeDTO employeeDTO =new EmployeeDTO();
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			listOfEmployeeDTO.add(employeeDTO);
			
		}
		
		return listOfEmployeeDTO;
	}


	@Override
	public EmployeeDTO findEmp(int employeeId) {
		Optional<EmployeeEntity> optional=employeeRepository.findById(employeeId);//optional is used to avoid nullPointerException
		if(optional.isPresent()) {
			
			EmployeeEntity employeeEntity=optional.get();
			EmployeeDTO employeeDTO =new EmployeeDTO();
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			return employeeDTO;
			
		}
		
		
		return null;
	}


	@Override
	public EmployeeDTO partialUpdate(int employeeId, String password) {
		
		
		Optional<EmployeeEntity> optional=employeeRepository.findById(employeeId);//optional is used to avoid nullPointerException
		if(optional.isPresent()) {
			
			EmployeeEntity employeeEntity=optional.get();
			employeeEntity.setPassword(password); // will update into db
			
			EmployeeDTO employeeDTO =new EmployeeDTO();
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			return employeeDTO;
			
		}
		

		  
		return null;
	}


	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
		
	}
	
	
}
