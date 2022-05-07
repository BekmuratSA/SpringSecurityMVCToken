package com.peaksoft.SpringSecurityMVCToken.repository;

import com.peaksoft.SpringSecurityMVCToken.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
