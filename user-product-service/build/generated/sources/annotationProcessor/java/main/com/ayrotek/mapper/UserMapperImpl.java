package com.ayrotek.mapper;

import com.ayrotek.dto.request.CreateUserRequestDto;
import com.ayrotek.dto.request.UpdateUserRequestDto;
import com.ayrotek.repository.entity.User;
import com.ayrotek.repository.entity.User.UserBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-21T10:02:17+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User createToUser(CreateUserRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.firstName( dto.getFirstName() );
        user.lastName( dto.getLastName() );

        return user.build();
    }

    @Override
    public User updateToUser(UpdateUserRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.id( dto.getId() );
        user.firstName( dto.getFirstName() );
        user.lastName( dto.getLastName() );

        return user.build();
    }
}
