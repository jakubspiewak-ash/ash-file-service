package com.jakubspiewak.ashfileservice.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "file_table")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class FileEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "bytes")
    private byte[] bytes;

    @Column(name = "name")
    private String name;
}
