package vn.test.accountmanager.service;

import vn.test.accountmanager.dto.request.GroupCreateDTO;
import vn.test.accountmanager.dto.request.GroupUpdateDTO;
import vn.test.accountmanager.dto.response.GroupResponseDTO;

import java.util.List;

public interface GroupService {
    GroupResponseDTO createGroup(GroupCreateDTO request);
    GroupResponseDTO updateGroup(Long id, GroupUpdateDTO request);
    void deleteGroup(Long id);
    List<GroupResponseDTO> searchGroups(String keyword);
}