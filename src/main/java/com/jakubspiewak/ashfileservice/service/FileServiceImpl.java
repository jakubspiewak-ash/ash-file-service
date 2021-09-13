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

  @Override
  public UUID save(final ApiFileCreateRequest request) {
    final var entity = fromRequestToEntity(request);
    return fileRepository.save(entity).getId();
  }

  @Override
  public ApiFileGetResponse get(final UUID id) {
    return fileRepository.findById(id).map(this::fromEntityToResponse).orElseThrow();
  }

  @Override
  public void delete(final UUID id) {
    fileRepository.deleteById(id);
  }

  private ApiFileGetResponse fromEntityToResponse(FileEntity entity) {
    return ApiFileGetResponse.builder().file(entity.getBytes()).fileName(entity.getName()).build();
  }

  private FileEntity fromRequestToEntity(ApiFileCreateRequest request) {
    return FileEntity.builder().bytes(request.getFile()).name(request.getFileName()).build();
  }

}
