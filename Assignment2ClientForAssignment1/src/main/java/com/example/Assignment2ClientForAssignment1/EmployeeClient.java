package com.example.Assignment2ClientForAssignment1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class EmployeeClient {

	public ArrayList<Employee> getAllPeople() {
		try {
			URL url = new URL("http://localhost:8080/employees");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
			int code = connection.getResponseCode();
			if (code == 200) {
				InputStream inputStream = connection.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader in = new BufferedReader(inputStreamReader);
				
				String inputLine = in.readLine();
				
				String jsonString = "";
				
				while (inputLine != null) {
					jsonString += inputLine;
					inputLine = in.readLine();
				}
				
				JSONParser jsonParser = new JSONParser();
				JSONArray jsonArrayObject = (JSONArray) jsonParser.parse(jsonString); 
				
				ArrayList<Employee> employeeList = new ArrayList<>();
				
				for(Object object : jsonArrayObject) { 
					JSONObject jsonObject = (JSONObject)object; 
					
					Employee employee = new Employee(); 
					employee.setId((long)jsonObject.get("id"));
					employee.setName((String)jsonObject.get("name"));
					employee.setSalary((long)jsonObject.get("salary"));
					employee.setDesignation((String)jsonObject.get("designation"));
					
					employeeList.add(employee); 
				}
				
				return employeeList;
			}
			else {
				System.out.println("Error Occured. Error code: " + code);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	

	public Employee getEmployeeByName(String name) {
		try { 
			URL url = new URL("http://localhost:8080/employeebyname?name=" + name); 
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
			connection.setRequestMethod("GET"); 
			connection.connect();
			
			int code = connection.getResponseCode(); 
			if (code == 200) { 
				InputStream inputStream = connection.getInputStream(); 
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream); 
				BufferedReader in = new BufferedReader(inputStreamReader); 
				
				

                 String jsonString = "";
				
				String inputLine = in.readLine(); 
				while (inputLine != null) { 
					jsonString += inputLine; 
					inputLine = in.readLine(); 
				}				
				 if(jsonString == "") {
					 return null;
				 }
				
				JSONParser jsonParser = new JSONParser(); 
				JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString); 	
					
					Employee employee = new Employee(); 
					employee.setId((long)jsonObject.get("id"));
					employee.setName((String)jsonObject.get("name"));
					employee.setSalary((long)jsonObject.get("salary"));
					employee.setDesignation((String)jsonObject.get("designation"));
					return employee;
			}
			else {
				System.out.println("Error Found. Error code: " + code); 
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	

	public void updateDesignation(String name, String newDesignation) {
		try {
			URL url = new URL("http://localhost:8080/changeemployeedetail?name=" + name + "&newDesignation=" + newDesignation); 
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("PUT");
			connection.connect();
			
			int code = connection.getResponseCode();
			if (code == 202) {
				System.out.println("The Designation has successfully Changed.");
			}
			else if (code == 404) {
				System.out.println("There is no employee with that name.");
			}
			else if (code == 400) {
				System.out.println("Is it a correct form of name?");
			}
			else {
				System.out.println("Update Failed. Error code: " + code);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}

		
		
	}

	public void addEmployee(String id, String name, String designation , String salary) {
		try { 
			int numberId = Integer.parseInt(id);
			int numberSalary = Integer.parseInt(salary);
		
		}
		catch(Exception e) {
			System.out.println("Enter the correct Id Format."); 
			System.out.println("Enter the correct Salary Format."); 
			return;
		}
		
		try {
			URL url = new URL("http://localhost:8080/addemployee?name=" + name + "&id=" + id + "&designation=" + designation+ "&salary=" + salary);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.connect();
			
			int code = connection.getResponseCode(); 
			if (code <= 404) { 
				System.out.println(name + " successfully added!");
			}
			else if (code == 412) {
				System.out.println("The given information is not correct.");
			}
			else {
				System.out.println("The information is not added successfully. Error code: " + code);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
		public void deleteEmployee(String name) {
			try {
				URL url = new URL("http://localhost:8080/deleteemployee?name=" + name);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("DELETE");
				connection.connect();
				
				int code = connection.getResponseCode();
				if (code <=400) {
					System.out.println("The Employe Detail is Successfully Deleted.");
				}
				else if (code == 400) {
					System.out.println("The given Name is not correct.");
				}
				else if (code == 401) {
					System.out.println("The Value of the Name is Wrong.");
				}
				else {
					System.out.println("It is not deleted successfully. Error code: " + code);
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		
		
	}



}

	


