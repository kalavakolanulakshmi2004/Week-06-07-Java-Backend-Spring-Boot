package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService service;

    @GetMapping("/")
    public ResponseEntity<List<EmployeePayrollModel>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollModel> getEmployee(@PathVariable int id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollModel> createEmployee(@Valid @RequestBody EmployeePayrollDTO dto) {
        return ResponseEntity.ok(service.createEmployee(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeePayrollModel> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO dto) {
        return ResponseEntity.ok(service.updateEmployee(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Deleted employee with ID " + id);
    }
}
