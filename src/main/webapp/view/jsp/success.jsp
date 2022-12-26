<%@ include file="/view/jsp/header.jsp"%>
<%@ include file="/view/jsp/navigation.jsp"%>
	<div class="container" align="center">
	<div class="card">
               <div class="card-body">
		<h2>Registration Success!</h2>
		<div align="left">
		<span>Employee Name:</span><span>${employeeRegisterForm.employeeName}</span><br/>
		<span>Employee No:</span><span>${employeeRegisterForm.employeeNo}</span><br/>
		<span>Date of Joining:</span><span>${employeeRegisterForm.dateOfJoining}</span><br/>
		<span>Department:</span><span>${employeeRegisterForm.departmentName}</span><br/>
		<span>Salary:</span><span>${employeeRegisterForm.salary}</span><br/>
		</div>
	</div>
	</div>
	</div>
<%@ include file="/view/jsp/footer.jsp"%>