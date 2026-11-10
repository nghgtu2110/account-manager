package vn.test.accountmanager.dto.request;

import lombok.*;
import vn.test.accountmanager.entity.Group;
import vn.test.accountmanager.validation.ValidGender;
import jakarta.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequestDTO {

    @NotBlank(message = "{account.username.notblank}")
    @Size(min = 3, max = 20, message = "{account.username.size}")
    private String username;

    @NotBlank(message = "{account.pass.notblank}")
    @Size(min = 8, message = "{account.pass.size}")
    private String rawPassword;

    @NotBlank(message = "Email không được trống")
    @Email(message = "{account.email.invalid}")
    private String email;

    @NotBlank(message = "Họ tên không được trống")
    private String fullName;

    @NotBlank(message = "Số điện thoại không được trống")
    @Pattern(regexp = "^0[0-9]{9}$", message = "{account.phone.pattern}")
    private String phoneNumber;

    private String dateOfBirth;
    private String address;

    @NotNull(message = "Cần xác nhận điều khoản")
    @AssertTrue(message = "{account.policy.agree}")
    private Boolean isAgreedPolicy;

    @ValidGender
    private String gender;

    private String securityQuestion;
    private String securityAnswer;

    // Danh sách groups cho phép account thuộc nhiều Group
    private List<Group> groups;

}