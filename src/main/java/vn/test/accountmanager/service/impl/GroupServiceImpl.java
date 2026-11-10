package vn.test.accountmanager.service.impl;

import vn.test.accountmanager.dto.request.GroupCreateDTO;
import vn.test.accountmanager.dto.request.GroupUpdateDTO;
import vn.test.accountmanager.dto.response.GroupResponseDTO;
import vn.test.accountmanager.service.GroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Override
    @Transactional
    public GroupResponseDTO createGroup(GroupCreateDTO request) {
        String currentLoginUser = "admin";
        return new GroupResponseDTO(request.getGroupName(), currentLoginUser, 0, LocalDateTime.now());
    }

    @Override
    @Transactional
    public GroupResponseDTO updateGroup(Long id, GroupUpdateDTO request) {
        return new GroupResponseDTO(request.getGroupName(), "admin", 5, LocalDateTime.now());
    }

    @Override
    @Transactional
    public void deleteGroup(Long id) {
        // Xóa group
    }

    @Override
    @Transactional(readOnly = true)
    public List<GroupResponseDTO> searchGroups(String keyword) {
        List<GroupResponseDTO> list = new ArrayList<>();

        return list;
    }
}