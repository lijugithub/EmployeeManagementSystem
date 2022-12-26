package com.work.employee.dao;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

@Data
public class EmployeeDetailsDao {


    private String employeeNo;

    private String employeeName;

    private Date dateOfJoining;

    private String departmentCode;

    private String salary;
}
