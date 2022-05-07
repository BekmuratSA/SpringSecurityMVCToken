package com.peaksoft.SpringSecurityMVCToken.service;

import com.peaksoft.SpringSecurityMVCToken.dto.course.CourseRequest;
import com.peaksoft.SpringSecurityMVCToken.dto.course.CourseResponse;
import com.peaksoft.SpringSecurityMVCToken.mappers.course.CourseEditMapper;
import com.peaksoft.SpringSecurityMVCToken.mappers.course.CourseViewMapper;
import com.peaksoft.SpringSecurityMVCToken.models.Course;
import com.peaksoft.SpringSecurityMVCToken.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final CourseEditMapper editMapper;
    private final CourseViewMapper viewMapper;

    public CourseResponse createCourse(CourseRequest request) {
        Course course = editMapper.createCourse(request);
        repository.save(course);
        return viewMapper.viewCourse(course);
    }

    public CourseResponse updateCourse(CourseRequest request, Long id) {
        Course course = repository.getById(id);
        editMapper.updateCourse(course, request);
        return viewMapper.viewCourse(repository.save(course));
    }

    public CourseResponse getByIdCourse(Long id) {
        Course course = repository.getById(id);
        return viewMapper.viewCourse(course);
    }

    public List<CourseResponse> getAllCourses() {
        return viewMapper.viewCourses(repository.findAll());
    }

    public CourseResponse deleteByIdCourse(Long id) {
        Course course = repository.getById(id);
        repository.deleteById(id);
        return viewMapper.viewCourse(course);
    }
}
