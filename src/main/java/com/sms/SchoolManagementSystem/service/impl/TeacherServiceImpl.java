package com.sms.SchoolManagementSystem.service.impl;

import com.sms.SchoolManagementSystem.entity.Student;
import com.sms.SchoolManagementSystem.entity.Teacher;
import com.sms.SchoolManagementSystem.repository.StudentRepository;
import com.sms.SchoolManagementSystem.repository.TeacherRepository;
import com.sms.SchoolManagementSystem.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherServiceImpl implements TeacherService {

	private TeacherRepository teacherRepository;

	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public Teacher getTeacherById(Long id) {
		return teacherRepository.findById(id).get();
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public void deleteTeacherById(Long id) {
		teacherRepository.deleteById(id);
	}

}
