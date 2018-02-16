  app = angular.module('app',[]);
  app.controller('MyCtrl',function($scope,$http) {
     refreshData();
     $scope.addData = function() {
       $http.post("crudEmp?empCode=" + $scope.empCode + "&empName=" + $scope.empName + "&dmlType=Ins")
        .success(function(response) {
            refreshData();
        });
      };

     $scope.updateData = function() {
       $http.post("crudEmp?empCode=" + $scope.empCode + "&empName=" + $scope.empName + "&dmlType=Upd")
        .success(function(response) {
           refreshData();
        });
     };

     $scope.deleteData = function(curData) {
        $http.post("crudEmp?empCode=" + curData.emp_code + "&empName=" + curData.emp_name + "&dmlType=Del")
        .success(function(response) {
            refreshData();
        });
     };
     
     $scope.copyData = function (emp){
         $scope.empCode = emp.emp_code;
         $scope.empName = emp.emp_name;
     };
     
     function clearForm(){
         $scope.empCode="";
         $scope.empName="";
     };
     
     function refreshData() {
       clearForm();  
       getEmpNames();
       $http.get("getEmp")
       .success(function(response) {
            $scope.empArr = response;
        })
       .error(function(response) {
   	     $scope.empArr={};
       });
     };

  });

