package com.peaksoft.SpringSecurityMVCToken.mappers.student;

import com.peaksoft.SpringSecurityMVCToken.dto.student.StudentRequest;
import com.peaksoft.SpringSecurityMVCToken.models.Group;
import com.peaksoft.SpringSecurityMVCToken.models.Student;
import com.peaksoft.SpringSecurityMVCToken.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentEditMapper {

    private final GroupRepository groupRepository;

    public Student createStudent(StudentRequest request) {
        if (request == null) {
            return  null;
        }
        Student student = new Student();
        student.setFirstname(request.getFirstname());
        student.setLastname(request.getLastname());
        student.setEmail(request.getEmail());
        student.setStudyFormat(request.getStudy_format());

        Group group = groupRepository.findById(request.getGroup()).get();
        student.setGroup(group);
        return student;
    }

    public Student updateStudent(Student student, StudentRequest request) {
        student.setFirstname(request.getFirstname());
        student.setLastname(request.getLastname());
        student.setEmail(request.getEmail());
        student.setStudyFormat(request.getStudy_format());

        Group group = groupRepository.findById(request.getGroup()).get();
        student.setGroup(group);
        return student;
    }
}
