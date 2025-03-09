package com.boot_elasticsearch_crud.mapper;

import com.boot_elasticsearch_crud.model.Employee;
import com.boot_elasticsearch_crud.model.EmployeeDto;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(employee.getId(), employee.getName(), employee.getDepartment());
	}

	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(employeeDto.getId(), employeeDto.getName(), employeeDto.getDepartment());
	}

}
