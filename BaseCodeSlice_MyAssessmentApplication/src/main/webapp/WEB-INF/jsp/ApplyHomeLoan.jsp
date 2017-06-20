<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">  -->
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
<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/adduserhomeloandetails/${accountNumber}" modelAttribute="HomeLoanDetails" name="userForm">

<table>
    <legend><span class="number">1</span> Loan Details</legend>
    <tr>
         <div class="form-group" ng-class="{ 'has-error' : userForm.loanAmount.$invalid && !userForm.loanAmount.$pristine }">
         <td>Loan Amount :</td>
        <td><form:input path="loanAmount" type ="Number" ng-model="loanAmount" required="true" min ="1" style="margin-top: 25px;"/> <span ng-show="userForm.loanAmount.$invalid && !userForm.loanAmount.$pristine" class="help-block">Please enter a valid loan amount</span></td>
        <td><form:errors path="loanAmount" cssClass="error" /></td>
        </div>
    </tr>
     <tr>
      <div class="form-group" ng-class="{ 'has-error' : userForm.loanApplyDate.$invalid && !userForm.loanApplyDate.$pristine }">
        <td>Loan Apply Date :</td>
        <td><form:input path="loanApplyDate" type = "date"  ng-model="loanApplyDate" required="true" style="margin-top: 25px;"/><span ng-show="userForm.loanApplyDate.$invalid && !userForm.loanApplyDate.$pristine" class="help-block">Please enter a valid loan date</span></td>
        <td><form:errors path="loanApplyDate" cssClass="error" /></td>
        </div>
    </tr>
     <tr>
     <div class="form-group" ng-class="{ 'has-error' : userForm.loanDuration.$invalid && !userForm.loanDuration.$pristine }">
        <td>Duration of the Loan :</td>
        <td><form:input path="loanDuration" ng-model="loanDuration" required="true" type ="Number" ng-pattern = "/^(5|10|15|20)$/" style="margin-top: 25px;"/><span ng-show="userForm.loanDuration.$invalid && !userForm.loanDuration.$pristine" class="help-block">Please enter one of [5,10,15,20] years only</span></td>
        <td><form:errors path="loanDuration" cssClass="error" /></td>
        </div>
    </tr>
    
     <tr>
     <div class="form-group" ng-class="{ 'has-error' : userForm.annualIncome.$invalid && !userForm.annualIncome.$pristine }">
        <td>Annual Income :</td>
        <td><form:input path="annualIncome" ng-model="annualIncome" required="true" type ="Number" min ="0" style="margin-top: 25px;"/><span ng-show="userForm.annualIncome.$invalid && !userForm.annualIncome.$pristine" class="help-block">Please enter a valid Annual income</span></td>
        <td><form:errors path="annualIncome" cssClass="error" /></td>
        </div>
    </tr>
    <tr>
     <div class="form-group" ng-class="{ 'has-error' : userForm.companyName.$invalid && !userForm.companyName.$pristine }">
        <td>Company Name :</td>
        <td><form:input path="companyName" ng-model="companyName" required="true" type ="text" pattern="[a-zA-Z\\s-]+" style="margin-top: 25px;"/><span ng-show="userForm.companyName.$invalid && !userForm.companyName.$pristine" class="help-block">Only Alphabets and spaces are allowed</span></td>
        <td><form:errors path="companyName" cssClass="error" /></td>
        </div>
    </tr>
     <tr>
     <div class="form-group" ng-class="{ 'has-error' : userForm.designation.$invalid && !userForm.designation.$pristine }">
        <td>Designation :</td>
        <td><form:input path="designation" ng-model="designation" required="true" type ="text" pattern="[a-zA-Z\\s-]+" style="margin-top: 25px;"/></td>
        <td><form:errors path="designation" cssClass="error" /><span ng-show="userForm.designation.$invalid && !userForm.designation.$pristine" class="help-block">Only Alphabets and spaces are allowed</span></td>
      </div>
    </tr>
    <tr>
    <div class="form-group" ng-class="{ 'has-error' : userForm.totalExp.$invalid && !userForm.totalExp.$pristine }">
        <td>Total Experience :</td>
        <td><form:input path="totalExp" ng-model="totalExp" required="true" type ="Number" min="0" max= "99" style="margin-top: 25px;"/><span ng-show="userForm.totalExp.$invalid && !userForm.totalExp.$pristine" class="help-block">Please enter a valid experience</span></td>
        <td><form:errors path="totalExp" cssClass="error" /></td>
        </div>
    </tr>
     <tr>
      <div class="form-group" ng-class="{ 'has-error' : userForm.expCurrentDate.$invalid && !userForm.expCurrentDate.$pristine }">
        <td>Experience with current company :</td>
        <td><form:input path="expCurrentDate" ng-model="expCurrentDate" required="true" type ="Number" min ="0" max="99" style="margin-top: 25px;"/><span ng-show="userForm.expCurrentDate.$invalid && !userForm.expCurrentDate.$pristine" class="help-block">Please enter a valid experience</span></td>
        <td><form:errors path="expCurrentDate" cssClass="error" /></td>
        </div>
    </tr>
    
    
    <tr>
        <td colspan="2"><input type="submit" value="Add" ng-disabled="userForm.$invalid"></td>
        
    </tr>
</table>

</form:form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);
	
	app.controller('AppCtrl', function($scope){
		$scope.loanAmount = "";
		$scope.loanApplyDate = "";
		$scope.loanDuration = "";
		$scope.annualIncome = "";
		$scope.companyName = "";
		$scope.designation = "";
		$scope.totalExp = "";
		$scope.expCurrentDate = "";
		
		
		
	})
</script>


</body>
</html>