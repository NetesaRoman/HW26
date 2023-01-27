package com.example.hw26.repositories;

import com.example.hw26.model.Student;

import java.util.List;


/*
 *
 * @author Roman Netesa
 *
 */
public interface CustomStudentRepository {



    List<Student> findStudentByEmail(String email);


}
