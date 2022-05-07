package com.peaksoft.SpringSecurityMVCToken.mappers.course;

import com.peaksoft.SpringSecurityMVCToken.dto.course.CourseRequest;
import com.peaksoft.SpringSecurityMVCToken.models.Company;
import com.peaksoft.SpringSecurityMVCToken.models.Course;
import com.peaksoft.SpringSecurityMVCToken.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseEditMapper {

    private final CompanyRepository companyRepository;

    public Course createCourse(CourseRequest request) {
        if (request == null) {
            return null;
        }
        Course course = new Course();
        course.setCourseName(request.getCourse_name());
        course.setDuration(request.getDuration());

        Company company = companyRepository.findById(request.getCompany()).get();
        course.setCompany(company);
        return course;
    }

    public Course updateCourse(Course course, CourseRequest request) {
        course.setCourseName(request.getCourse_name());
        course.setDuration(request.getDuration());

        Company company = companyRepository.findById(request.getCompany()).get();
        course.setCompany(company);
        return course;
    }
}
