package com.ayrotek.mapper;

import com.ayrotek.dto.request.CreateUserRequestDto;
import com.ayrotek.dto.request.UpdateUserRequestDto;
import com.ayrotek.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User createToUser (CreateUserRequestDto dto);
    User updateToUser (UpdateUserRequestDto dto);
}
