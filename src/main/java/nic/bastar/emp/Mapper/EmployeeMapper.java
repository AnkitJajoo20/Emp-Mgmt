package nic.bastar.emp.Mapper;

import nic.bastar.emp.DTO.EmployeeDto;
import nic.bastar.emp.Entity.Employee;

public class EmployeeMapper {
    
    //Convert Employee JPA Entity to DTO
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail(),
            employee.getDesignation()
        );
    }
    
    //Convert Employee DTO to JPA Entity
    public static Employee mapTEmployee(EmployeeDto employeeDto){
         
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDesignation(employeeDto.getDesignation());
        return employee;
    }
}
