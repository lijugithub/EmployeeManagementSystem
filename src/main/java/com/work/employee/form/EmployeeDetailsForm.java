package com.work.employee.form;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDetailsForm {

    private String employeeNo;

    private String employeeName;

    private Date dateOfJoining;

    private String departmentCode;

    private String salary;
}
