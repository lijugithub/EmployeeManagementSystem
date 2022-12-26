package com.work.employee.form;


import lombok.Data;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;


@Data
public class EmployeeRegisterForm {

    private Integer id;

    @NotEmpty(message = "Please enter employee number.")
    private String employeeNo;

    @NotEmpty(message = "Please enter employee name.")
    private String employeeName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message = "Enter valid date.")
    private Date dateOfJoining;

    @NotEmpty(message = "Please select department.")
    private String departmentId;

    @NotEmpty(message = "Please enter salary.")
    private String salary;

    private String departmentName;

}
