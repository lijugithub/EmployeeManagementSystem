package com.work.employee.service;

import com.work.employee.form.EmployeeRegisterForm;

import javax.validation.Valid;

public interface EmployeeRegistrationService {
     EmployeeRegisterForm saveEmployeeDetails(EmployeeRegisterForm employeeRegisterForm);
}
