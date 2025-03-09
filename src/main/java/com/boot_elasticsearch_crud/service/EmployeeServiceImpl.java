package com.boot_elasticsearch_crud.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.boot_elasticsearch_crud.mapper.EmployeeMapper;
import com.boot_elasticsearch_crud.model.Employee;
import com.boot_elasticsearch_crud.model.EmployeeDto;
import com.boot_elasticsearch_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot_elasticsearch_crud.exception.EmployeeNotFoundException;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee createdEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(createdEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(String employeeId) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (employee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with id - " + employeeId + " not found.");
		}
		return EmployeeMapper.mapToEmployeeDto(employee.get());
	}

	@Override
	public List<EmployeeDto> getEmployees() {
		Iterable<Employee> employeesIterable = employeeRepository.findAll();
		List<Employee> employees = StreamSupport.stream(employeesIterable.spliterator(), false).toList();
		return employees.stream().map((emp) -> EmployeeMapper.mapToEmployeeDto(emp)).collect(Collectors.toList());
	}

	@Override
	public void deleteEmployee(String employeeId) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (employee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with id - " + employeeId + " not found.");
		}
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto) throws EmployeeNotFoundException {
		Optional<Employee> retrievedEmployee = employeeRepository.findById(employeeDto.getId());
		if (retrievedEmployee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with id - " + employeeDto.getId() + " not found.");
		}
		Employee employee = retrievedEmployee.get();
		employee.setName(employeeDto.getName());
		employee.setDepartment(employeeDto.getDepartment());
		Employee createdEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(createdEmployee);
	}

}
