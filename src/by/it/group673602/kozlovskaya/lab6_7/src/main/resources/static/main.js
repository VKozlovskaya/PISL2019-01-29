var app = angular.module("EmployeeManagement", []);

// Controller Part
app.controller("EmployeeController", function($scope, $http) {


    $scope.employees = [];
    $scope.employeeForm = {
        login: 1,
        lastName: "",
        firstName: "",
        thirdName: "",
        passport: {
            seria: "",
            number: "",
            idNumber: ""
        },
        birthDate: "",
        gender: "",
        address: {
            actualCity: "",
            actualAddress: "",
            releaseCity: "",
            releaseAddress: ""
        },
        nation: "",
        phone: "",
        homePhone: ""
    };

    // Now load the data from server

    _refreshEmployeeData();

    // HTTP POST/PUT methods for add/edit employee
    // Call: http://localhost:8080/employee

    $scope.submitEmployee = function() {

        var method = "";
        var url = "";

        if ($scope.employeeForm.login == -1) {
            method = "POST";
            url = '/persons/person';
        } else {
            method = "PUT";
            url = '/persons/person/' + $scope.employeeForm.login;
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.employeeForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createEmployee = function() {
        _clearFormData();
    };

    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}

    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: '/persons/person/' + employee.login
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editEmployee = function(employee) {
        $scope.employeeForm.login = employee.login;
        $scope.employeeForm.firstName = employee.firstName;
        $scope.employeeForm.lastName = employee.lastName;
        $scope.employeeForm.thirdName = employee.thirdName;
        $scope.employeeForm.passport.seria = employee.passport.seria;
        $scope.employeeForm.passport.number = employee.passport.number;
        $scope.employeeForm.passport.idNumber = employee.passport.idNumber;
        $scope.employeeForm.birthDate = employee.birthDate;
        $scope.employeeForm.gender = employee.gender;
        $scope.employeeForm.address.actualAddress = employee.address.actualAddress;
        $scope.employeeForm.address.actualCity = employee.address.actualCity;
        $scope.employeeForm.address.releaseAddress = employee.address.releaseAddress;
        $scope.employeeForm.address.releaseCity = employee.address.releaseCity;
        $scope.employeeForm.nation = employee.nation;
        $scope.employeeForm.phone = employee.phone;
        $scope.employeeForm.homePhone = employee.homePhone;
    };

    // Private Method
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/employees
    function _refreshEmployeeData() {
        $http({
            method: 'GET',
            url: '/persons'
        }).then(
            function(res) { // success
                $scope.employees = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshEmployeeData();
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        $scope.employeeForm.login = -1;
        $scope.employeeForm.firstName = "";
        $scope.employeeForm.lastName = "";
        $scope.employeeForm.address.address = "";
        $scope.employeeForm.thirdName = "";
        $scope.employeeForm.passport.seria = "";
        $scope.employeeForm.passport.number = "";
        $scope.employeeForm.passport.idNumber = "";
        $scope.employeeForm.birthDate = "";
        $scope.employeeForm.gender = "";
        $scope.employeeForm.address.actualAddress = "";
        $scope.employeeForm.address.actualCity = "";
        $scope.employeeForm.address.releaseAddress = "";
        $scope.employeeForm.address.releaseCity = "";
        $scope.employeeForm.nation = "";
        $scope.employeeForm.phone = "";
        $scope.employeeForm.homePhone = "";
    };
});