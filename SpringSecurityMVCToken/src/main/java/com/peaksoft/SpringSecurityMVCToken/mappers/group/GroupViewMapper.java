package com.peaksoft.SpringSecurityMVCToken.mappers.group;

import com.peaksoft.SpringSecurityMVCToken.dto.group.GroupResponse;
import com.peaksoft.SpringSecurityMVCToken.models.Group;
import com.peaksoft.SpringSecurityMVCToken.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GroupViewMapper {

    private final GroupRepository repository;

    public GroupResponse viewGroup(Group group) {
        if (group == null) {
            return null;
        }
        GroupResponse response = new GroupResponse();
        if (group.getId() != null) {
            response.setId(group.getId());
        }
        response.setGroup_name(group.getGroupName());
        response.setDate_of_start(group.getDateOfStart());
        response.setDate_of_finish(group.getDateOfFinish());
        response.setCourses(group.getCourses());
        return response;
    }

    public List<GroupResponse> viewGroups(List<Group> groups) {
        List<GroupResponse> responses = new ArrayList<>();
        for (Group group : groups) {
            responses.add(viewGroup(group));
        }
        return responses;
    }

    public List<Group> searchGroupByDate(String name, Pageable pageable) {
        String text = name == null ? "" : name;
        return repository.search(text.toUpperCase(), pageable);
    }
}
