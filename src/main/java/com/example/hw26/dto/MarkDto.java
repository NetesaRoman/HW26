package com.example.hw26.dto;

import com.example.hw26.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *
 * @author Roman Netesa
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {

    private Integer id;

    private String discipline;

    private Integer value;

    private Student student;

    public MarkDto(String discipline, Integer value){
        this.discipline = discipline;
        this.value = value;
    }
}
