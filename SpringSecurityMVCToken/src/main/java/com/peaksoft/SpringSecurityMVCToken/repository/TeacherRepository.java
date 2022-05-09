package com.peaksoft.SpringSecurityMVCToken.repository;

import com.peaksoft.SpringSecurityMVCToken.models.Teacher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("select t from Teacher t inner join t.course c where upper(t.firstname) " +
            "like concat('%', :name, '%') or upper(c.courseName) like concat('%', :name, '%')" +
            "or upper(t.email) like concat('%', :name, '%')")
    List<Teacher> search(@Param("name") String name, Pageable pageable);
}
