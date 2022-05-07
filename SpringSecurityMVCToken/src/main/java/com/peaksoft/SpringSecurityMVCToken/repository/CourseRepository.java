package com.peaksoft.SpringSecurityMVCToken.repository;

import com.peaksoft.SpringSecurityMVCToken.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
