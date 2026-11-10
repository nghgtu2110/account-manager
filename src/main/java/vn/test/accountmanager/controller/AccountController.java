package vn.test.accountmanager.controller;

import vn.test.accountmanager.dto.request.AccountRequestDTO;
import vn.test.accountmanager.dto.response.AccountResponseDTO;
import vn.test.accountmanager.dto.response.ApiResponse;
import vn.test.accountmanager.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/accounts")
@Validated
@Tag(name = "Account Management", description = "Các API Quản lý Tài khoản (Account)")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @Operation(summary = "Tạo mới / Đăng ký Account")
    public ResponseEntity<ApiResponse<AccountResponseDTO>> createAccount(@Valid @RequestBody AccountRequestDTO request) {
        AccountResponseDTO response = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Tạo tài khoản thành công", response));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Cập nhật Account theo ID")
    public ResponseEntity<ApiResponse<AccountResponseDTO>> updateAccount(
            @PathVariable Long id,
            @Valid @RequestBody AccountRequestDTO request) {
        AccountResponseDTO response = accountService.updateAccount(id, request);
        return ResponseEntity.ok(ApiResponse.success("Cập nhật tài khoản thành công", response));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Xóa Account theo ID")
    public ResponseEntity<ApiResponse<Void>> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok(ApiResponse.success("Xóa tài khoản thành công"));
    }

    @GetMapping
    @Operation(summary = "Tìm kiếm & Lọc danh sách Account")
    public ResponseEntity<ApiResponse<List<AccountResponseDTO>>> searchAccounts(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Long groupId) {
        List<AccountResponseDTO> result = accountService.searchAccounts(search, groupId);
        return ResponseEntity.ok(ApiResponse.success("Lấy danh sách tài khoản thành công", result));
    }
}
