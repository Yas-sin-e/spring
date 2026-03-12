package com.yassine.employee.controllers;

import java.time.LocalDate;
import java.util.List;

import com.yassine.employee.entities.Grade;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
			@RequestParam(name = "size", defaultValue = "4") int size) {
		Page<Employee> lempPage = emps.getAllEmployeesParPage(page, size);

		modelMap.addAttribute("employees", lempPage);
		modelMap.addAttribute("pages", new int[lempPage.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "ListeEmployee";
	}

	// 2. Afficher le formulaire de création
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Grade> grades = emps.getAllGrades();
		modelMap.addAttribute("employee", new Employee());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("grades", grades);
		return "formEmployee";
	}

	// 3. Sauvegarder un employé
	@RequestMapping("/saveEmployee")
	public String saveEmployee(@Valid Employee employee, BindingResult bindingResult,
							   @RequestParam(name="page", defaultValue="0") int page,
							   @RequestParam(name="size", defaultValue="4") int size) {

		int currentPage;
		boolean isNew = false;

		if (bindingResult.hasErrors()) return "formEmployee";

		if (employee.getIdEmp() == null) isNew = true; // ajout

		emps.saveEmployee(employee);

		if (isNew) {
			Page<Employee> empPage = emps.getAllEmployeesParPage(page, size);
			currentPage = empPage.getTotalPages() - 1; // aller à la dernière page
		} else {
			currentPage = page; // rester sur la page courante pour la modification
		}

		return "redirect:/ListeEmployee?page=" + currentPage + "&size=" + size;
	}

	// 4. Supprimer un employé
	@RequestMapping("/supprimerEmployee")
	public String supprimerEmployee(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size) {

		emps.deleteEmployeeById(id);
		Page<Employee> lemp = emps.getAllEmployeesParPage(page, size);
		// 3. On remet tout dans le modelMap pour que le HTML puisse l'afficher
		modelMap.addAttribute("employees", lemp);
		modelMap.addAttribute("pages", new int[lemp.getTotalPages()]);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "ListeEmployee";
	}

	// 5. Charger les données d'un employé pour modification
	@RequestMapping("/modifierEmployee")
	public String editerEmployee(@RequestParam("id") Long id, ModelMap modelMap,@RequestParam(name = "page", defaultValue = "0") int page,
								 @RequestParam(name = "size", defaultValue = "4") int size){
		Employee e = emps.getEmployee(id);
		List<Grade> grades = emps.getAllGrades();
		modelMap.addAttribute("employee", e);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("grades", grades);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formEmployee";
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