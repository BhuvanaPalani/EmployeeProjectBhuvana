package com.example.Assignment2ClientForAssignment1;

import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeInfo {
	
	EmployeeClient employeeClient = new EmployeeClient(); 
	Scanner scanner = new Scanner(System.in);
	
    public EmployeeInfo() {
		
	}

	public void run() {
		
		System.out.println("Welcome to the employee details. Select one of the following.");
		System.out.println("1. List of all the People.");
		System.out.println("2. Information about a Employee.");
		System.out.println("3. Add a Employee Detail.");
		System.out.println("4. Update the Designation of a Employee.");
		System.out.println("5. Delete a Employee Detail.");
		String choice = scanner.nextLine();
		switch(choice) {
		case "1":
			printAllPeople();
			break;
		case "2":
			printEmployee();
			break;
		case "3":
			addEmployee();
			break;
		case "4":
			updateDesignation();
			break;
		case "5":
			deleteEmployee();
			break;
	}
	}
		
		private void printAllPeople() {
			ArrayList<Employee> people = employeeClient.getAllPeople();
			for(Employee employee : people) {
				System.out.println(employee.toString());
			}
		}
			
		private void printEmployee() {
			System.out.println("Which Employee Information Would You Like to Show?");
			String name = scanner.next();
			Employee employee = employeeClient.getEmployeeByName(name);
			
			if (employee != null) {
				System.out.println(employee.toString());
			}
			
		
		
	}

		private void addEmployee() {
			System.out.println("What is the Id of the Employee?");
			String id = scanner.next();
			System.out.println("What is the name of the Employee?");
			String name = scanner.next();
			System.out.println("What is the designation of the Employee?");
			String designation = scanner.next();
			System.out.println("What is the Salary of the Employee?");
			String salary = scanner.next();
			employeeClient.addEmployee(id, name, designation,salary);
		}
		
		private void updateDesignation() {
			System.out.println("What is the Name of the Employee ?");
			String name = scanner.next();
			System.out.println("What is the  New Designation of the Employee?");
			String newDesignation = scanner.next();	
			employeeClient.updateDesignation(name, newDesignation);
		}
		
		private void deleteEmployee() { 
			System.out.println("What is the Name of the Employee ?");
			String name = scanner.next();
			employeeClient.deleteEmployee(name);
		}



			
		}


