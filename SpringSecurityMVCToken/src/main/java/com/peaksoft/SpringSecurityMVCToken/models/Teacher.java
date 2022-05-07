package com.peaksoft.SpringSecurityMVCToken.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(generator = "teacher_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "teacher_gen", sequenceName = "teacher_seq", allocationSize = 1)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;


}
