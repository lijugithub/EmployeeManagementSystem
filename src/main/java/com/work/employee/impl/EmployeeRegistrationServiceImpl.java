package com.work.employee.impl;

import com.work.employee.entity.Department;
import com.work.employee.entity.EmployeeDetails;
import com.work.employee.form.EmployeeRegisterForm;
import com.work.employee.repository.DepartmentRepository;
import com.work.employee.repository.EmployeeDetailsRepository;
import com.work.employee.service.DepartmentService;
import com.work.employee.service.EmployeeRegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

    @Autowired
    private EmployeeDetailsRepository employeeRegistrationRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    @Transactional
    public EmployeeRegisterForm saveEmployeeDetails(EmployeeRegisterForm employeeRegisterForm) {
        try {
            EmployeeDetails employeeRegistration = new EmployeeDetails();
            BeanUtils.copyProperties(employeeRegisterForm, employeeRegistration);
            Department department = new Department();
            department.setDepartmentId(Integer.valueOf(employeeRegisterForm.getDepartmentId()));
            employeeRegistration.setDepartment(department);
            employeeRegistration = employeeRegistrationRepository.save(employeeRegistration);
            BeanUtils.copyProperties(employeeRegistration, employeeRegisterForm);
            department = departmentRepository.findById(employeeRegistration.getDepartment().getDepartmentId()).get();
            employeeRegisterForm.setDepartmentId(String.valueOf(employeeRegistration.getDepartment().getDepartmentId()));
            employeeRegisterForm.setDepartmentName(department.getDepartmentName());
            return employeeRegisterForm;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
