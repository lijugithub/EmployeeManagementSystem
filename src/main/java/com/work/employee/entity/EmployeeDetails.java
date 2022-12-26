package com.work.employee.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employee_registration")
@Data
public class EmployeeDetails {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "employee_no")
        private String employeeNo;

        @Column(name = "employee_name")
        private String employeeName;

        @Column(name = "date_of_joining")
        private Date dateOfJoining;

        @ManyToOne
        @JoinColumn(name = "department_id", nullable = false)
        private Department department;

        @Column(name = "salary")
        private String salary;


}
