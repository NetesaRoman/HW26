package com.example.hw26.repositories;

import com.example.hw26.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 *
 * @author Roman Netesa
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer>, CustomStudentRepository {
}
