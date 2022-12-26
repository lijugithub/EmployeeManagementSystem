package com.work.employee.impl;

import com.work.employee.entity.EmployeeDetails;
import com.work.employee.form.EmployeeRegisterForm;
import com.work.employee.repository.EmployeeDetailsRepository;
import com.work.employee.service.EmployeeDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;
    @Override
    public List<EmployeeDetails> getEmployeeList() {
        List<EmployeeDetails> employeeList = employeeDetailsRepository.findAll();
        return employeeList;
    }

    @Override
    public List<EmployeeDetails> getEmployeeSearchList(EmployeeRegisterForm employeeRegisterForm) {
        try {
            List<EmployeeDetails> employeeList = new ArrayList<>();

            if (StringUtils.isEmpty(employeeRegisterForm.getEmployeeNo()) && StringUtils.isEmpty(employeeRegisterForm.getEmployeeName()) && StringUtils.isEmpty(employeeRegisterForm.getDepartmentId())) {
                employeeList = employeeDetailsRepository.findAll();
            } else if (StringUtils.isEmpty(employeeRegisterForm.getEmployeeNo()) && StringUtils.isEmpty(employeeRegisterForm.getEmployeeName()) && !StringUtils.isEmpty(employeeRegisterForm.getDepartmentId())) {
                employeeList = employeeDetailsRepository.findEmployeeDetailsDepartment(Integer.valueOf(employeeRegisterForm.getDepartmentId()));
            } else if (StringUtils.isEmpty(employeeRegisterForm.getEmployeeNo()) && !StringUtils.isEmpty(employeeRegisterForm.getEmployeeName()) && StringUtils.isEmpty(employeeRegisterForm.getDepartmentId())) {
                employeeList = employeeDetailsRepository.findEmployeeDetailsEmployeeName(employeeRegisterForm.getEmployeeName());
            } else if (StringUtils.isEmpty(employeeRegisterForm.getEmployeeNo()) && !StringUtils.isEmpty(employeeRegisterForm.getEmployeeName()) && !StringUtils.isEmpty(employeeRegisterForm.getDepartmentId())) {
                employeeList = employeeDetailsRepository.findEmployeeDetailsEmployeeNameAndDepartmentCode(employeeRegisterForm.getEmployeeName(), Integer.valueOf(employeeRegisterForm.getDepartmentId()));
            } else if (!StringUtils.isEmpty(employeeRegisterForm.getEmployeeNo()) && StringUtils.isEmpty(employeeRegisterForm.getEmployeeName()) && StringUtils.isEmpty(employeeRegisterForm.getDepartmentId())) {
                employeeList = employeeDetailsRepository.findEmployeeDetailsEmployeeNo(employeeRegisterForm.getEmployeeNo());
            } else if (!StringUtils.isEmpty(employeeRegisterForm.getEmployeeNo()) && StringUtils.isEmpty(employeeRegisterForm.getEmployeeName()) && !StringUtils.isEmpty(employeeRegisterForm.getDepartmentId())) {
                employeeList = employeeDetailsRepository.findEmployeeDetailsEmployeeNoAndDepartmentCode(employeeRegisterForm.getEmployeeNo(), Integer.valueOf(employeeRegisterForm.getDepartmentId()));
            } else if (!StringUtils.isEmpty(employeeRegisterForm.getEmployeeNo()) && !StringUtils.isEmpty(employeeRegisterForm.getEmployeeName()) && StringUtils.isEmpty(employeeRegisterForm.getDepartmentId())) {
                employeeList = employeeDetailsRepository.findEmployeeDetailsEmployeeNoAndEmployeeName(employeeRegisterForm.getEmployeeNo(), employeeRegisterForm.getEmployeeName());
            } else if (!StringUtils.isEmpty(employeeRegisterForm.getEmployeeNo()) && !StringUtils.isEmpty(employeeRegisterForm.getEmployeeName()) && !StringUtils.isEmpty(employeeRegisterForm.getDepartmentId())) {
                employeeList = employeeDetailsRepository.findEmployeeDetailsEmployeeNoAndEmployeeNameAndDepartmentCode(employeeRegisterForm.getEmployeeNo(), employeeRegisterForm.getEmployeeName(), Integer.valueOf(employeeRegisterForm.getDepartmentId()));
            }
            return employeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        try {
            employeeDetailsRepository.deleteById(employeeId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public EmployeeRegisterForm editEmployeeDetails(Integer employeeId) {
        try {
            EmployeeRegisterForm employeeRegisterForm = new EmployeeRegisterForm();
            EmployeeDetails employeeDetails = employeeDetailsRepository.findById(employeeId).get();
            BeanUtils.copyProperties(employeeDetails, employeeRegisterForm);
            employeeRegisterForm.setDepartmentId(String.valueOf(employeeDetails.getDepartment().getDepartmentId()));
            return employeeRegisterForm;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
