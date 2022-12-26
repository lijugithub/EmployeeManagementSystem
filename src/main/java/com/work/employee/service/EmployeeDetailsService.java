package com.work.employee.service;

import com.work.employee.entity.EmployeeDetails;
import com.work.employee.form.EmployeeRegisterForm;

import java.util.List;

public interface EmployeeDetailsService {
    List<EmployeeDetails> getEmployeeList();

    List<EmployeeDetails> getEmployeeSearchList(EmployeeRegisterForm employeeRegisterForm);

    void deleteEmployee(Integer employeeId);

    EmployeeRegisterForm editEmployeeDetails(Integer employeeId);
}
