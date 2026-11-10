

package vn.test.accountmanager.repository;

import vn.test.accountmanager.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    // Tìm kiếm Account theo tên/email/sđt và lọc theo groupId
    @Query("SELECT DISTINCT a FROM Account a LEFT JOIN a.groups g WHERE " +
            "(:keyword IS NULL OR LOWER(a.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(a.fullName) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
            "(:groupId IS NULL OR g.id = :groupId)")
    List<Account> searchAccounts(@Param("keyword") String keyword, @Param("groupId") Long groupId);
}