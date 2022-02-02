package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	// Injecting Service class
	@Autowired
	private EmployeeService employeeService;

	// Display List of Employee
	// @RequestMapping("/")
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployee());
		return "index";
	}

	// Link to the Page Only
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// Create Model Attribute to bind Form Data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	// Mapping the Form Action
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save Employee to Database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

	// For Update
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		// get Employee From the Service
		Employee employee = employeeService.getEmpoyeeById(id);
		// set Employee as a model attribute to prepopulate the form
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	// To Delete
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
		// call Delete employee method
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/"; 
	}
}
