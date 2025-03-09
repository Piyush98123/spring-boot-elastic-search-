package com.boot_elasticsearch_crud.repository;

import com.boot_elasticsearch_crud.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

}