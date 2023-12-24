package com.sms.SchoolManagementSystem.service;

import com.sms.SchoolManagementSystem.entity.Student;
import com.sms.SchoolManagementSystem.entity.Teacher;

import java.util.List;


public interface TeacherService {
	List<Teacher> getAllTeachers();
	
	Teacher saveTeacher(Teacher teacher);

	Teacher getTeacherById(Long id);

	Teacher updateTeacher(Teacher teacher);
	
	void deleteTeacherById(Long id);
}
