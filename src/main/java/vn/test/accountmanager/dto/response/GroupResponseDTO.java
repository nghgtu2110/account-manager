package vn.test.accountmanager.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
public class GroupResponseDTO {

    private String groupName;
    private String creator;
    private Integer memberCount;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

}