<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css"> -->
<title>Registration Page</title>
<style>
	.cssClass {
		background-color: red;
	}
</style>

<style type="text/css">
.form-style-5{
    max-width: 500px;
    padding: 10px 20px;
    background: #f4f7f8;
    margin: 10px auto;
    padding: 20px;
    background: #f4f7f8;
    border-radius: 8px;
    font-family: Georgia, "Times New Roman", Times, serif;
}
.form-style-5 fieldset{
    border: none;
}
.form-style-5 legend {
    font-size: 1.4em;
    margin-bottom: 10px;
}
.form-style-5 label {
    display: block;
    margin-bottom: 8px;
}
.form-style-5 input[type="text"],
.form-style-5 input[type="date"],
.form-style-5 input[type="datetime"],
.form-style-5 input[type="email"],
.form-style-5 input[type="number"],
.form-style-5 input[type="search"],
.form-style-5 input[type="time"],
.form-style-5 input[type="url"],
.form-style-5 textarea,
.form-style-5 select {
    font-family: Georgia, "Times New Roman", Times, serif;
    background: rgba(255,255,255,.1);
    border: none;
    border-radius: 4px;
    font-size: 16px;
    margin: 0;
    outline: 0;
    padding: 7px;
    width: 100%;
    /* box-sizing: border-box;  */
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box; 
    background-color: #e8eeef;
    color:#8a97a0;
    -webkit-box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
    box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
    margin-bottom: 30px;
    
}
.form-style-5 input[type="text"]:focus,
.form-style-5 input[type="date"]:focus,
.form-style-5 input[type="datetime"]:focus,
.form-style-5 input[type="email"]:focus,
.form-style-5 input[type="number"]:focus,
.form-style-5 input[type="search"]:focus,
.form-style-5 input[type="time"]:focus,
.form-style-5 input[type="url"]:focus,
.form-style-5 textarea:focus,
.form-style-5 select:focus{
    background: #d2d9dd;
}
.form-style-5 select{
    -webkit-appearance: menulist-button;
    height:35px;
}
.form-style-5 .number {
    background: #1abc9c;
    color: #fff;
    height: 30px;
    width: 30px;
    display: inline-block;
    font-size: 0.8em;
    margin-right: 4px;
    line-height: 30px;
    text-align: center;
    text-shadow: 0 1px 0 rgba(255,255,255,0.2);
    border-radius: 15px 15px 15px 0px;
}

.form-style-5 input[type="submit"],
.form-style-5 input[type="button"]
{
    position: relative;
    display: block;
    padding: 19px 39px 18px 39px;
    color: #FFF;
    margin: 0 auto;
    background: #1abc9c;
    font-size: 18px;
    text-align: center;
    font-style: normal;
    width: 100%;
    border: 1px solid #16a085;
    border-width: 1px 1px 3px;
    margin-bottom: 10px;
}
.form-style-5 input[type="submit"]:hover,
.form-style-5 input[type="button"]:hover
{
    background: #109177;
}
</style>

</head>
<body ng-app="myApp" bgcolor="black">
<div class="form-style-5">

<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/applyEducationLoan/${accountNumber}" modelAttribute="EducationLoanDetails" name="userForm">
<center>
<table>
<legend><span class="number">1</span> Loan Details</legend>
    <%-- <tr>
        <td>Account Number :</td>
        <td><form:input path="accountNumber" /></td>
        <td><form:errors path="accountNumber" cssClass="error" /></td>
    </tr> --%>
    
   <%--  <tr>
       
        <td><form:hidden path="accountNumber"/></td>
        <td><form:errors path="accountNumber" cssClass="error" /></td>
    </tr> --%>
    <tr>
     <div class="form-group" ng-class="{ 'has-error' : userForm.eduLoanAmount.$invalid && !userForm.eduLoanAmount.$pristine }">
    
        <td><label> <strong><spring:message
								code="label.eduLoanAmount" /></strong>
				</label></td>
        <td><form:input path="eduLoanAmount" type="number" min="1" ng-model="eduLoanAmount" required="true" style="margin-top: 25px;" /><span ng-show="userForm.eduLoanAmount.$invalid && !userForm.eduLoanAmount.$pristine" class="help-block">Please enter a valid Loan Amount .</span></td>
        <td><form:errors path="eduLoanAmount" cssClass="error" /></td>
        
         </div>
    </tr>
    
    <tr>
    <div class="form-group" ng-class="{ 'has-error' : userForm.eduLoanApplyDate.$invalid && !userForm.eduLoanApplyDate.$pristine }">
        <td><label> <strong><spring:message
								code="label.eduLoanApplyDate" /></strong>
				</label></td>
        <td><form:input type="Date"  path="eduLoanApplyDate" ng-model="eduLoanApplyDate" required="true" style="margin-top: 25px;" /><span ng-show="userForm.eduLoanApplyDate.$invalid && !userForm.eduLoanApplyDate.$pristine" class="help-block">Please enter a valid Date.</span></td>
        <td><form:errors path="eduLoanApplyDate" cssClass="error" /></td>
         </div>
    </tr> 
    
    <tr>
    <div class="form-group" ng-class="{ 'has-error' : userForm.eduLoanDuration.$invalid && !userForm.eduLoanDuration.$pristine }">
        <td><label> <strong><spring:message
								code="label.eduLoanDuration" /></strong>
				</label></td>
        <td><form:input path="eduLoanDuration" type="number" min="0" ng-model="eduLoanDuration" required="true" ng-pattern="/^(5|10)$/" style="margin-top: 25px;"/><span ng-show="userForm.eduLoanDuration.$invalid && !userForm.eduLoanDuration.$pristine" class="help-block">Loan Duration can be 5 or 10 years.</span></td>
        <td><form:errors path="eduLoanDuration" cssClass="error" /></td>
   </div>
    </tr>
     
    <tr>
    <div class="form-group" ng-class="{ 'has-error' : userForm.courseFee.$invalid && !userForm.courseFee.$pristine }">
        <td><label> <strong><spring:message
								code="label.courseFee" /></strong>
				</label></td>
        <td><form:input path="courseFee" type="number" min="1" max="50000" ng-model="courseFee" required="true" style="margin-top: 25px;" /><span ng-show="userForm.courseFee.$invalid && !userForm.courseFee.$pristine" class="help-block">Please enter course fees less than 50000.</span></td>
        <td><form:errors path="courseFee" cssClass="error" /></td>
    </div>
    </tr>
    
    
    <tr>
    <div class="form-group" ng-class="{ 'has-error' : userForm.courseName.$invalid && !userForm.courseName.$pristine }">
        <td><label> <strong><spring:message
								code="label.courseName" /></strong>
				</label></td>
        <td><form:input path="courseName" ng-model="courseName" required="true" style="margin-top: 25px;"  /><span ng-show="userForm.courseName.$invalid && !userForm.courseName.$pristine" class="help-block">Please enter a valid Course Name.</span></td>
        <td><form:errors path="courseName" cssClass="error" /></td>
    </div>
    </tr>
     
    
    <tr>
    <div class="form-group" ng-class="{ 'has-error' : userForm.fatherName.$invalid && !userForm.fatherName.$pristine }">
       <td><label> <strong><spring:message
								code="label.fatherName" /></strong>
				</label></td>
        <td><form:input path="fatherName" ng-model="fatherName" pattern="[a-zA-z\\s-]+" required="true" style="margin-top: 25px;" /><span ng-show="userForm.fatherName.$invalid && !userForm.fatherName.$pristine" class="help-block">Father Name can contain only alphabets and spaces.</span></td>
        <td><form:errors path="fatherName" cssClass="error" /></td>
    </div>
    </tr>
     
    <tr>
    <div class="form-group" ng-class="{ 'has-error' : userForm.idNumber.$invalid && !userForm.idNumber.$pristine }">
        <td><label> <strong><spring:message
								code="label.idNumber" /></strong>
				</label></td>
        <td><form:input path="idNumber" ng-model="idNumber" type="number" min="1000000000000000" max="9999999999999999" required="true" style="margin-top: 25px;" /><span ng-show="userForm.idNumber.$invalid && !userForm.idNumber.$pristine" class="help-block">Id Number should be 16 digits.</span></td>
        <td><form:errors path="idNumber" cssClass="error" /></td>
     </div>
    </tr>
    
    <tr>
    <div class="form-group" ng-class="{ 'has-error' : userForm.fatherAnnualIncome.$invalid && !userForm.fatherAnnualIncome.$pristine }">
       <td><label> <strong><spring:message
								code="label.fatherAnnualIncome" /></strong>
				</label></td>
        <td><form:input path="fatherAnnualIncome" ng-model="fatherAnnualIncome" min="0" type="number" required="true" style="margin-top: 25px;"/><span ng-show="userForm.fatherAnnualIncome.$invalid && !userForm.fatherAnnualIncome.$pristine" class="help-block">Please enter a valid Income.</span></td>
        <td><form:errors path="fatherAnnualIncome" cssClass="error" /></td>
        </div>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="${labelSubmit}" ng-disabled="userForm.$invalid"></td>
    </tr>
</table>
</center>
</form:form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);
	
	app.controller('AppCtrl', function($scope){
		$scope.eduLoanAmount = "";
		$scope.eduLoanApplyDate = "";
		$scope.eduLoanDuration = "";
		$scope.courseFee = "";
		$scope.courseName = "";
		$scope.fatherName = "";
		$scope.idNumber = "";
	})
</script>

</body>
</html>