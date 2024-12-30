package com.example.ems.controller;

import com.example.ems.dto.DepartmentDto;
import com.example.ems.entity.Department;
import com.example.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    //Build Add department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
       DepartmentDto department = departmentService.createDepartment(departmentDto);
       return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    //Build Get Department REST API
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentByID(@PathVariable("id") Long departmentId){
        DepartmentDto departmentDto = departmentService.getDepartmentByID(departmentId);
        return ResponseEntity.ok(departmentDto);
    }

    //Build Get All department REST API
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        List<DepartmentDto> departments = departmentService.getAllDepartment();
        return ResponseEntity.ok(departments);
    }

    //Build Update Department REST API
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(
            @PathVariable("id") Long departmentID, @RequestBody DepartmentDto updatedDepartment){
        DepartmentDto departmentDto = departmentService.updateDepartment(departmentID, updatedDepartment);
        return ResponseEntity.ok(departmentDto);
    }

    //Delete Department REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment (@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department Deleted successfully");
    }



}
