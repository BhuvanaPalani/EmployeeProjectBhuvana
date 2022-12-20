package com.example.Assignment1SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping
public class EmployeeController {
	
	//Employee employee = new Employee(123, "John", "Chief Engineer", 35000);
	
	
	@Autowired
	EmployeeList employeeList;
	
	
	
       @RequestMapping(value = "/employeebyname",  method = { RequestMethod.GET})
       public Employee getEmployee(String name) {
   		return employeeList.getEmployeeByName(name);
   	}
	
	@RequestMapping(value = "/employees",  method = { RequestMethod.GET})
	public Employee[] getEmployeeArray() {
		return employeeList.getEmployeeAsArray();
	}
	
	
	@RequestMapping(value = "/addemployee",  method = { RequestMethod.POST})
	public String addEmployee(Employee employee) { 
		employeeList.add(employee);
		return "Successfully Added!";
	}
	
	
	@RequestMapping(value = "/changeemployeedetail",  method = { RequestMethod.PUT})
	public ResponseEntity<String> changeDesignation(String name, String newDesignation) {
		boolean success = employeeList.changeDesignation(name, newDesignation);;
		
		if (success) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully Changed!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no such employee.");
	}
	
	@RequestMapping(value = "/deleteemployee",  method = { RequestMethod.DELETE})
	public ResponseEntity<String> deleteEmployee(String name) {
		boolean success = employeeList.deleteEmployee(name);
		if (success) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully Removed!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no such employee.");
	}
	
	
}

