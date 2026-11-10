package vn.test.accountmanager.service;

import vn.test.accountmanager.dto.request.AccountRequestDTO;
import vn.test.accountmanager.dto.response.AccountResponseDTO;

import java.util.List;

public interface AccountService {
    AccountResponseDTO createAccount(AccountRequestDTO request);
    AccountResponseDTO updateAccount(Long id, AccountRequestDTO request);
    void deleteAccount(Long id);
    List<AccountResponseDTO> searchAccounts(String keyword, Long groupId);
}