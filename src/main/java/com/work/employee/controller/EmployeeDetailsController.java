package com.work.employee.controller;

import com.work.employee.entity.Department;
import com.work.employee.entity.EmployeeDetails;
import com.work.employee.form.EmployeeRegisterForm;
import com.work.employee.service.DepartmentService;
import com.work.employee.service.EmployeeDetailsService;
import com.work.employee.service.EmployeeRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value="/employee")
public class EmployeeDetailsController {

    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeRegistrationService employeeRegistrationService;


    @GetMapping("/list-employees")
    public String getEmployeeList(Model model) {
        EmployeeRegisterForm employeeRegisterForm = new EmployeeRegisterForm();
        model.addAttribute("employeeRegisterForm", employeeRegisterForm);
        List<EmployeeDetails> employeeList = employeeDetailsService.getEmployeeList();
        model.addAttribute("employeeList", employeeList);
        List<Department> departmentList = departmentService.getAllDepartments();
        model.addAttribute("departmentList", departmentList);
        return "employee_list";
    }

    @PostMapping("/save")
    public String saveEmployeeDetails(@Valid @ModelAttribute("employeeRegisterForm") EmployeeRegisterForm employeeRegisterForm,
                                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Department> departmentList = departmentService.getAllDepartments();
            model.addAttribute("departmentList", departmentList);
            return "employee_register_from";
        } else {
            employeeRegisterForm = employeeRegistrationService.saveEmployeeDetails(employeeRegisterForm);
            return "success";
        }
    }

    @PostMapping("/search")
    public String searchEmployee(@ModelAttribute("employeeRegisterForm") EmployeeRegisterForm employeeRegisterForm, Model model) {
        List<EmployeeDetails> employeeList = employeeDetailsService.getEmployeeSearchList(employeeRegisterForm);
        model.addAttribute("employeeList", employeeList);
        List<Department> departmentList = departmentService.getAllDepartments();
        model.addAttribute("departmentList", departmentList);
        return "employee_list";
    }

    @GetMapping("/edit/{employeeId}")
    public String employeeEmployee(@PathVariable(name = "employeeId") Integer employeeId, Model model, HttpServletRequest request) {
        EmployeeRegisterForm employeeRegisterForm = employeeDetailsService.editEmployeeDetails(employeeId);
        model.addAttribute("employeeRegisterForm", employeeRegisterForm);
        setModelAttributes(model);
        model.addAttribute("employeeDept", employeeRegisterForm.getDepartmentId());
        return "employee_register_from";
    }

    @GetMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable(name = "employeeId") Integer employeeId, Model model) {
        employeeDetailsService.deleteEmployee(employeeId);
        EmployeeRegisterForm employeeRegisterForm = new EmployeeRegisterForm();
        model.addAttribute("employeeRegisterForm", employeeRegisterForm);
        setModelAttributes(model);
        return "employee_list";
    }

    private void setModelAttributes(Model model) {
        List<EmployeeDetails> employeeList = employeeDetailsService.getEmployeeList();
        model.addAttribute("employeeList", employeeList);
        List<Department> departmentList = departmentService.getAllDepartments();
        model.addAttribute("departmentList", departmentList);
    }

}
