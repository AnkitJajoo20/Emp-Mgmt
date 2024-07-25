package nic.bastar.emp.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nic.bastar.emp.DTO.DepartmentDto;
import nic.bastar.emp.Entity.Department;
import nic.bastar.emp.Exception.ResourceNotFoundException;
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

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
            () -> new ResourceNotFoundException("Department is not exists in Given Id" +departmentId)
        );
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
       return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
       .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updateDepartmentDto) {

        Department department = departmentRepository.findById(departmentId).orElseThrow(
            () -> new ResourceNotFoundException("Department is not Exists with Given Id: " +departmentId)
        );

        department.setDepartmentName(updateDepartmentDto.getDepartmentName());
        department.setDepartmentDescription(updateDepartmentDto.getDepartmentDescription());

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(
            () -> new ResourceNotFoundException("Department is not Exists with Given Id " + departmentId)
        );

        departmentRepository.deleteById(departmentId);
    }
    
}
