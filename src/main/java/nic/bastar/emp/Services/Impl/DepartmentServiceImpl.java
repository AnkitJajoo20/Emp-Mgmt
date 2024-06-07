package nic.bastar.emp.Services.Impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nic.bastar.emp.DTO.DepartmentDto;
import nic.bastar.emp.Entity.Department;
import nic.bastar.emp.Mapper.DepartmentMapper;
import nic.bastar.emp.Repository.DepartmentRepository;
import nic.bastar.emp.Services.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment=departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }
    
}
