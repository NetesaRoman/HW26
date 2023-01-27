package com.example.hw26.repositories;

import com.example.hw26.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

/*
 *
 * @author Roman Netesa
 *
 */
public class CustomStudentRepositoryImpl implements CustomStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Student> findStudentByEmail(String email) {
        Query query = entityManager
                .createQuery("select s from Student s where s.email like :email")
                .setParameter("email", email);
        return (List<Student>) query.getResultList();
    }

}
