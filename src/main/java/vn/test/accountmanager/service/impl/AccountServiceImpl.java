package vn.test.accountmanager.service.impl;

import vn.test.accountmanager.dto.request.AccountRequestDTO;
import vn.test.accountmanager.dto.response.AccountResponseDTO;
import vn.test.accountmanager.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    @Transactional
    public AccountResponseDTO createAccount(AccountRequestDTO request) {
        return new AccountResponseDTO(
                request.getUsername(),
                request.getEmail(),
                request.getFullName(),
                request.getPhoneNumber(),
                request.getGender(),
                request.getGroups()
        );
    }

    @Override
    @Transactional
    public AccountResponseDTO updateAccount(Long id, AccountRequestDTO request) {
        return new AccountResponseDTO(
                request.getUsername(),
                request.getEmail(),
                request.getFullName(),
                request.getPhoneNumber(),
                request.getGender(),
                request.getGroups()
        );
    }

    @Override
    @Transactional
    public void deleteAccount(Long id) {
        // Xóa Account
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountResponseDTO> searchAccounts(String keyword, Long groupId) {
        List<AccountResponseDTO> list = new ArrayList<>();
        list.add(new AccountResponseDTO("nguyen_van_a", "a@gmail.com", "Nguyễn Văn A", "0912345678", "MALE", List.of(1L, 2L)));
        return list;
    }
}