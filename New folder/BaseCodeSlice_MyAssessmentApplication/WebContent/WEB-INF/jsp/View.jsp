<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<title>Insert title here</title>
</head>
<body ng-app="myApp">

	<!-- Please add your application links by replacing the below sample links -->
	<br>
	<!-- <a href="#">Sample Link 1</a> -->
	<div ng-controller="EmpCtrl">
     
      <input type ="text" ng-model="startDate" placeholder="Search" />
      <input type ="button" value="Show" ng-click="showTrainer(startDate)">
       <hr/>
    
        <table>
        
        <tr>
            <td>S. No</td>
                <td>Trainer</td>
                <td>College</td>
                <td>Domain</td>
                <td>Date</td>
                <td>Duration</td>
                
                
           </tr>
          <tr ng-repeat="trainers2 in trainers1 | filter: search"> 
                <td>{{$index + 1}}</td>
                <td>{{trainers2.trainer.trainerName}}</td>
                <td>{{trainers2.trainer.collegeName}}</td>
                <td>{{trainers2.trainer.domain}}</td>
                <td>{{trainers2.startDate}}</td>
                <td>{{trainers2.duration}}</td>
                
               
                  
            
            </tr>
        </table> 
        
          
    </div>
   
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
        	$scope.showTrainer = function(startDate)
        	{
             console.log(startDate);
            $http({
              method: 'GET',
              url: 'viewtrainer1',
              params: {"startDate":startDate}
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.data = data;
            	$scope.trainers1 = data;
            })
        
           
        }})
    </script>

</body>
</html>