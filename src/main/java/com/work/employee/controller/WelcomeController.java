package com.work.employee.controller;


import com.work.employee.entity.Department;
import com.work.employee.form.EmployeeRegisterForm;
import com.work.employee.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value="/employee")
public class WelcomeController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        EmployeeRegisterForm employeeRegisterForm = new EmployeeRegisterForm();
        model.addAttribute("employeeRegisterForm", employeeRegisterForm);
        List<Department> departmentList = departmentService.getAllDepartments();
        model.addAttribute("departmentList", departmentList);

        return "employee_register_from";
    }
}
