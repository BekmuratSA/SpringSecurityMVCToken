package com.peaksoft.SpringSecurityMVCToken.service;

import com.peaksoft.SpringSecurityMVCToken.dto.student.StudentRequest;
import com.peaksoft.SpringSecurityMVCToken.dto.student.StudentResponse;
import com.peaksoft.SpringSecurityMVCToken.dto.student.StudentResponseView;
import com.peaksoft.SpringSecurityMVCToken.mappers.student.StudentEditMapper;
import com.peaksoft.SpringSecurityMVCToken.mappers.student.StudentViewMapper;
import com.peaksoft.SpringSecurityMVCToken.models.Student;
import com.peaksoft.SpringSecurityMVCToken.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final StudentEditMapper editMapper;
    private final StudentViewMapper viewMapper;

    public StudentResponse createStudent(StudentRequest request) {
        Student student = editMapper.createStudent(request);
        repository.save(student);
        return viewMapper.viewStudent(student);
    }

    public StudentResponse updateStudent(StudentRequest request, Long id) {
        Student student = repository.getById(id);
        editMapper.updateStudent(student, request);
        return viewMapper.viewStudent(repository.save(student));
    }

    public StudentResponse getByIdStudent(Long id) {
        Student student = repository.getById(id);
        return viewMapper.viewStudent(student);
    }

    public List<StudentResponse> getAllStudents() {
        return viewMapper.viewStudents(repository.findAll());
    }

    public StudentResponse deleteById(Long id) {
        Student student = repository.getById(id);
        repository.deleteById(id);
        return viewMapper.viewStudent(student);
    }

    public StudentResponseView searchAndPagination(String name, int page, int size) {
        StudentResponseView responseView = new StudentResponseView();
        Pageable pageable = PageRequest.of(page, size);
        responseView.setStudentResponses(viewMapper.viewStudents
                (viewMapper.search(name, pageable)));
        return responseView;
    }

    public Long countStudent() {
        return repository.count();
    }
}
