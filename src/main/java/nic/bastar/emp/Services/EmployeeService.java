package nic.bastar.emp.Services;

import java.util.List;

import nic.bastar.emp.DTO.EmployeeDto;

public interface EmployeeService {
    
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeId);
    
}
