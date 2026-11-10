package vn.test.accountmanager.repository;

import vn.test.accountmanager.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findByGroupNameContainingIgnoreCase(String keyword);

    boolean existsByGroupName(String groupName);
}
