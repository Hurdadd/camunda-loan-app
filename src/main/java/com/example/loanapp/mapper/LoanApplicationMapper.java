package com.example.loanapp.mapper;

import com.example.loanapp.dto.request.LoanApplicationRequest;
import com.example.loanapp.dto.response.LoanApplicationResponse;
import com.example.loanapp.model.LoanApplication;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface LoanApplicationMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "status", ignore = true),
            @Mapping(target = "processInstanceId", ignore = true),
            @Mapping(target = "creationDate", ignore = true)
    })
    LoanApplication toEntity(LoanApplicationRequest request);

    LoanApplicationResponse toDto(LoanApplication entity);
}