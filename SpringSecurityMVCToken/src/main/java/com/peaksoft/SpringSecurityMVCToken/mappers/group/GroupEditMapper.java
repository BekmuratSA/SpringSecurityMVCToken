package com.peaksoft.SpringSecurityMVCToken.mappers.group;

import com.peaksoft.SpringSecurityMVCToken.dto.group.GroupRequest;
import com.peaksoft.SpringSecurityMVCToken.models.Course;
import com.peaksoft.SpringSecurityMVCToken.models.Group;
import com.peaksoft.SpringSecurityMVCToken.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GroupEditMapper {

    private final CourseRepository courseRepository;

    public Group createGroup(GroupRequest request) {
        if (request == null) {
            return null;
        }
        Group group = new Group();
        group.setGroupName(request.getGroup_name());
        group.setDateOfStart(request.getDate_of_start());
        group.setDateOfFinish(request.getDate_of_finish());

        List<Course> courses = new ArrayList<>();
        Course course = courseRepository.findById(request.getCourse()).get();
        courses.add(course);
        group.setCourses(courses);
        return group;
    }

    public Group updateGroup(Group group, GroupRequest request) {
        group.setGroupName(request.getGroup_name());
        group.setDateOfStart(request.getDate_of_start());
        group.setDateOfFinish(request.getDate_of_finish());

        List<Course> courses = new ArrayList<>();
        Course course = courseRepository.findById(request.getCourse()).get();
        courses.add(course);
        group.setCourses(courses);
        return group;
    }
}
