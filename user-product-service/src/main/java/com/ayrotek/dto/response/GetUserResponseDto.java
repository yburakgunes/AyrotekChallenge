package com.ayrotek.dto.response;

import com.ayrotek.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetUserResponseDto {
    private long id;
    private String firstName;
    private String lastName;
    private Date creationDate;

    public GetUserResponseDto(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.creationDate = user.getCreationDate();
    }
}
