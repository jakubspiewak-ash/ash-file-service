package com.jakubspiewak.ashfileservice.service;

import com.jakubspiewak.ashapimodellib.model.file.ApiFileCreateRequest;
import com.jakubspiewak.ashapimodellib.model.file.ApiFileGetResponse;

import java.util.UUID;

public interface FileService {

    UUID save(ApiFileCreateRequest request);

    ApiFileGetResponse get(UUID id);

    void delete(UUID id);

}
