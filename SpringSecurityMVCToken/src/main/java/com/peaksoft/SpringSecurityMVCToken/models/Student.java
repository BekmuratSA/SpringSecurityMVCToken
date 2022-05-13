package com.peaksoft.SpringSecurityMVCToken.models;

import com.peaksoft.SpringSecurityMVCToken.enam.StudyFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator = "student_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_gen", sequenceName = "student_seq", allocationSize = 1)
    private Long id;
    @Column(unique = true, length = 30)
    private String firstname;
    private String lastname;
    @Column(unique = true, length = 45)
    private String email;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
