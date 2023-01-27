package com.example.hw26.service;

import com.example.hw26.dto.MarkDto;
import com.example.hw26.dto.StudentDto;
import com.example.hw26.model.Mark;
import com.example.hw26.model.Student;
import com.example.hw26.repositories.MarkRepository;
import com.example.hw26.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 *
 * @author Roman Netesa
 *
 */
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final MarkRepository markRepository;

    public void addNewStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setMarks(studentDto.getMarks());
        Student save = studentRepository.save(student);
        studentDto.setId(save.getId());

    }

    public void addNewMark(Integer studentId, MarkDto markDto){
        Mark mark = new Mark();
        mark.setDiscipline(markDto.getDiscipline());
        mark.setValue(markDto.getValue());
        mark.setStudent(studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found")));
        markRepository.save(mark);
    }

    public void updateStudent(Integer id, StudentDto studentDto) {
        Student student = new Student();
        student.setId(id);
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setMarks(studentDto.getMarks());
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public StudentDto getStudentById(Integer id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        return new StudentDto(student.getId(), student.getName(), student.getEmail(), student.getMarks());
    }

    public List<Student> getAllStudents() {
        ArrayList<Student> result = new ArrayList<>();
        studentRepository.findAll().forEach(result::add);
        return result;
    }

    public StudentDto getStudentByEmail(String email) {
        List<Student> students = studentRepository.findStudentByEmail(email);
        Student student = students.get(0);
        return new StudentDto(student.getId(), student.getName(), student.getEmail(), student.getMarks());
    }


}
