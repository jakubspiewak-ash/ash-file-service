package com.jakubspiewak.ashfileservice.service;

import com.jakubspiewak.ashapimodellib.model.file.ApiFileCreateRequest;
import com.jakubspiewak.ashapimodellib.model.file.ApiFileGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final FileMapper fileMapper;

    @Override
    public UUID save(final ApiFileCreateRequest request) {
        final var entity = fileMapper.fromRequestToEntity(request);
        return fileRepository.save(entity).getId();
    }

    @Override
    public ApiFileGetResponse get(final UUID id) {
        return fileRepository.findById(id).map(fileMapper::fromEntityToResponse).orElseThrow();
    }

    @Override
    public void delete(final UUID id) {
        fileRepository.deleteById(id);
    }
}
