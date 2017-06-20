<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css"> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First Page</title>

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
<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/performtransaction/${accountNumber}" modelAttribute="TransactionDetails" name="userForm">
<center>
<table>
<legend><span class="number">3</span> Transaction Details</legend>
<tr>
    
 <div class="form-group" ng-class="{ 'has-error' : userForm.transactionAmount.$invalid && !userForm.transactionAmount.$pristine }">    	
        <td>Transaction Amount:</td>
        <td><form:input path="transactionAmount" ng-model="transactionAmount"    required="true" ng-pattern="/^[0-9]{1,7}$/" style="margin-top: 25px;"/> <span ng-show="userForm.transactionAmount.$invalid && !userForm.transactionAmount.$pristine" class="help-block">Not a valid number!!!!!Please enter the amount</span></td> 
        <td><form:errors path="transactionAmount" cssClass="error" /></td>
        </div>
    </tr>
    

    
     <tr>
        <td>transactionType:</td>
       
        <td>
        <form:select path="transactionType" style="margin-top: 25px;" >
        <form:option value="NONE" label="Select"/>
               <form:options items="${transactionTypeList}" />
               </form:select>
        </td>
        <td><form:errors path="transactionType" cssClass="error" /></td>
    </tr>
    
    
    
     <tr>
       <div class="form-group" ng-class="{ 'has-error' : userForm.transactionDescription.$invalid && !userForm.transactionDescription.$pristine }">
        <td>Transaction Description :</td>
        <td><form:input path="transactionDescription"  ng-model="transactionDescription" required="true"  pattern="[a-zA-Z\\s-]+" style="margin-top: 25px;"/> <span ng-show="userForm.transactionDescription.$invalid && !userForm.transactionDescription.$pristine" class="help-block">Description cannot contain digits!!</span></td>
        <td><form:errors path="transactionDescription" cssClass="error" /></td>
  </div>
    </tr>
    
    
     <tr>
        <td colspan="2"><input type="submit" value="Add" ng-disabled="userForm.$invalid"></td>
    </tr>
    
</table>
</center>

</form:form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);
	
	app.controller('AppCtrl', function($scope){
		$scope.transactionAmount = "";
		$scope.transactionType = "";
		$scope.transactionDescription="";
	})
</script>
</body>

</html>