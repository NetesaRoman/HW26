package com.example.hw26.dto;

import com.example.hw26.model.Mark;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 *
 * @author Roman Netesa
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Integer id;

    private String name;

    private String email;

    List<Mark> marks;

    public StudentDto(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String info(){
        return new String("id: " + id + " name: " + name + " email: " + email);
    }
}
