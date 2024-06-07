package nic.bastar.emp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nic.bastar.emp.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
}
