package com.peaksoft.SpringSecurityMVCToken.mappers.student;

import com.peaksoft.SpringSecurityMVCToken.dto.student.StudentResponse;
import com.peaksoft.SpringSecurityMVCToken.models.Student;
import com.peaksoft.SpringSecurityMVCToken.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentViewMapper {

    private final StudentRepository repository;

    public StudentResponse viewStudent(Student student) {
        if (student == null) {
            return null;
        }
        StudentResponse response = new StudentResponse();
        if (student.getId() != null) {
            response.setId(student.getId());
        }
        response.setFirstname(student.getFirstname());
        response.setLastname(student.getLastname());
        response.setEmail(student.getEmail());
        response.setStudy_format(student.getStudyFormat());
        response.setGroup(student.getGroup());
        return response;
    }

    public List<StudentResponse> viewStudents(List<Student> students) {
        List<StudentResponse> responses = new ArrayList<>();
        for (Student student : students) {
            responses.add(viewStudent(student));
        }
        return responses;
    }

    public List<Student> searchStudentName(String name, Pageable pageable) {
        String text = name == null ? "" : name;
        return repository.searchByName(text.toUpperCase(), pageable);
    }
}
