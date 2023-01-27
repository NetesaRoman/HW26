package com.example.hw26;

import com.example.hw26.dto.MarkDto;
import com.example.hw26.dto.StudentDto;
import com.example.hw26.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Slf4j
public class Hw26Application {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(Hw26Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStarted(){

        studentService.updateStudent(1, new StudentDto( "SuperMegaOleg", "mega@mail"));
        studentService.addNewMark(1, new MarkDto("Math", 12));
        log.info(studentService.getStudentByEmail("mega@mail").info());
    }
}
