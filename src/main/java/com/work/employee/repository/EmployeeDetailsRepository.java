package com.work.employee.repository;

import com.work.employee.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {
    @Query(value = "Select e from EmployeeDetails e where  e.department.departmentId = ?1")
    List<EmployeeDetails> findEmployeeDetailsDepartment(Integer departmentId);

    @Query(value = "Select e from EmployeeDetails e where  e.employeeName like %?1% ")
    List<EmployeeDetails> findEmployeeDetailsEmployeeName(String employeeName);

    @Query(value = "Select e from EmployeeDetails e where  e.employeeName like %?1%  and e.department.departmentId = ?2")
    List<EmployeeDetails> findEmployeeDetailsEmployeeNameAndDepartmentCode(String employeeName, Integer departmentId);

    @Query(value = "Select e from EmployeeDetails e where  e.employeeNo like %?1% ")
    List<EmployeeDetails> findEmployeeDetailsEmployeeNo(String employeeNo);

    @Query(value = "Select e from EmployeeDetails e where  e.employeeNo like %?1%  and e.department.departmentId = ?2")
    List<EmployeeDetails> findEmployeeDetailsEmployeeNoAndDepartmentCode(String employeeNo, Integer departmentId);

    @Query(value = "Select e from EmployeeDetails e where  e.employeeNo like %?1%  and e.employeeName like %?2%")
    List<EmployeeDetails> findEmployeeDetailsEmployeeNoAndEmployeeName(String employeeNo, String employeeName);

    @Query(value = "Select e from EmployeeDetails e where e.employeeNo like %?1% and  e.employeeName like %?2% and e.department.departmentId = ?3")
    List<EmployeeDetails> findEmployeeDetailsEmployeeNoAndEmployeeNameAndDepartmentCode(String employeeNo, String employeeName, Integer departmentId);


}
