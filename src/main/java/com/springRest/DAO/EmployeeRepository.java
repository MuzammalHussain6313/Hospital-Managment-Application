package com.springRest.DAO;

import com.springRest.enitity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
