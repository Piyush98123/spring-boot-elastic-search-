package com.boot_elasticsearch_crud.service;

import java.util.List;

import com.boot_elasticsearch_crud.model.EmployeeDto;
import com.boot_elasticsearch_crud.exception.EmployeeNotFoundException;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(String employeeId) throws EmployeeNotFoundException;
	List<EmployeeDto> getEmployees();
	void deleteEmployee(String employeeId) throws EmployeeNotFoundException;
	EmployeeDto updateEmployee(EmployeeDto employeeDto) throws EmployeeNotFoundException;
}