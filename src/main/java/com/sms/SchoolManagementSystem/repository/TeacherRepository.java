package com.sms.SchoolManagementSystem.repository;

import com.sms.SchoolManagementSystem.entity.Student;
import com.sms.SchoolManagementSystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
