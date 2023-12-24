package com.sms.SchoolManagementSystem.controller;

import com.sms.SchoolManagementSystem.SchoolManagementSystemApplication;
import com.sms.SchoolManagementSystem.entity.Teacher;

import com.sms.SchoolManagementSystem.service.TeacherService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {

	private TeacherService teacherService;

	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}
	
	// handler method to handle list teachers and return mode and view
	@GetMapping("/teachers")
	public String listteachers(Model model) {
		Authentication authentication = SchoolManagementSystemApplication.authenticatedUser;

		// Check if the user is authenticated

		if (authentication!= null){

			model.addAttribute("adminRole", authentication.getAuthorities().stream()
					.anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN")));
			model.addAttribute("userRole", authentication.getAuthorities().stream()
					.anyMatch(auth -> auth.getAuthority().equals("ROLE_USER")));

			model.addAttribute("teachers", teacherService.getAllTeachers());
			return "teachers";
		}else{
			return "redirect:/login";
		}

	}
	
	@GetMapping("/teachers/new")
	public String createteacherForm(Model model) {

		Authentication authentication = SchoolManagementSystemApplication.authenticatedUser;

		// Check if the user is authenticated

		if (authentication!= null ){
			model.addAttribute("adminRole", authentication.getAuthorities().stream()
					.anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN")));
			// create teacher object to hold teacher form data
			if( model.getAttribute("adminRole") == null) {
				return "redirect:/home";
			}
			Teacher teacher = new Teacher();
			model.addAttribute("teacher", teacher);
			return "create_teacher";
		}else{
			return "redirect:/login";
		}

		
	}
	
	@PostMapping("/teachers")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherService.saveTeacher(teacher);
		return "redirect:/teachers";
	}
	
	@GetMapping("/teachers/edit/{id}")
	public String editTeacherForm(@PathVariable Long id, Model model) {
		Authentication authentication = SchoolManagementSystemApplication.authenticatedUser;
		if (authentication!= null){
			// create teacher object to hold teacher form data
			model.addAttribute("teacher", teacherService.getTeacherById(id));
			return "edit_teacher";
		}else{
			return "redirect:/login";
		}

	}

	@PostMapping("/teachers/{id}")
	public String updateTeacher(@PathVariable Long id,
			@ModelAttribute("teacher") Teacher teacher,
			Model model) {
		
		// get teacher from database by id
		Teacher existingTeacher = teacherService.getTeacherById(id);
		existingTeacher.setId(id);
		existingTeacher.setName(teacher.getName());
		existingTeacher.setPhone(teacher.getPhone());
		existingTeacher.setEmail(teacher.getEmail());
		
		// save updated teacher object
		teacherService.updateTeacher(existingTeacher);
		return "redirect:/teachers";
	}
	
	// handler method to handle delete teacher request
	
	@GetMapping("/teachers/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		Authentication authentication = SchoolManagementSystemApplication.authenticatedUser;
		if (authentication!= null){
			teacherService.deleteTeacherById(id);
			return "redirect:/teachers";
		}else{
			return "redirect:/login";
		}

	}
	
}
