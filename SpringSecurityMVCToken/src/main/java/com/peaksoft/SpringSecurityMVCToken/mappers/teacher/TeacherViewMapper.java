package com.peaksoft.SpringSecurityMVCToken.mappers.teacher;

import com.peaksoft.SpringSecurityMVCToken.dto.teacher.TeacherResponse;
import com.peaksoft.SpringSecurityMVCToken.models.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherViewMapper {

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
}
