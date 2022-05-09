package com.peaksoft.SpringSecurityMVCToken.service;

import com.peaksoft.SpringSecurityMVCToken.dto.teacher.TeacherRequest;
import com.peaksoft.SpringSecurityMVCToken.dto.teacher.TeacherResponse;
import com.peaksoft.SpringSecurityMVCToken.dto.teacher.TeacherResponseView;
import com.peaksoft.SpringSecurityMVCToken.mappers.teacher.TeacherEditMapper;
import com.peaksoft.SpringSecurityMVCToken.mappers.teacher.TeacherViewMapper;
import com.peaksoft.SpringSecurityMVCToken.models.Teacher;
import com.peaksoft.SpringSecurityMVCToken.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;
    private final TeacherEditMapper editMapper;
    private final TeacherViewMapper viewMapper;

    public TeacherResponse createTeacher(TeacherRequest request) {
        Teacher teacher = editMapper.createTeacher(request);
        repository.save(teacher);
        return viewMapper.viewTeacher(teacher);
    }

    public TeacherResponse updateTeacher(TeacherRequest request, Long id) {
        Teacher teacher = repository.getById(id);
        editMapper.updateTeacher(teacher, request);
        return viewMapper.viewTeacher(repository.save(teacher));
    }

    public TeacherResponse getByIdTeacher(Long id) {
        Teacher teacher = repository.getById(id);
        return viewMapper.viewTeacher(teacher);
    }

    public List<TeacherResponse> getAllTeachers() {
        return viewMapper.viewTeachers(repository.findAll());
    }

    public TeacherResponse deleteByIdTeacher(Long id) {
        Teacher teacher = repository.getById(id);
        repository.deleteById(id);
        return viewMapper.viewTeacher(teacher);
    }

    public TeacherResponseView searchByNameAndLastnameAndEmailAndCourse(String name, int page, int size) {
        TeacherResponseView responseView = new TeacherResponseView();
        Pageable pageable = PageRequest.of(page, size);
        responseView.setTeacherResponses(viewMapper.viewTeachers(viewMapper
                .searchByNameAndLastnameAndEmailAndCourseName(name, pageable)));
        return responseView;
    }

    public Long countTeacher() {
        return repository.count();
    }
}
