package com.yassine.employee.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yassine.employee.entities.Employee;
import com.yassine.employee.service.EmployeeService;

@Controller
//Son rôle est de recevoir les requêtes HTTP (GET, POST) 
//et de retourner le nom d'une page HTML (la vue).
public class EmployeeController {

	@Autowired
	EmployeeService emps; // Ton service d'employés

	@RequestMapping("/myView")
	public String myView() {
		return "myView";
	}

	// 1. Lister les employés
	@RequestMapping("/ListeEmployee")
	public String listeEmployees(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		Page<Employee> lemp = emps.getAllEmployeesParPage(page, size);

		modelMap.addAttribute("employees", lemp);
		modelMap.addAttribute("pages", new int[lemp.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "ListeEmployee";
	}

	// 2. Afficher le formulaire de création
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createEmployee";
	}

	// 3. Sauvegarder un employé
	@RequestMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, @RequestParam("date") String date,
			ModelMap modelMap) {
		// Plus besoin de SimpleDateFormat ou de bloc try/catch ParseException !
		// On convertit directement le String (format yyyy-MM-dd) en LocalDate
		LocalDate dateNaiss = LocalDate.parse(date);
		employee.setDateNaiss(dateNaiss);

		Employee saveEmp = emps.saveEmployee(employee);

		String msg = "Employé enregistré avec Id " + saveEmp.getIdEmp();
		modelMap.addAttribute("msg", msg);
		return "createEmployee";
	}

	// 4. Supprimer un employé
	@RequestMapping("/supprimerEmployee")
	public String supprimerEmployee(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		emps.deleteEmployeeById(id);
		List<Employee> lemp = emps.getAllEmployees();
		modelMap.addAttribute("employees", lemp);
		return "ListeEmployee";
	}

	// 5. Charger les données d'un employé pour modification
	@RequestMapping("/modifierEmployee")
	public String editerEmployee(@RequestParam("id") Long id, ModelMap modelMap) {
		Employee e = emps.getEmployee(id);
		modelMap.addAttribute("employee", e);
		return "editerEmployee";
	}

	// 6. Mettre à jour (Update)
	@RequestMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute("employee") Employee employee, @RequestParam("date") String date,
			ModelMap modelMap) {

		LocalDate dateNaiss = LocalDate.parse(date);
		employee.setDateNaiss(dateNaiss);

		emps.updateEmployee(employee);
		List<Employee> lemp = emps.getAllEmployees();
		modelMap.addAttribute("employees", lemp);
		return "ListeEmployee";
	}
}