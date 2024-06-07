package nic.bastar.emp.Mapper;

import nic.bastar.emp.DTO.DepartmentDto;
import nic.bastar.emp.Entity.Department;

public class DepartmentMapper {
    
    //Convert Department JPA Entity into DTO
    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
            department.getId(),
            department.getDepartmentName(),
            department.getDepartmentDescription()
        );
    }

    //Convertr Department DTO into JPA Entity
    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
            departmentDto.getId(),
            departmentDto.getDepartmentName(),
            departmentDto.getDepartmentDescription()
        );
    }
}
