package nic.bastar.emp.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nic.bastar.emp.DTO.EmployeeDto;
import nic.bastar.emp.Entity.Employee;
import nic.bastar.emp.Exception.ResourceNotFoundException;
import nic.bastar.emp.Mapper.EmployeeMapper;
import nic.bastar.emp.Repository.EmployeeRepository;
import nic.bastar.emp.Services.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        //Convert Employee DTO Mapper to Employee Entity
        Employee employee=EmployeeMapper.mapTEmployee(employeeDto);

        Employee savedEmployee=employeeRepository.save(employee);

        //Again convert Entity to DTO Mapper
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with Given Id : " +employeeId));
        
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        
        List<Employee> employees= employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                                            .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {

        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee isn't Exists by given Id" +employeeId));

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());
        employee.setDepartment(updateEmployee.getDesignation());

        Employee updateEmp=employeeRepository.save(employee);
        
        return EmployeeMapper.mapToEmployeeDto(updateEmp);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee isn't Exists by given Id" +employeeId));
            
        employeeRepository.deleteById(employeeId);
    }
    
}
