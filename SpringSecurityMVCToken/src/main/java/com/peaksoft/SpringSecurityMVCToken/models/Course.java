package com.peaksoft.SpringSecurityMVCToken.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(generator =  "course_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_gen", sequenceName = "course_seq", allocationSize = 1)
    private Long id;
    @Column(unique = true, length = 30)
    private String courseName;
    private int duration;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
