package vn.test.accountmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`groups`")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name", nullable = false, length = 50)
    private String groupName;

    @Column(name = "creator", nullable = false, length = 50)
    private String creator;

    @Column(name = "member_count", nullable = false)
    private Integer memberCount = 0;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private Set<Account> accounts = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Group() {}

    public Group(String groupName, String creator) {
        this.groupName = groupName;
        this.creator = creator;
    }

}