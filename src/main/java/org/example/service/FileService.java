package org.example.service;

import org.example.model.File;

import java.io.InputStream;

public interface FileService extends GenericService<File, Integer>{
    File uploadFile(InputStream inputStream, Integer userId);
}
