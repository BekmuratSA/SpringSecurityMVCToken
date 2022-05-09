package com.peaksoft.SpringSecurityMVCToken.mappers.teacher;

import com.peaksoft.SpringSecurityMVCToken.dto.teacher.TeacherResponse;
import com.peaksoft.SpringSecurityMVCToken.models.Teacher;
import com.peaksoft.SpringSecurityMVCToken.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TeacherViewMapper {

    private final TeacherRepository repository;

    public TeacherResponse viewTeacher(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        TeacherResponse response = new TeacherResponse();
        if (teacher.getId() != null) {
            response.setId(teacher.getId());
        }
        response.setFirstname(teacher.getFirstname());
        response.setLastname(teacher.getLastname());
        response.setEmail(teacher.getEmail());
        response.setCourse(teacher.getCourse());
        return response;
    }

    public List<TeacherResponse> viewTeachers(List<Teacher> teachers) {
        List<TeacherResponse> responses = new ArrayList<>();
        for (Teacher teacher : teachers) {
            responses.add(viewTeacher(teacher));
        }
        return responses;
    }

    public List<Teacher> searchByNameAndLastnameAndEmailAndCourseName(String name, Pageable pageable) {
        String text = name == null ? "" : name;
        return repository.search(text.toUpperCase(), pageable);
    }
}
