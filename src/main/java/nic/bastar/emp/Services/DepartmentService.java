package nic.bastar.emp.Services;

import java.util.List;

import nic.bastar.emp.DTO.DepartmentDto;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();
}
