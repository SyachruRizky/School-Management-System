package com.sms.SchoolManagementSystem.repository;

import com.sms.SchoolManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
