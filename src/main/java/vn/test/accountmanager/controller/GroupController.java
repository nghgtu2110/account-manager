package vn.test.accountmanager.controller;

import lombok.RequiredArgsConstructor;
import vn.test.accountmanager.dto.request.GroupCreateDTO;
import vn.test.accountmanager.dto.request.GroupUpdateDTO;
import vn.test.accountmanager.dto.response.ApiResponse;
import vn.test.accountmanager.dto.response.GroupResponseDTO;
import vn.test.accountmanager.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/groups")
@Validated
@RequiredArgsConstructor
@Tag(name = "Group Management", description = "Các API Quản lý Nhóm (Group)")
public class GroupController {

    private final GroupService groupService;

//    public GroupController(GroupService groupService) {
//        this.groupService = groupService;
//    }

    @PostMapping
    @Operation(summary = "Tạo mới Group")
    public ResponseEntity<ApiResponse<GroupResponseDTO>> createGroup(@Valid @RequestBody GroupCreateDTO request) {
        GroupResponseDTO response = groupService.createGroup(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Tạo nhóm thành công", response));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Cập nhật Group theo ID")
    public ResponseEntity<ApiResponse<GroupResponseDTO>> updateGroup(
            @PathVariable Long id,
            @Valid @RequestBody GroupUpdateDTO request) {
        GroupResponseDTO response = groupService.updateGroup(id, request);
        return ResponseEntity.ok(ApiResponse.success("Cập nhật nhóm thành công", response));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Xóa Group theo ID")
    public ResponseEntity<ApiResponse<Void>> deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return ResponseEntity.ok(ApiResponse.success("Xóa nhóm thành công"));
    }

    @GetMapping
    @Operation(summary = "Tìm kiếm & Lấy danh sách Group")
    public ResponseEntity<ApiResponse<List<GroupResponseDTO>>> searchGroups(
            @RequestParam(required = false) String search) {
        List<GroupResponseDTO> result = groupService.searchGroups(search);
        return ResponseEntity.ok(ApiResponse.success("Lấy danh sách nhóm thành công", result));
    }
}