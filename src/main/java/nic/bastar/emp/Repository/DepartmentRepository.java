package nic.bastar.emp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nic.bastar.emp.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{
    
}
