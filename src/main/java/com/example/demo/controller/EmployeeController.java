package com.example.demo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Employee;
import com.example.demo.model.Task;

import com.example.demo.service.EmployeeService;
import com.example.demo.service.TaskService;


@Controller

@SessionAttributes("employeelog")

public class EmployeeController {

	@Autowired

	private EmployeeService service;

	@Autowired

	private TaskService taskservice;

	@Autowired

	

	public static String temp;

	@GetMapping("/login")

	public String login(Model employeedetails) {

		employeedetails.addAttribute("employee", new Employee());

		return "/login";

	}

	@RequestMapping("/login")

	public String loginpage()

	{

		return "login.html";

	}
	
	@GetMapping(value="/logout")
	
	public String logoutpage()
	{
		return "login.html";
	}

	@PostMapping("/login")

	public String logindata(@Valid @ModelAttribute("employee") Employee employeelog, BindingResult result,

			HttpSession session) {

		if (result.hasErrors()) {

			System.out.println("error");

			System.out.println(result.getFieldError());

			return "/login";

		}

		if (service.findByEmpnameAndEmppassword(employeelog.getEmpname(), employeelog.getEmppassword()) != null) {

			Employee sc = service.findByEmpnameAndEmppassword(employeelog.getEmpname(), employeelog.getEmppassword());

			session.setAttribute("sc", sc);

			temp = sc.getEmpname();

			if (sc.getLevel().equals("50")) {

				return "redirect:/developer1";

			} else if (sc.getLevel().equals("51")) {

				return "redirect:/lead1";

			} else if (sc.getLevel().equals("52")) {

				return "redirect:/manager1";

			}

		}

		return "redirect:/login";

	}

	/*
	 * @GetMapping("/employee")
	 * 
	 * want to return some data
	 * 
	 * public String logform(Principal principal, Authentication authentication,
	 * Model model, HttpSession session)
	 * 
	 * {
	 * 
	 * UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	 * 
	 * System.out.println("User has authorities: " + userDetails);
	 * 
	 * Employee sc = service.findByEmpnameAndEmppassword(principal.getName(),
	 * userDetails.getPassword());
	 * 
	 * session.setAttribute("sc", sc);
	 * 
	 * System.out.println("User has authorities: " + sc.getLevel());
	 * 
	 * System.out.println("User has authorities: " + userDetails);
	 * 
	 * if (sc.getLevel().equals("50")) {
	 * 
	 * return "redirect:/developer1";
	 * 
	 * } else if (sc.getLevel().equals("51")) {
	 * 
	 * return "redirect:/lead1";
	 * 
	 * } else if (sc.getLevel().equals("52")) {
	 * 
	 * return "redirect:/manager1";
	 * 
	 * }
	 * 
	 * return "redirect:/login";
	 * 
	 * }
	 */

	@RequestMapping("/developer")

	public String showDeveloper() {

		return "developer.html";

	}

	@RequestMapping("/lead")

	public String showLead() {

		return "lead.html";

	}

	@RequestMapping("/manager")

	public String showManager() {

		return "manager.html";

	}

	@RequestMapping("/developer1")

	public String showDeveloper(Model model, HttpSession session) {

		Employee t1 = (Employee) session.getAttribute("sc");

		System.out.println(t1.getEmpname());

		System.out.println(taskservice.gettask(t1.getEmpname()));

		model.addAttribute("taskdesc", taskservice.gettask(t1.getEmpname()));

		

		return "developer.html";

	}

	@RequestMapping("/lead1")

	public String showLead(Model model, HttpSession session) {

		Employee t1 = (Employee) session.getAttribute("sc");

		System.out.println(t1.getEmpname());

		System.out.println(service.FindByLevel("50"));

		model.addAttribute("associates", service.FindByLevel("50"));

		System.out.println(taskservice.gettask(t1.getEmpname()));

		model.addAttribute("taskdesc", taskservice.gettask(t1.getEmpname()));

		
		return "lead.html";

	}

	@RequestMapping("/manager1")

	public String showManager(Model model, HttpSession session) {

		Employee t1 = (Employee) session.getAttribute("sc");

		System.out.println(t1.getEmpname());

		System.out.println(service.FindAllByLevelOrLevel("50", "51"));

		model.addAttribute("levels", service.FindByLevel("51"));

		model.addAttribute("associates", service.FindByLevel("50"));

		System.out.println(taskservice.findAllByAssigneetask(t1.getEmpname()));

		model.addAttribute("taskassigns", taskservice.findAllByAssigneetask(t1.getEmpname()));

		

		return "manager.html";

	}

	@RequestMapping("/assign_task")

	public String assign_task(HttpSession session, Model model) {

		model.addAttribute("associates", service.FindAllByLevelOrLevel("50", "51"));

		System.out.println(service.FindAllByLevelOrLevel("50", "51"));

		if (session.getAttribute("sc") != null) {

			System.out.println("session is not exists");

			System.out.println(session.getAttribute("sc"));

		}

		return "assign_task";

	}

	@PostMapping("/assign_task")

	public String getassigntask(@Valid Task task, BindingResult error, HttpSession session) {

		if (error.hasErrors()) {

			System.out.println(error.getAllErrors());

			System.out.println(task);

			return "assign_task";

		}

		taskservice.Save(task);

		return "redirect:/manager1";

	}

	@RequestMapping("/assign_certification")

	public String assign_certification(HttpSession session, Model model) {

		model.addAttribute("associates", service.FindAllByLevelOrLevel("50", "51"));

		System.out.println(service.FindAllByLevelOrLevel("50", "51"));

		if (session.getAttribute("sc") != null) {

			System.out.println("session is not exists");

			System.out.println(session.getAttribute("sc"));

		}

		return "assign_certification";

	}

	

	@RequestMapping("/progress/{id}")

	public String getstatus(@PathVariable(value = "id") String certdesc, @PathParam(value = "status") String status,
			@Valid  BindingResult error, HttpSession session) {

//           Certification certification1=certificationservice.FindById(name);

//           certification1.setStatus(status);

		
		

		return "/progress";

	}

	@PostMapping("/progress/{id}")

	public String setstatus(@PathParam(value = "status") String status, @Valid
			BindingResult error, HttpSession session) {

		return "redirect:/login";

	}
	
	
	
	
	 @PostMapping("/progress")
	    public String getSearchResultViaAjax(
	            @Valid @RequestBody Errors error) {
		 if (error.hasErrors()) {

				System.out.println(error.getAllErrors());

				

				return "assign_certification";

			}
		 
		 
		return "/progress";
		 
	 
		 
	 }

}