package com.peaksoft.SpringSecurityMVCToken.mappers.course;

import com.peaksoft.SpringSecurityMVCToken.dto.course.CourseResponse;
import com.peaksoft.SpringSecurityMVCToken.models.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseViewMapper {

    public CourseResponse viewCourse(Course course) {
        if (course == null) {
            return null;
        }
        CourseResponse response = new CourseResponse();
        if (course.getId() != null) {
            response.setId(course.getId());
        }
        response.setCourse_name(course.getCourseName());
        response.setDuration(course.getDuration());
        response.setCompany(course.getCompany());
        return response;
    }

    public List<CourseResponse> viewCourses(List<Course> courses) {
        List<CourseResponse> responses = new ArrayList<>();
        for (Course course : courses) {
            responses.add(viewCourse(course));
        }
        return responses;
    }
 }
