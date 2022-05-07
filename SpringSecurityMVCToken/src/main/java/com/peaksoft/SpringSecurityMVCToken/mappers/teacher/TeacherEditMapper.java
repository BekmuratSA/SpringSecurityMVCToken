package com.peaksoft.SpringSecurityMVCToken.mappers.teacher;

import com.peaksoft.SpringSecurityMVCToken.dto.teacher.TeacherRequest;
import com.peaksoft.SpringSecurityMVCToken.models.Course;
import com.peaksoft.SpringSecurityMVCToken.models.Teacher;
import com.peaksoft.SpringSecurityMVCToken.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherEditMapper {

    private final CourseRepository courseRepository;

    public Teacher createTeacher(TeacherRequest request) {
        if (request == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setFirstname(request.getFirstname());
        teacher.setLastname(request.getLastname());
        teacher.setEmail(request.getEmail());

        Course course = courseRepository.findById(request.getCourse()).get();
        teacher.setCourse(course);
        return teacher;
    }

    public Teacher updateTeacher(Teacher teacher, TeacherRequest request) {
        teacher.setFirstname(request.getFirstname());
        teacher.setLastname(request.getLastname());
        teacher.setEmail(request.getEmail());

        Course course = courseRepository.findById(request.getCourse()).get();
        teacher.setCourse(course);
        return teacher;
    }
}
