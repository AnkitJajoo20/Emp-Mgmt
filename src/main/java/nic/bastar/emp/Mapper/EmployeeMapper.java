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
            employee.getDepartment()
        );
    }
    
    //Convert Employee DTO to JPA Entity
    public static Employee mapTEmployee(EmployeeDto employeeDto){
        return new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail(),
            employeeDto.getDesignation()
        );
    }
}
