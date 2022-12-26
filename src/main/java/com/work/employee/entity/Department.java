package com.work.employee.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Table(name="department")
@Data
public class Department {
    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "department_name")
    private String departmentName;


}
