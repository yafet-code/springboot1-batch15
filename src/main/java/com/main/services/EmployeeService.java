package com.main.services;

import java.util.List;

import com.main.dto.EmployeeDTO;
import com.main.entity.EmployeeEntity;

public interface EmployeeService {

	void saveEmployee(EmployeeDTO employeeDTO);

	EmployeeDTO authenticate(String emailId, String password);

	List<EmployeeDTO> findAllEmp();

	EmployeeDTO findEmp(int employeeId);

	EmployeeDTO partialUpdate(int employeeId, String password);

	void deleteEmployee(int employeeId);



}
