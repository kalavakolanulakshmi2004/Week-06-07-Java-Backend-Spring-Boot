package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollModel> getAllEmployees();
    EmployeePayrollModel getEmployeeById(int id);
    EmployeePayrollModel createEmployee(EmployeePayrollDTO dto);
    EmployeePayrollModel updateEmployee(int id, EmployeePayrollDTO dto);
    void deleteEmployee(int id);
}
