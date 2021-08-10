package com.jakubspiewak.ashfileservice.service;

import com.jakubspiewak.ashapimodellib.model.file.ApiFileCreateRequest;
import com.jakubspiewak.ashapimodellib.model.file.ApiFileGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<UUID> save(@RequestBody final ApiFileCreateRequest request) {

        final var id = fileService.save(request);

        return ResponseEntity.status(CREATED).body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiFileGetResponse> get(@PathVariable final UUID id) {

        final var response = fileService.get(id);

        return ResponseEntity.status(OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final UUID id) {

        fileService.delete(id);

        return ResponseEntity.status(OK).build();
    }
}
