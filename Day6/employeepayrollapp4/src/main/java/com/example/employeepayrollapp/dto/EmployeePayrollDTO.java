package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EmployeePayrollDTO {
    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "Name must start with capital and have at least 3 letters")
    private String name;

    @Positive(message = "Salary must be positive")
    private long salary;
}
