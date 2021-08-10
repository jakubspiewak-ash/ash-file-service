package com.jakubspiewak.ashfileservice.service;

import com.jakubspiewak.ashapimodellib.model.file.ApiFileCreateRequest;
import com.jakubspiewak.ashapimodellib.model.file.ApiFileGetResponse;
import org.mapstruct.Mapper;

@Mapper
public interface FileMapper {

    FileEntity fromRequestToEntity(ApiFileCreateRequest source);

    ApiFileGetResponse fromEntityToResponse(FileEntity source);
}
