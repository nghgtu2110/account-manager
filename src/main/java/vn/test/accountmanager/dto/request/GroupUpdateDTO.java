package vn.test.accountmanager.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
public class GroupUpdateDTO {

    @NotBlank(message = "{group.name.notblank}")
    @Size(min = 3, max = 50, message = "{group.name.size}")
    private String groupName;

}