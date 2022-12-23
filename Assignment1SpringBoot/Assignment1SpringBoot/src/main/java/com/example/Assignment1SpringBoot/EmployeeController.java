package com.example.Assignment1SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
@RequestMapping
public class EmployeeController {
	

	
	
	@Autowired
	EmployeeList employeeList;
	
	 
	 @RequestMapping(value = "/company",  method = { RequestMethod.GET})
	 @ResponseBody
	 public String companyPage() {
		 return "company.jsp";
	 }
	 
	
	
       @RequestMapping(value = "/employeebyname",  method = { RequestMethod.GET})
       @ResponseBody
       public Employee getEmployee(String name) {
   		return employeeList.getEmployeeByName(name);
   	}
       
	@RequestMapping(value = "/employees",  method = { RequestMethod.GET})
	@ResponseBody
	public Employee[] getEmployeeArray() {
		return employeeList.getEmployeeAsArray();
	}
	
	
	@RequestMapping(value = "/addemployee",  method = { RequestMethod.POST})
	@ResponseBody
	public String addEmployee(Employee employee) { 
		employeeList.add(employee);
		return "Successfully Added!";
	}
	
	
	@RequestMapping(value = "/changeemployeedetail",  method = { RequestMethod.PUT})
	@ResponseBody
	public ResponseEntity<String> changeDesignation(String name, String newDesignation) {
		boolean success = employeeList.changeDesignation(name, newDesignation);;
		
		if (success) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully Changed!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no such employee.");
	}
	
	@RequestMapping(value = "/deleteemployee",  method = { RequestMethod.DELETE})
	@ResponseBody
	public ResponseEntity<String> deleteEmployee(String name) {
		boolean success = employeeList.deleteEmployee(name);
		if (success) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully Removed!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no such employee.");
	}
	
	
}

