package com.example.hw26.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *
 * @author Roman Netesa
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "my_school")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String discipline;
    private Integer value;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_student_id")
    private Student student;

}
