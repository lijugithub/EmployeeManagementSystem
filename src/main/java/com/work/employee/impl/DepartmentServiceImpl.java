package com.work.employee.impl;

import com.work.employee.entity.Department;
import com.work.employee.repository.DepartmentRepository;
import com.work.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        try {
            List<Department> departmentList = departmentRepository.findAll();
            return departmentList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
