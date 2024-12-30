package com.example.ems.mapper;

import com.example.ems.dto.DepartmentDto;
import com.example.ems.entity.Department;

public class DepartmentMapper {

    //convert department jpa entity into departmentDto

    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    //convert DepartmentDto into Department JPA entity
    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
