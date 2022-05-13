package com.peaksoft.SpringSecurityMVCToken.repository;

import com.peaksoft.SpringSecurityMVCToken.models.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select c from Course c inner join c.company com where upper(c.courseName) " +
            "like concat('%', :name, '%') or upper(com.companyName) like concat('%', :name, '%') ")
    List<Course> searchByNameAndCompanyName(@Param("name") String name, Pageable pageable);
}
