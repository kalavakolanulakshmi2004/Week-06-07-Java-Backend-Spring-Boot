package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repository;

    @Override
    public List<EmployeePayrollModel> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeePayrollModel getEmployeeById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeePayrollException("Employee with ID " + id + " not found"));
    }

    @Override
    public EmployeePayrollModel createEmployee(EmployeePayrollDTO dto) {
        return repository.save(new EmployeePayrollModel(0, dto.getName(), dto.getSalary()));
    }

    @Override
    public EmployeePayrollModel updateEmployee(int id, EmployeePayrollDTO dto) {
        EmployeePayrollModel existing = getEmployeeById(id);
        existing.setName(dto.getName());
        existing.setSalary(dto.getSalary());
        return repository.save(existing);
    }

    @Override
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}
