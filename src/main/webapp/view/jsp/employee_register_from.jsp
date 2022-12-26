<%@ include file="/view/jsp/header.jsp"%>
<%@ include file="/view/jsp/navigation.jsp"%>
<script>
     function resetForm() {
         document.getElementById("employee-form").reset();
     }
</script>
<script>
         $(function() {
             $.datepicker.setDefaults({
                 onClose:function(date, inst){
                     $("#selectedDtaeVal").html(date);
                 }
             });
             $( "#datepicker" ).datepicker({ dateFormat: "dd/mm/yy" });
         });
</script>
   <%
    String employeeDept = (String)request.getAttribute("employeeDept");
	pageContext.setAttribute("empDept",employeeDept);
	%>
    <div class="container" background="">
           <div>
               <h1>Employee Registration</h1>
           </div>
           <div class="card">
           <div class="card-body">

           <form:form action="/employee/save" method="post" modelAttribute="employeeRegisterForm" id="employee-form">
                <form:hidden path="id" />
                <div class="form-group row">
                     <label for="employeeNo" class="col-sm-2 col-form-label">Employee No</label>
                     <div class="col-sm-7">
                     <form:input type="number" path="employeeNo" class="form-control" placeholder="Enter Employee No" />
                     <form:errors path="employeeNo" class="text-danger" />
                     </div>
                </div>

                <div class="form-group row">
                       <label for="employeeName" class="col-sm-2 col-form-label">Employee Name</label>
                       <div class="col-sm-7">
                       <form:input path="employeeName" class="form-control" placeholder="Enter Employee Name"/>
                       <form:errors path="employeeName" class="text-danger" />
                       </div>
                </div>

                <div class="form-group row">
                        <label for="dateOfJoining" class="col-sm-2 col-form-label">Date Of Joining</label>
                        <div class="col-sm-7">
                        <form:input path="dateOfJoining" class="form-control" id="datepicker" placeholder="Select Date"/>
                        <form:errors path="dateOfJoining" class="text-danger" />
                        </div>
                </div>

                <div class="form-group row">
                        <label for="departmentId" class="col-sm-2 col-form-label">Department</label>
                        <div class="col-sm-7">
                        <form:select path = "departmentId">
                        <option value="">--Select--</option>
                          <c:forEach items="${departmentList}" var="department">
                              <option value="${department.departmentId}"  ${department.departmentId == empDept ? 'selected="selected"' : ''} >${department.departmentCode} - ${department.departmentName}</option>
                           </c:forEach>
                        </form:select>
                        </div>
                </div>

                <div class="form-group row">
                                        <label for="salary" class="col-sm-2 col-form-label">Salary</label>
                                        <div class="col-sm-7">
                                        <form:input type="number" path="salary" class="form-control" placeholder="Enter Salary"/>
                                        <form:errors path="salary" class="text-danger" />

                                        </div>
                                </div>

<div class="form-group row">

<button type="submit" class="btn btn-primary">Submit</button>&nbsp;
<% if(employeeDept==null) {%>
<input type="button"  class="btn btn-primary" onclick="resetForm()" value="Clear">
<% } %>
</div>

               </form:form>
               </div>
               </div>
               </div>

<%@ include file="/view/jsp/footer.jsp"%>