package com.example.demo.DTOsMappers;

import com.example.demo.DTOs.user_accountDTO;
import com.example.demo.Entities.AccountEntites.user_account;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface user_accountMapper {

    user_account toEntity(user_accountDTO user_accountDTO);

    user_accountDTO toDto(user_account user_account);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(user_accountDTO user_accountDTO, @MappingTarget user_account user_account);
}
