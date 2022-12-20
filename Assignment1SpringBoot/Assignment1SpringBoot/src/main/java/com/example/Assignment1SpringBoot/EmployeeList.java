package com.example.Assignment1SpringBoot;

import java.util.ArrayList;

import org.springframework.stereotype.Component;





@Component
public class EmployeeList {
	
	ArrayList<Employee> employeeList = new ArrayList<>();
	 
	public EmployeeList() {
		employeeList.add(new Employee(123, "John", "Chief Engineer", 35000 ));
		employeeList.add(new Employee(246, "Anu", "Project Leader", 55000 ));
		employeeList.add(new Employee(369, "Lena", " Trainee", 25000 ));
		employeeList.add(new Employee(482, "Mathan", "Scrum Master", 45000 ));
		employeeList.add(new Employee(515, "Kathir", "Quality Checker", 30000 ));
		employeeList.add(new Employee(611, "Haasini", "Project Leader", 40000 ));
		employeeList.add(new Employee(712, "Nandhana", "Chief Engineer", 350000 ));
	}
	


	    public Employee getEmployeeByName(String name) {
		for(Employee employee : employeeList) {
			if (employee.getName().equals(name)) {
				return employee;
			}
		}
		return null;
	}

	public Employee[] getEmployeeAsArray() {
		Employee[] employeeArray = new Employee[employeeList.size()];
		for(int i = 0; i < employeeArray.length; i++) {
			employeeArray[i] = employeeList.get(i); 
		}
		return employeeArray;
	}

	public void add(Employee employee) {
		employeeList.add(employee);
	}

	public boolean changeDesignation(String name, String newDesignation) {
		for(Employee employee : employeeList) {
			if (employee.getName().equals(name)) {
				employee.setDesignation(newDesignation);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteEmployee(String name) {
		Employee employeeToDelete = null;
		for(Employee employee : employeeList) {
			if (employee.getName().equals(name)) {
				employeeToDelete = employee;
				break;
			}
		}
		
		if (employeeToDelete != null) {
			employeeList.remove(employeeToDelete);
			return true;
		}
		return false;
	}

     public void addEmployee(Employee employee) {
		
		
	}


	
}

