<%@ include file="/view/jsp/header.jsp"%>
<%@ include file="/view/jsp/navigation.jsp"%>
<script>

 function resetSearchForm() {
      document.getElementById("employee-search").reset();
 }
</script>

    <div class="container" >
           <div>
               <h1>Employee Details</h1>
<table class="table table-condensed">
  <thread>
    <tr>
      <th scope="col">Sl No.</th>
      <th scope="col">Employee No</th>
      <th scope="col">Employee Name</th>
      <th scope="col">Date Of Joining</th>
      <th scope="col">Department</th>
      <th scope="col">Salary (AED)</th>
      <th scope="col">Action</th>
    </tr>
  </thread>
  <body>
    <% int id = 1 ; %>

    <tr>
    <form:form action="search" method="post" modelAttribute="employeeRegisterForm" id="employee-search">
        <th></th>
        <th ><form:input type="number" path="employeeNo"  style="display:inline-block; width:120px; overflow:visible;" /></th>
        <th ><form:input type="text" path="employeeName"  style="display:inline-block; width:150px; overflow:visible;"/></th>
        <th></th>
        <th>
         <form:select path = "departmentId"  style="display:inline-block; width:200px; overflow:visible;">
                                <option value="">--Select--</option>
                                  <c:forEach items="${departmentList}" var="department">
                                     <option value="${department.departmentId}">${department.departmentName}</option>
                                   </c:forEach>
                                </form:select>
        </th>
        <th></th>
        <th><button type="submit" class="btn btn-primary">Search</button>&nbsp;
            <input type="button"  class="btn btn-primary" onclick="resetSearchForm()" value="Clear">
        </th>
        </form:form>
        </tr>
    <c:forEach items="${employeeList}" var="employee">
    <tr>
            <th scope="row"><%=id %></th>
            <td>${employee.employeeNo}</td>
            <td>${employee.employeeName}</td>
            <td>${employee.dateOfJoining}</td>
            <td>${employee.department.departmentName}</td>
            <td>${employee.salary}</td>
            <td>
            <a href="edit/${employee.id}"><input type="button"  value="Edit" class="btn btn-primary"></a>
            <a href="delete/${employee.id}"><input type="button"  value="Delete" class="btn btn-primary"></a></a>

            </td>
    </tr>
    <% id++; %>
    </c:forEach>
  </body>
</table>


               </div>
               </div>
<%@ include file="/view/jsp/footer.jsp"%>