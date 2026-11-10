package vn.test.accountmanager.dto.response;

import lombok.*;
import vn.test.accountmanager.entity.Group;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponseDTO {

    private String username;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String gender;
    private List<Group> groups;

}